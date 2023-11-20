package com.enigma.rmsederhanaapp.repository;

import com.enigma.rmsederhanaapp.entity.Food;

import java.util.List;

public interface FoodRepository {
    Food save(Food food);
    Food findById(Integer id);
    List<Food> findAll();
    Food update(Food food);
    void deleteById(Integer id);
}
