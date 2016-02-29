package com.abc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        if(customer == null) {
            throw new IllegalArgumentException("Customer should not be null");
        }
        customers.add(customer);
    }

    public String customerSummary() {
        String summary = "Customer Summary";
        for (Customer c : customers)
            summary += "\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")";
        return summary;
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

    public double totalInterestPaid() {
        double total = 0;
        for(Customer c: customers)
            total += c.totalInterestEarned();
        return total;
    }

    public String getFirstCustomerName() {
        if(customers.size() > 0) {
            customers.sort(new Comparator<Customer>() {
                public int compare(Customer o1, Customer o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        //    List<Customer> sorted = customers.stream().sorted((s1, s2) ->
        //            s1.getName().compareTo(s2.getName())).collect(Collectors.toList());
        //    return sorted.get(0).getName();

            return customers.get(0).getName();
        }
        return "No customers :(";
    }
}
