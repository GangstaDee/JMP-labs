package com.abc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TransactionTest {

    private Bank bank = new Bank();

    private static final double DOUBLE_DELTA = 1e-15;

    private int accountType;
    private double input;
    private double expected;

    public TransactionTest(int accountType, double input, double expected) {
        this.accountType = accountType;
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection transactionParameters() {
        return Arrays.asList(new Object[][] {
                { Account.CHECKING, 100.0, 0.1 },
                { Account.SAVINGS, 500.0, 0.5},
                { Account.SAVINGS, 1500.0, 2.0},
                { Account.MAXI_SAVINGS, 1000.0, 20.0 },
                { Account.MAXI_SAVINGS, 1500.0, 45.0 },
                { Account.MAXI_SAVINGS, 3000.0, 170.0 }
        });
    }

    @Test
    public void testDeposits() {

        Account account = new Account(accountType);
        bank.addCustomer(new Customer("Darya").openAccount(account));
        account.deposit(input);

        assertEquals(expected, bank.totalInterestPaid(), DOUBLE_DELTA);
    }


    @Test
    public void transaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
    }
}
