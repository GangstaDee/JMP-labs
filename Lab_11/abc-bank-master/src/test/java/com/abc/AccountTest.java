package com.abc;

import org.junit.Test;

/**
 * Created on 2/28/2016.
 */
public class AccountTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkDeposit_NegativeValue() {
        Account account = new Account(Account.CHECKING);
        account.deposit(-5D);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDeposit_ZeroValue() {
        Account account = new Account(Account.CHECKING);
        account.deposit(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkWithdrawing_NegativeValue() {
        Account account = new Account(Account.CHECKING);
        account.withdraw(-10D);
    }

}
