package com.enigma.rmsederhanaapp.repository.implementation;

import com.enigma.rmsederhanaapp.config.DbConnector;
import com.enigma.rmsederhanaapp.entity.Food;
import com.enigma.rmsederhanaapp.repository.FoodRepository;

import java.sql.*;
import java.util.List;

public class FoodRepositoryImplementation implements FoodRepository {
    @Override
    public Food save(Food food) {
        try (Connection connection = DbConnector.connect()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO m_food (name, price) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, food.getName());
            statement.setLong(2, food.getPrice());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                System.out.println("ID: " + generatedKeys.getInt(1));
                food.setId(generatedKeys.getInt(1));
            }

            generatedKeys.close();
            statement.close();
            return food;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Food findById(Integer id) {
        return null;
    }

    @Override
    public List<Food> findAll() {
        return null;
    }

    @Override
    public Food update(Food food) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
