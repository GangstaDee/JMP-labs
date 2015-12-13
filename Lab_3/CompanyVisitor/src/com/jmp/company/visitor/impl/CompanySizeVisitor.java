package com.jmp.company.visitor.impl;

import com.jmp.company.visitable.entity.Company;
import com.jmp.company.visitable.entity.Department;
import com.jmp.company.visitor.Visitor;

/**
 * Created on 13.12.2015.
 */
public class CompanySizeVisitor implements Visitor {

    private int companySize;

    @Override
    public void visit(Company company) {

        for(Department department : Department.values()) {
            DepartmentVisitor visitor = new DepartmentVisitor(department);
            visitor.visit(company);
            companySize += visitor.getDepartmentSize();
        }
    }

    public int getCompanySize() {

        return companySize;
    }
}
