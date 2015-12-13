package com.jmp.company.visitor.impl;

import com.jmp.company.visitable.entity.Company;
import com.jmp.company.visitor.Visitor;

/**
 * Created on 13.12.2015.
 */
public class CompanyAverageSalaryVisitor implements Visitor {

    private double averageSalary;

    @Override
    public void visit(Company company) {

        CompanyTotalSalaryVisitor salaryVisitor = new CompanyTotalSalaryVisitor();
        company.accept(salaryVisitor);
        int totalSalary = salaryVisitor.getTotalSalary();

        CompanySizeVisitor sizeVisitor = new CompanySizeVisitor();
        company.accept(sizeVisitor);
        int size = sizeVisitor.getCompanySize();

        averageSalary = totalSalary / size;
    }

    public double getAverageSalary() {

        return averageSalary;
    }
}
