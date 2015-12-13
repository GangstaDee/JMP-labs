package com.jmp.company.visitable.entity;

import com.jmp.company.visitable.Visitable;
import com.jmp.company.visitor.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 13.12.2015.
 */
public class Company implements Visitable {

    private int salaryRaise;
    private Map<Department, List<Employee>> employees = new HashMap<>();

    public void addEmployee(Department department, Employee employee) {

        List list = employees.get(department);
        if(list == null) {
            list = new ArrayList();
        }
        list.add(employee);
        employees.put(department,list);

    }

    public void setSalaryRaise(int salaryRaise) {

        this.salaryRaise = salaryRaise;
    }

    public List<Employee> getEmployees(Department department) {

        return employees.get(department);
    }

    public int getSalaryRaise() {

        return salaryRaise;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
