package com.jmp.dao.impl;

import com.jmp.dao.UnitDAO;
import com.jmp.entity.Unit;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UnitDAOImpl implements UnitDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Unit save(Unit unit) {

        if (unit.getId() == null) {
            entityManager.persist(unit);
        } else {
            unit = this.entityManager.merge(unit);
        }
        return unit;
    }

    @Override
    public Unit read(int unitID) {
        return entityManager.find(Unit.class, unitID);
    }

    @Override
    public Unit readFullDetails(int unitID) {
        try {
            Query q = this.entityManager.createQuery("SELECT unit FROM Unit unit LEFT JOIN FETCH unit.employees emp WHERE unit.id = :id");
            q.setParameter("id", unitID);
            return (Unit) q.getSingleResult();

        }  catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public int delete(int unitID) {
        Query query = entityManager.createQuery(
                "DELETE FROM Unit u WHERE u.id = :param");
        int removed = query.setParameter("param", unitID).executeUpdate();
        return removed;
    }
}
