package com.jmp.api;

import com.jmp.entity.Unit;

public interface UnitService {

    Unit save(Unit unit);

    Unit find(int unitID);

    int delete(int unitID);
}
