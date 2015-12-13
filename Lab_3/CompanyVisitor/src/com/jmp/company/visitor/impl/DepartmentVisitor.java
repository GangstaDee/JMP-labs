package com.jmp.company.visitor.impl;

import com.jmp.company.visitable.entity.Company;
import com.jmp.company.visitable.entity.Department;
import com.jmp.company.visitable.entity.Employee;
import com.jmp.company.visitor.Visitor;

import java.util.List;

/**
 * Created on 13.12.2015.
 */
public class DepartmentVisitor implements Visitor {

    private int departmentSize;
    private int departmentTotalSalary;
    private Department department;

    public DepartmentVisitor(Department department) {
        this.department = department;
    }

    @Override
    public void visit(Company company) {

        List<Employee> employees = company.getEmployees(department);
        if(employees == null) {
            departmentSize = 0;
            departmentTotalSalary = 0;
            return;
        }
        departmentSize = employees.size();
        for(Employee emp: employees) {
            departmentTotalSalary += emp.getSalary();
        }
    }

    public int getDepartmentSize() {

        return departmentSize;
    }

    public int getDepartmentTotalSalary() {

        return departmentTotalSalary;
    }
}
