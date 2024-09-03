package com.codurance.srp;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountService {

    private final TransactionRepository transactionRepository;
    private final TransactionPrinter transactionPrinter;
    private final TransactionBuilder transactionBuilder;

    public void deposit(int amount) {
        transactionRepository.add(transactionBuilder.ofAmount(amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(transactionBuilder.ofAmount(-amount));
    }

    public void printStatements() {
        transactionPrinter.printStatements(transactionRepository.all());
    }
}
