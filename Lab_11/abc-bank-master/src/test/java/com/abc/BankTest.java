package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

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
