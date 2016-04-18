package com.jmp.api;

import com.jmp.entity.Unit;

public interface UnitService {

    Unit save(Unit unit);

    Unit read(int unitID, boolean eager);

    int delete(int unitID);
}
