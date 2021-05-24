package com.axonactive.training.company.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void whenGetAgeValid() {
        Employee employee = new Employee(1, "Tran Van Hoai", 1999, Gender.MALE, 1);
        assertEquals(22, employee.getAge());
    }
}
