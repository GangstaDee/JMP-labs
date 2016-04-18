package com.jmp.dao.impl;

import com.jmp.dao.EmployeeDAO;
import com.jmp.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee save(Employee employee) {

        if (employee.getId() == null) {
            entityManager.persist(employee);
        } else {
            employee = entityManager.merge(employee);
        }
        return employee;
    }

    @Override
    public Employee read(int employeeID) {
        return entityManager.find(Employee.class, employeeID);
    }

    @Override
    public Employee readFullDetails(int employeeID) {

        try {
            Query q = this.entityManager.createQuery("SELECT employee FROM Employee employee LEFT JOIN FETCH employee.projects proj WHERE employee.id = :id");
            q.setParameter("id", employeeID);
            return (Employee) q.getSingleResult();

        }  catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public int delete(int employeeID) {

        Employee emp = read(employeeID);
        if(emp == null) return 0;
        entityManager.remove(emp);
        return 1;

    }

}
