package com.amdocs.service;

import com.amdocs.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();
    Employee getEmployeeById(int id);
    Employee createOrUpdateEmployee(Employee employee);
    String deleteEmployee(int id);

}
