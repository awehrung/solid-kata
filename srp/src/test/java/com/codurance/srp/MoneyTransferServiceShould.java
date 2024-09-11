package com.codurance.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MoneyTransferServiceShould {

    private static final int POSITIVE_AMOUNT = 100;
    private static final int NEGATIVE_AMOUNT = -POSITIVE_AMOUNT;
    private static final LocalDate TODAY = LocalDate.of(2017, 9, 6);

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private Clock clock;

    @InjectMocks
    private MoneyTransferService moneyTransferService;

    @BeforeEach
    public void setUp() {
        doReturn(TODAY).when(clock).today();
    }

    @Test
    public void deposit_amount_into_the_account() {
        moneyTransferService.deposit(POSITIVE_AMOUNT);

        verify(transactionRepository).add(refEq(new Transaction(TODAY, POSITIVE_AMOUNT)));
    }

    @Test
    public void withdraw_amount_from_the_account() {
        moneyTransferService.withdraw(POSITIVE_AMOUNT);

        verify(transactionRepository).add(refEq(new Transaction(TODAY, NEGATIVE_AMOUNT)));
    }
}
