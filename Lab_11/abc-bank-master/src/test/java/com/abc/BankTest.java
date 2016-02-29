package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    private Bank bank = new Bank();

    @Test
    public void customerSummary_OneAccount() {

        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void customerSummary_TwoAccounts() {

        Customer john = new Customer("John");
        john.openAccount(new Account(Account.CHECKING)).openAccount(new Account(Account.SAVINGS));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (2 accounts)", bank.customerSummary());
    }

    //!!!!!!!!!!!! to replace with one method!!!
    @Test
    public void checkingAccount() {

        Account checkingAccount = new Account(Account.CHECKING);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(100.0);

        assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void savings_account() {

        Account checkingAccount = new Account(Account.SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));
        checkingAccount.deposit(1500.0);

        assertEquals(2.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void maxi_savings_account() {

        Account checkingAccount = new Account(Account.MAXI_SAVINGS);
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));
        checkingAccount.deposit(3000.0);

        assertEquals(170.0, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroCustomers(){
        bank.addCustomer(null);
    }

    @Test
    public void testFirstCustomerName_EmptyBank(){
        assertEquals("No customers :(", bank.getFirstCustomerName());
    }

    @Test
    public void testFirstCustomerName(){
        bank.addCustomer(new Customer("Darya"));
        bank.addCustomer(new Customer("Anna"));
        bank.addCustomer(new Customer("Nella"));
        assertEquals("Anna", bank.getFirstCustomerName());
    }

}
