package com.codurance.srp;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MoneyTransferService {
    private final TransactionRepository transactionRepository;
    private final Clock clock;

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }

    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }
}
