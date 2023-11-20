package com.enigma.rmsederhanaapp.repository.implementation;

import com.enigma.rmsederhanaapp.config.DbConnector;
import com.enigma.rmsederhanaapp.entity.Visitor;
import com.enigma.rmsederhanaapp.repository.VisitorRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VisitorRepositoryImplementation implements VisitorRepository {
    @Override
    public void save(Visitor visitor) {
        try (Connection connection = DbConnector.connect()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO m_visitor VALUES (?, ?, ? ,?)");
            statement.setInt(1, visitor.getId());
            statement.setString(2, visitor.getVisitorName());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Visitor findById(Integer id) {
        return null;
    }

    @Override
    public List<Visitor> findAll() {
        return null;
    }

    @Override
    public void update(Visitor visitor) {

    }
    @Override
    public void deleteById(Integer id) {

    }
}
