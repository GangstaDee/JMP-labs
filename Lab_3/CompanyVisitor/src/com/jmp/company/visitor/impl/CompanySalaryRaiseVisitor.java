package com.jmp.company.visitor.impl;

import com.jmp.company.visitable.entity.Company;
import com.jmp.company.visitor.Visitor;

/**
 * Created on 13.12.2015.
 */
public class CompanySalaryRaiseVisitor implements Visitor {

    private int salaryRaise;

    @Override
    public void visit(Company company) {

        salaryRaise = company.getSalaryRaise();
    }

    public int getSalaryRaise() {

        return salaryRaise;
    }
}
