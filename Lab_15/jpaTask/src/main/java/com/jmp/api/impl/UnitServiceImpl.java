package com.jmp.api.impl;

import com.jmp.api.UnitService;
import com.jmp.entity.Unit;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Service("unitService")
@Repository
@Transactional
public class UnitServiceImpl implements UnitService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED) //dirty hack
    private EntityManager entityManager;

    public Unit save(Unit unit) {

        if (unit.getId() == null) {
            entityManager.persist(unit);
        } else {
            unit = this.entityManager.merge(unit);
        }
        return unit;

    }

    public Unit find(int unitID) {
        return entityManager.find(Unit.class, unitID);
    }

    public int delete(int unitID){

        Query query = entityManager.createQuery(
                "DELETE FROM Unit u WHERE u.id = :param");
        int removed = query.setParameter("param", unitID).executeUpdate();
        return removed;

    }
}
