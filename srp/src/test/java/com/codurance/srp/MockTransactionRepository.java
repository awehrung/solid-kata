package com.codurance.srp;

import java.util.ArrayList;
import java.util.List;

public class MockTransactionRepository implements TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> all() {
        return List.copyOf(transactions);
    }
    
    public void clear() {
        transactions.clear();
    }
}
