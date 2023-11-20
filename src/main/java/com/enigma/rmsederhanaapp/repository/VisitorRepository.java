package com.enigma.rmsederhanaapp.repository;

import com.enigma.rmsederhanaapp.entity.Visitor;

import java.util.List;

public interface VisitorRepository {
    // insert
    void save(Visitor visitor);
    // select by id
    Visitor findById(Integer id);
    // select *
    List<Visitor> findAll();
    // update
    void update(Visitor visitor);
    // delete by id
    void deleteById(Integer id);
}
