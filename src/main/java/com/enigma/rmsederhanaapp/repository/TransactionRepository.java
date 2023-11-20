package com.enigma.rmsederhanaapp.repository;

import com.enigma.rmsederhanaapp.dto.TransactionRequest;
import com.enigma.rmsederhanaapp.dto.TransactionResponse;

import java.util.List;

public interface TransactionRepository {
    void save(TransactionRequest request);
    TransactionResponse findById(Integer id);

    List<TransactionResponse> findAll();
}
