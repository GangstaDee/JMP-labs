package com.jmp.api;

import com.jmp.entity.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee find(int employeeID);

    int delete(int employeeID);

    boolean assignUnit(int employeeID, int unitID);

    boolean addProject(int employeeID, int projectID);
}
