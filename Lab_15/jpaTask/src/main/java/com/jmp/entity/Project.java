package com.jmp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECT")
public class Project implements Serializable{

    @Id
    @SequenceGenerator(name="JPA_PK_GEN", sequenceName="JPA_PK_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JPA_PK_GEN")
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
    private List<Employee> employees;

    public Project() {
        this.employees = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
