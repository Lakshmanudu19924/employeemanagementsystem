package com.kodnest.employeemanagementsystem;

import jakarta.persistence.*;

@Entity
@Table(name = "employeedata")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int empid;

    @Column(name = "name")
    private String empName;

    @Column(name = "salary")
    private double empSalary;

    @Column(name = "designation")
    private String empdesignation;

    @Column(name = "department")
    private String empdepartment;

    // REQUIRED by Hibernate
    public Product() {}

    public Product(String empName, double empSalary, String empdesignation, String empdepartment) {
        this.empName = empName;
        this.empSalary = empSalary;
        this.empdesignation = empdesignation;
        this.empdepartment = empdepartment;
    }

    public int getEmpid() {
        return empid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpdesignation() {
        return empdesignation;
    }

    public void setEmpdesignation(String empdesignation) {
        this.empdesignation = empdesignation;
    }

    public String getEmpdepartment() {
        return empdepartment;
    }

    public void setEmpdepartment(String empdepartment) {
        this.empdepartment = empdepartment;
    }

    @Override
    public String toString() {
        return "Employee [id=" + empid +
                ", name=" + empName +
                ", salary=" + empSalary +
                ", designation=" + empdesignation +
                ", department=" + empdepartment + "]";
    }
}
