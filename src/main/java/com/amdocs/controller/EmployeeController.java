package com.amdocs.controller;

import com.amdocs.entity.Employee;
import com.amdocs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/contacts")
    public ResponseEntity<List<Employee>> getContacts() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Employee> getContactById(@PathVariable("id") int id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/contacts")
    public ResponseEntity<Employee> updateContact(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createOrUpdateEmployee(employee));
    }

    @DeleteMapping("/contacts/{id}")
    public String deleteContact(@PathVariable("id") int id) {
        return employeeService.deleteEmployee(id);
    }

}
