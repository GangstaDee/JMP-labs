package com.jmp;


import com.jmp.api.EmployeeService;
import com.jmp.api.ProjectService;
import com.jmp.api.UnitService;
import com.jmp.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.util.Date;

public class Runner {

    public static void main(String[] args) throws Exception  {

        System.out.println("Start");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UnitService unitService = (UnitService)context.getBean("unitService");
        ProjectService projectService = (ProjectService)context.getBean("projectService");
        EmployeeService employeeService = (EmployeeService)context.getBean("employeeService");

         //test unit
        Unit unit = new Unit();
        unit.setUnitName("unit_1");
        Unit persistedUnit = unitService.save(unit);
        Unit foundUnit = unitService.read(persistedUnit.getId(), false);
        if(foundUnit != null) {
            System.out.println("Lazy load: " + foundUnit.getId() + " " + foundUnit.getUnitName());
            unitService.delete(foundUnit.getId());
        }

        unit = new Unit();
        unit.setUnitName("unit_2");
        persistedUnit = unitService.save(unit);
        foundUnit = unitService.read(persistedUnit.getId(), true);
        if(foundUnit != null) {
            System.out.println("Eager load: " + foundUnit.getId() + " " + foundUnit.getUnitName() + " " + foundUnit.getEmployees().size());
            unitService.delete(foundUnit.getId());
        }

        //test project
        Project project = new Project();
        project.setProjectName("project_1");
        Project persistedProject = projectService.save(project);
        Project foundProject = projectService.read(persistedProject.getId(), false);
        if(foundProject != null) {
            System.out.println("Lazy load: " + foundProject.getId() + " " + foundProject.getProjectName());
            projectService.delete(foundProject.getId());
        }

        project = new Project();
        project.setProjectName("project_2");
        persistedProject = projectService.save(project);
        foundProject = projectService.read(persistedProject.getId(), true);
        if(foundProject != null) {
            System.out.println("Eager load: " + foundProject.getId() + " " + foundProject.getProjectName() + " " + foundProject.getEmployees().size());
            projectService.delete(foundProject.getId());
        }

        //test employee
        Employee employee = new Employee();
        employee.setFirstName("Dart");
        employee.setLastName("Vader");
        employee.setEmail("blabla@gmail.com");
        employee.setStatus(EmployeeStatus.ACTIVE);

        Address address = new Address();
        address.setCountry("US");
        address.setCity("VVV");
        address.setStreet("NNN");
        address.setZip(1234);
        employee.setAddress(address);

        Employee persistedEmployee = employeeService.save(employee);

        PersonalInfo info = new PersonalInfo();
        info.setBirthDay(new Date());
        info.setPersonal("Some personal info...");
        info.setEmployeeID(persistedEmployee.getId());
        persistedEmployee.setPersonalInfo(info);
        persistedEmployee = employeeService.save(employee);

        Employee foundEmployee = employeeService.read(persistedEmployee.getId(), true);
        if(foundEmployee != null) {
            System.out.println("Eager load: " + foundEmployee.getId() + " " + foundEmployee.getEmail() + " " +
                    foundEmployee.getUnit() + " " + foundEmployee.getProjects().size());
            employeeService.delete(foundEmployee.getId());
        }


        //test unit and project assignment
        unit = new Unit();
        unit.setUnitName("unit_3");
        persistedUnit = unitService.save(unit);

        project = new Project();
        project.setProjectName("project_3");
        persistedProject = projectService.save(project);

        employee = new Employee();
        employee.setFirstName("Bla");
        employee.setLastName("BlaBla");
        employee.setEmail("blabla@gmail.com");
        employee.setStatus(EmployeeStatus.ACTIVE);
        persistedEmployee = employeeService.save(employee);

        employeeService.assignUnit(persistedEmployee.getId(),persistedUnit.getId());
        employeeService.addProject(persistedEmployee.getId(),persistedProject.getId());

        foundEmployee = employeeService.read(persistedEmployee.getId(), true);
        if(foundEmployee != null) {
            System.out.println("Eager load: " + foundEmployee.getId() + " " + foundEmployee.getEmail() + " " +
                    foundEmployee.getUnit().getUnitName() + " " + foundEmployee.getProjects().size());
        }
        System.out.println("The end");

    }

}
