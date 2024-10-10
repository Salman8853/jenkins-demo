package com.codeadiction.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private  Double salary;
    private String department;
}
