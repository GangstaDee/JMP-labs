package com.jmp.api.impl;

import com.jmp.api.UnitService;
import com.jmp.dao.UnitDAO;
import com.jmp.entity.Unit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("unitService")
@Transactional
public class UnitServiceImpl implements UnitService {

    @Resource
    private UnitDAO unitDAO;

    public Unit save(Unit unit) {
        return unitDAO.save(unit);
    }

    public Unit read(int unitID, boolean eager) {
        if(eager) {
            Unit unit = unitDAO.readFullDetails(unitID);
        }
       return unitDAO.read(unitID);
    }

    public int delete(int unitID){
        return unitDAO.delete(unitID);
    }
}
