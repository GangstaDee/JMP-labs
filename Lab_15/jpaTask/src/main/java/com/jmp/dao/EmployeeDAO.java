package com.jmp.dao;

import com.jmp.entity.Employee;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Employee read(int employeeID);

    Employee readFullDetails(int employeeID);

    int delete(int employeeID);
}
