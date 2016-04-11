package com.jmp;


import com.jmp.api.EmployeeService;
import com.jmp.api.ProjectService;
import com.jmp.api.UnitService;
import com.jmp.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Runner {

    public static void main(String[] args) throws Exception  {

        System.out.println("Hello");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UnitService unitService = (UnitService)context.getBean("unitService");
        ProjectService projectService = (ProjectService)context.getBean("projectService");
        EmployeeService employeeService = (EmployeeService)context.getBean("employeeService");

//        //test unit
//        Unit unit = new Unit();
//        unit.setUnitName("unit_emp");
//        Unit u = unitService.save(unit);
//        System.out.println(unitService.find(u.getId()));
//        unitService.delete(u.getId());
//        System.out.println(unitService.find(u.getId()));
//
//
//        //test project
//        Project project = new Project();
//        project.setProjectName("project_1");
//        Project p = projectService.save(project);
//        System.out.println(projectService.find(p.getId()));
//        projectService.delete(p.getId());
//        System.out.println(projectService.find(p.getId()));
//
//        //test employee
//        Employee employee = new Employee();
//        employee.setFirstName("Dart");
//        employee.setLastName("Vader");
//        employee.setEmail("blabla@gmail.com");
//        employee.setStatus(EmployeeStatus.ACTIVE);
//
//        Address address = new Address();
//        address.setCountry("US");
//        address.setCity("VVV");
//        address.setStreet("NNN");
//        address.setZip(1234);
//        employee.setAddress(address);
//
//        System.out.println("Save employee");
//        employeeService.save(employee);
//
//        PersonalInfo info = new PersonalInfo();
//        info.setBirthDay(new Date());
//        info.setPersonal("Some personal info...");
//        info.setEmployeeID(employee.getId());
//        employee.setPersonalInfo(info);
//
//        System.out.println("Save employee + info");
//        employeeService.save(employee);
//
//        System.out.println("Search employee");
//        System.out.println(employeeService.find(employee.getId()));
//
//        System.out.println("Delete employee");
//        employeeService.delete(employee.getId());
//
//        System.out.println("Search deleted employee");
//        System.out.println(employeeService.find(employee.getId()));

//        //test lazy load
//        Unit un = unitService.find(26);
//        un.getEmployees().forEach(emp-> System.out.println(emp.getEmail()));
;

        //employeeService.assignUnit(22,26);
        employeeService.addProject(21,27);
        System.out.println("Bye");

    }
}
