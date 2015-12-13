package com.jmp.company.visitor.impl;

import com.jmp.company.visitable.entity.Company;
import com.jmp.company.visitable.entity.Department;

import com.jmp.company.visitor.Visitor;

/**
 * Created on 13.12.2015.
 */
public class CompanyTotalSalaryVisitor implements Visitor {

    private int totalSalary;

    public void visit(Company company) {

        for(Department department : Department.values()) {
            DepartmentVisitor visitor = new DepartmentVisitor(department);
            visitor.visit(company);
            totalSalary += visitor.getDepartmentTotalSalary();
        }
    }

    public int getTotalSalary() {

        return totalSalary;
    }
}
