package com.jmp.company.visitor.impl;

import com.jmp.company.visitable.entity.Company;
import com.jmp.company.visitable.entity.Department;
import com.jmp.company.visitor.Visitor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 13.12.2015.
 */
public class DepartmentStatisticsVisitor implements Visitor {

    private Map<Department, Integer> employeesPerDepartment = new HashMap<>();

    @Override
    public void visit(Company company) {

        for(Department department : Department.values()) {
            DepartmentVisitor visitor = new DepartmentVisitor(department);
            visitor.visit(company);
            employeesPerDepartment.put(department,visitor.getDepartmentSize());
        }
    }

    public Map<Department, Integer> getEmployeesPerDepartment() {

        return employeesPerDepartment;
    }
}
