package com.example.demo.service.impl;

import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements BaseService<Employees> {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employees save(Employees employees) {
        return employeeRepository.save(employees);
    }

    @Override
    public Employees findById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employees remove(long id) {
        Employees employees = findById(id);
        employeeRepository.deleteById(id);
        return employees;
    }
}
