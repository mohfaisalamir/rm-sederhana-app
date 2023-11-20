package com.enigma.rmsederhanaapp.repository.implementation;

import com.enigma.rmsederhanaapp.config.DbConnector;
import com.enigma.rmsederhanaapp.dto.TransactionDetailRequest;
import com.enigma.rmsederhanaapp.dto.TransactionDetailResponse;
import com.enigma.rmsederhanaapp.dto.TransactionRequest;
import com.enigma.rmsederhanaapp.dto.TransactionResponse;
import com.enigma.rmsederhanaapp.repository.TransactionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepositoryImplementation implements TransactionRepository {
    @Override
    public void save(TransactionRequest request) {
        try (Connection connection = DbConnector.connect()) {
            connection.setAutoCommit(false);
            // 1. insert transaction
            PreparedStatement transactionStatement = connection.prepareStatement(
                    "INSERT INTO t_transaction (trans_date, visitor_id) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            transactionStatement.setDate(1, new Date(System.currentTimeMillis()));
            transactionStatement.setInt(2, request.getVisitorId());
            transactionStatement.executeUpdate();

            // 2. ambil id dari transaction
            int transactionId = 0;
            ResultSet generatedKeys = transactionStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                transactionId = generatedKeys.getInt(1);
            } else {
                connection.rollback();
            }

            transactionStatement.close();

            // 3. insert transaction detail
            PreparedStatement transactionDetailStatement = connection.prepareStatement("INSERT INTO t_transaction_detail (transaction_id, food_id, quantity) VALUES (?, ?, ?)");
            for (TransactionDetailRequest transactionDetail : request.getTransactionDetails()) {
                transactionDetailStatement.clearParameters();
                transactionDetailStatement.setInt(1, transactionId);
                transactionDetailStatement.setInt(2, transactionDetail.getFoodId());
                transactionDetailStatement.setInt(3, transactionDetail.getQuantity());
                transactionDetailStatement.addBatch();
            }
            transactionDetailStatement.executeBatch();
            transactionDetailStatement.close();

            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TransactionResponse findById(Integer id) {
        if (id == null) {
            throw new RuntimeException("id cannot be null");
        }

        try (Connection connection = DbConnector.connect()) {
            PreparedStatement statement = connection.prepareStatement("SELECT \n" +
                    "\tt.id transaction_id,\n" +
                    "\tt.trans_date trans_date,\n" +
                    "\tmc.visitor_name visitor_name,\n" +
                    "\tmp.name food_name,\n" +
                    "\tmp.price food_price,\n" +
                    "\ttod.quantity qty,\n" +
                    "\tmp.price * quantity sub_total\n" +
                    "FROM t_transaction t\n" +
                    "JOIN m_visitor mc ON t.visitor_id = mc.id\n" +
                    "JOIN t_transaction_detail tod ON t.id = tod.transaction_id\n" +
                    "JOIN m_food mp ON mp.id = tod.food_id WHERE t.id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Map<Integer, TransactionResponse> transactionMap = getTransactionMap(resultSet);
            resultSet.close();
            statement.close();
            return transactionMap.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TransactionResponse> findAll() {
        try (Connection connection = DbConnector.connect()) {
            PreparedStatement statement = connection.prepareStatement("SELECT \n" +
                    "\tt.id transaction_id,\n" +
                    "\tt.trans_date trans_date,\n" +
                    "\tmc.visitor_name visitor_name,\n" +
                    "\tmp.name food_name,\n" +
                    "\tmp.price food_price,\n" +
                    "\ttod.quantity qty,\n" +
                    "\tmp.price * quantity sub_total\n" +
                    "FROM t_transaction t\n" +
                    "JOIN m_visitor mc ON t.visitor_id = mc.id\n" +
                    "JOIN t_transaction_detail tod ON t.id = tod.transaction_id\n" +
                    "JOIN m_food mp ON mp.id = tod.food_id");
            ResultSet resultSet = statement.executeQuery();
            Map<Integer, TransactionResponse> transactionMap = getTransactionMap(resultSet);

            resultSet.close();
            statement.close();
            return new ArrayList<>(transactionMap.values());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<Integer, TransactionResponse> getTransactionMap(ResultSet resultSet) throws SQLException {
        Map<Integer, TransactionResponse> transactionMap = new HashMap<>();
        while (resultSet.next()) {
            int transactionId = resultSet.getInt("transaction_id");
            Date transDate = resultSet.getDate("trans_date");
            String visitorName = resultSet.getString("visitor_name");
            String foodName = resultSet.getString("food_name");
            long foodPrice = resultSet.getLong("food_price");
            int qty = resultSet.getInt("qty");
            long subTotal = resultSet.getLong("sub_total");

            TransactionResponse transactionResponse = transactionMap.get(transactionId);
            if (transactionResponse == null) {
                transactionResponse = new TransactionResponse(
                        transactionId,
                        transDate,
                        visitorName
                );
                transactionMap.put(transactionId, transactionResponse);
            }

            TransactionDetailResponse transactionDetailResponse = new TransactionDetailResponse(foodName, foodPrice, qty, subTotal);
            transactionResponse.addTransactionDetail(transactionDetailResponse);
        }
        return transactionMap;
    }

}
