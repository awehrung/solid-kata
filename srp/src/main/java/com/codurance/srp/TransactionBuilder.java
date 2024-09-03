package com.codurance.srp;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionBuilder {

    private final Clock clock;
    
    public Transaction ofAmount(int amount) {
        return new Transaction(clock.today(), amount);
    }
}
