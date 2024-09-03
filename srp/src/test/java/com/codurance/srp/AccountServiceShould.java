package com.codurance.srp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {

    private static final LocalDate TODAY = LocalDate.of(2017, 9, 6);
    private static final List<Transaction> TRANSACTIONS = Arrays.asList(
            new Transaction(LocalDate.of(2014, 4, 1), 1000),
            new Transaction(LocalDate.of(2014, 4, 2), -100),
            new Transaction(LocalDate.of(2014, 4, 10), 500)
    );

    private final MockTransactionRepository transactionRepository = new MockTransactionRepository();
    private final ToStringConsole console = new ToStringConsole();

    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        Clock clock = mock(Clock.class);
        lenient().doReturn(TODAY).when(clock).today();

        TransactionPrinter transactionPrinter = new TransactionPrinter(console);
        TransactionBuilder transactionBuilder = new TransactionBuilder(clock);
        accountService = new AccountService(transactionRepository, transactionPrinter, transactionBuilder);
    }

    @AfterEach
    public void tearDown() {
        transactionRepository.clear();
        console.clear();
    }

    @Test
    public void deposit_amount_into_the_account() {
        accountService.deposit(100);

        List<Transaction> allTransactions = transactionRepository.all();
        assertThat(allTransactions).hasSize(1);
        assertThat(allTransactions.getFirst()).isEqualTo(new Transaction(TODAY, 100));
    }


    @Test
    public void withdraw_amount_from_the_account() {
        accountService.withdraw(100);

        List<Transaction> allTransactions = transactionRepository.all();
        assertThat(allTransactions).hasSize(1);
        assertThat(allTransactions.getFirst()).isEqualTo(new Transaction(TODAY, -100));
    }

    @Test
    public void print_statement() {
        TRANSACTIONS.forEach(transactionRepository::add);

        accountService.printStatements();

        assertThat(console.content()).isEqualTo(
                """
                        DATE | AMOUNT | BALANCE
                        10/04/2014 | 500.00 | 1400.00
                        02/04/2014 | -100.00 | 900.00
                        01/04/2014 | 1000.00 | 1000.00
                        """
        );
    }
}
