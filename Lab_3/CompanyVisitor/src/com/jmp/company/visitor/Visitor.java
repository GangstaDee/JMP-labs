package com.jmp.company.visitor;

import com.jmp.company.visitable.entity.Company;

/**
 * Created on 13.12.2015.
 */
public interface Visitor {

    void visit(Company company);
}
