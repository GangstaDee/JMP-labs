package com.jmp.dao;

import com.jmp.entity.Unit;

public interface UnitDAO {

    Unit save(Unit unit);

    Unit read(int unitID);

    Unit readFullDetails(int unitID);

    int delete(int unitID);
}
