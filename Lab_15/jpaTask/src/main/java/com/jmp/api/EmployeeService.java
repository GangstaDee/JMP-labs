package com.jmp.api;

import com.jmp.api.exception.DataNotFoundException;
import com.jmp.entity.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee read(int employeeID, boolean eager);

    int delete(int employeeID);

    Employee assignUnit(int employeeID, int unitID) throws DataNotFoundException;

    Employee addProject(int employeeID, int projectID) throws DataNotFoundException;
}
