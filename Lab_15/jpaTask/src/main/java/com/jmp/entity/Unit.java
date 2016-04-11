package com.jmp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "UNIT")
public class Unit implements Serializable {

    @Id
    @SequenceGenerator(name="JPA_PK_GEN", sequenceName="JPA_PK_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JPA_PK_GEN")
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "UNIT_NAME")
    private String unitName;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "unit", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public Integer getId() {
        return id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
