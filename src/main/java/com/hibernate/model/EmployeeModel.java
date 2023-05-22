package com.hibernate.model;

import com.hibernate.entity.Employee;

public class EmployeeModel {

    public static Employee getEmployee(){

        return Employee.builder()
                .name("Raj kumar")
                .email("rajkumar@gmail.com")
                .salary(1000)
                .build();
    }
}
