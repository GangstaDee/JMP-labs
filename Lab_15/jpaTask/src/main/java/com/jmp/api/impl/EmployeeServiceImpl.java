package com.jmp.api.impl;

import com.jmp.api.EmployeeService;
import com.jmp.api.ProjectService;
import com.jmp.api.UnitService;
import com.jmp.api.exception.DataNotFoundException;
import com.jmp.dao.EmployeeDAO;
import com.jmp.entity.Employee;
import com.jmp.entity.Project;
import com.jmp.entity.Unit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDAO employeeDAO;

    @Resource(name = "unitService")
    private UnitService unitService;

    @Resource(name = "projectService")
    private ProjectService projectService;

    public Employee save(Employee employee){
        return employeeDAO.save(employee);
    }

    @Override
    public Employee read(int employeeID, boolean eager) {
        if(eager) {
            Employee employee = employeeDAO.readFullDetails(employeeID);
        }
        return employeeDAO.read(employeeID);
    }


    public int delete(int employeeID) {
        return employeeDAO.delete(employeeID);
    }

    public Employee assignUnit(int employeeID, int unitID) throws DataNotFoundException {

        Unit unit = unitService.read(unitID, false);
        if(unit == null) {
           throw new DataNotFoundException("Unit not found, ID ", unitID);
        }

        Employee employee = read(employeeID, false);
        if(employee == null) {
            throw new DataNotFoundException("Employee not found, ID ", employeeID);
        }

        employee.setUnit(unit);
        Employee saved = save(employee);
        return saved;
    }

    public Employee addProject(int employeeID, int projectID) throws DataNotFoundException {

        Project project = projectService.read(projectID, false);

        if(project == null) {
            throw new DataNotFoundException("Project not found, ID ", projectID);
        }

        Employee employee = read(employeeID, true);
        if(employee == null) {
            throw new DataNotFoundException("Employee not found, ID ", employeeID);
        }

        employee.addProject(project);
        employeeDAO.save(employee);

        Employee saved = save(employee);

        return saved;

    }
}
