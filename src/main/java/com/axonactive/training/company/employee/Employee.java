package com.axonactive.training.company.employee;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String fullName;

    private int yearOfBirth;
    @Convert(converter = Gender.class)
    private Gender gender;

    private int idCompany;

    public Employee() {
    }

    public Employee(int id, String fullName, int yearOfBirth, Gender gender, int idCompany) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.idCompany = idCompany;
    }

    public String toString() {
        return "Employee: " + id + ", " + fullName + ", " + yearOfBirth + ", " + gender;
    }

    public int getAge() {
        return LocalDate.now().getYear() - this.yearOfBirth;
    }
}
