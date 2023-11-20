package com.enigma.rmsederhanaapp;

import com.enigma.rmsederhanaapp.dto.TransactionDetailResponse;
import com.enigma.rmsederhanaapp.dto.TransactionResponse;
import com.enigma.rmsederhanaapp.repository.TransactionRepository;
import com.enigma.rmsederhanaapp.repository.implementation.TransactionRepositoryImplementation;
import java.util.List;

public class RmSederhanaAppApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RmSederhanaAppApplication.class, args);
		TransactionRepository repository = new TransactionRepositoryImplementation();
//        TransactionResponse transactionResponse = repository.findById(2);
		List<TransactionResponse> responses = repository.findAll();

		for (TransactionResponse response : responses) {
			printTransaction(response);
		}

		System.out.println("=".repeat(100));
	}

	private static void printTransaction(TransactionResponse transactionResponse) {
		System.out.println("=".repeat(100));
		System.out.println("Transaction Id: " + transactionResponse.getTransactionId());
		System.out.println("Trans Date: " + transactionResponse.getTransDate());
		System.out.println("Visitor Name: " + transactionResponse.getVisitorName());

		System.out.println("Transaction Details: ");
		for (TransactionDetailResponse transactionDetail : transactionResponse.getTransactionDetails()) {
			System.out.println("-".repeat(100));
			System.out.println("\t Food Name: " + transactionDetail.getFoodName());
			System.out.println("\t Food Price: " + transactionDetail.getFoodPrice());
			System.out.println("\t Qty: " + transactionDetail.getQty());
			System.out.println("\t Sub Total: " + transactionDetail.getSubTotal());
		}
		System.out.println("-".repeat(100));
	}

}

