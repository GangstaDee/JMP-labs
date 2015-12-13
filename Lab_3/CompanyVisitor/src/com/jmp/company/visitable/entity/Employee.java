package com.jmp.company.visitable.entity;

/**
 * Created on 13.12.2015.
 */
public class Employee {

    private String name;
    private int salary;
    private int department;

    public Employee(String name, int salary, int department) {

        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {

        return name;
    }

    public int getSalary() {

        return salary;
    }

    public int getDepartment() {

        return department;
    }
}
