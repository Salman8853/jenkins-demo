package com.codeadiction.controller;

import com.codeadiction.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @GetMapping("/")
      public ResponseEntity<List<Employee>>getEmployee(){
          return new ResponseEntity<>(employees, HttpStatus.OK);
      }


    @GetMapping("by-department/")
    public ResponseEntity<Map<String,List<Employee>>>getEmployeeByDepartment(){
        Map<String,List<Employee>> employeeDepartmentwise=  employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        return new ResponseEntity<>(employeeDepartmentwise, HttpStatus.OK);
    }
    static List<Employee> employees;

    static {
        employees = List.of(
                
                new Employee(1, "John Doe", 55000.0, "IT"),
                new Employee(2, "Jane Smith", 62000.0, "HR"),
                new Employee(3, "Michael Brown", 48000.0, "Finance"),
                new Employee(4, "Emily White", 51000.0, "Marketing"),
                new Employee(5, "Mohd Salman", 65000.0, "IT")
        );

    }
}
