package com.amdocs.service;

import com.amdocs.entity.Employee;
import com.amdocs.exception.ResourceNotFoundException;
import com.amdocs.repository.EmployeeRepository;
import com.amdocs.util.EmployeeUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    private static final String NOT_FOUND = "Contact not found with id: ";

    @Autowired
    EmployeeUtil employeeUtil;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employeeDb = employeeRepository.findById(id);

        if(employeeDb.isPresent()) {
            return employeeDb.get();
        }

        throw new ResourceNotFoundException(NOT_FOUND + id);
    }

    @Override
    public Employee createOrUpdateEmployee(@NotNull Employee employee) {

        if(employee.getId() != null) {
            Optional<Employee> employeeDb = employeeRepository.findById(employee.getId());

            if(employeeDb.isPresent()) {
                BeanUtils.copyProperties(employee, employeeDb.get(), employeeUtil.getNullPropertyNames(employee));
                employeeRepository.save(employeeDb.get());
                return employeeDb.get();
            }
        }
        return employeeRepository.save(employee);
    }

    @Override
    public String deleteEmployee(int id) {
        Optional<Employee> employeeDb = employeeRepository.findById(id);

        if(employeeDb.isPresent()) {
            employeeRepository.delete(employeeDb.get());
            return "Employee have been deleted with id: " + id;
        }

        throw new ResourceNotFoundException(NOT_FOUND + id);
    }
}
