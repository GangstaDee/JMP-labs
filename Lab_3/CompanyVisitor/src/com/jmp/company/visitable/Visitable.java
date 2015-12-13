package com.jmp.company.visitable;

import com.jmp.company.visitor.Visitor;

/**
 * Created on 13.12.2015.
 */
public interface Visitable {

    void accept(Visitor visitor);
}
