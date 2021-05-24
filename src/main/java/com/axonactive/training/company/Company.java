package com.axonactive.training.company;

import java.util.ArrayList;
import java.util.List;

import com.axonactive.training.company.employee.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {

    private Integer id;

    private String name;

    private String address;

    private String phoneNumber;

    private String email;

    private List<Employee> employeeList;

    public Company() {
    }

    public Company(int id, String name, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employeeList = new ArrayList<Employee>();
    }

    public String toString() {
        return "Company: " + id + ", " + name + ", " + address + ", " + phoneNumber + ", " + email;
    }

}