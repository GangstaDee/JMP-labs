package com.jmp.api.impl;

import com.jmp.api.EmployeeService;
import com.jmp.api.ProjectService;
import com.jmp.api.UnitService;
import com.jmp.entity.Employee;
import com.jmp.entity.PersonalInfo;
import com.jmp.entity.Project;
import com.jmp.entity.Unit;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Service("employeeService")
@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED) //dirty hack
    private EntityManager entityManager;

    @Resource(name = "unitService")
    private UnitService unitService;

    @Resource(name = "projectService")
    private ProjectService projectService;

    public Employee save(Employee employee){
        if (employee.getId() == null) {
            entityManager.persist(employee);
        } else {
            employee = entityManager.merge(employee);
        }
        return employee;
    }

    public Employee find(int employeeID) {
        return entityManager.find(Employee.class, employeeID);
    }

    public int delete(int employeeID) {

        Employee emp = find(employeeID);
        if(emp == null) return 0;
        entityManager.remove(emp);
        return 1;

    }

    public boolean assignUnit(int employeeID, int unitID) {

        Unit unit = unitService.find(unitID);
        if(unit == null)
            return false;
        Employee employee = this.find(employeeID);
        if(employee == null)
            return false;
        employee.setUnit(unit);
        save(employee);
        return true;
    }

    public boolean addProject(int employeeID, int projectID)  //doesn't work yet
    {
        Project project = projectService.find(projectID);
        System.out.println(project);
        if(project == null)
            return false;
        Employee employee = this.find(employeeID);
        System.out.println(employee);
        if(employee == null)
            return false;

        employee.addProject(project);
        entityManager.merge(employee);

        return true;

    }
}
