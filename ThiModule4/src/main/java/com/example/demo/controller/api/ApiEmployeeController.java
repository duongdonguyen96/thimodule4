package com.example.demo.controller.api;

import com.example.demo.model.Employees;
import com.example.demo.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiEmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employees/", method = RequestMethod.GET)
    public ResponseEntity<List<Employees>> listAllCustomers() {
        List<Employees> allEmployee = employeeService.findAll();
        if (allEmployee == null) {
            return new ResponseEntity<List<Employees>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Employees>>(allEmployee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employees> delete(@PathVariable("id") int id) {
        Employees tv = employeeService.remove(id);
        return new ResponseEntity<Employees>(tv, HttpStatus.OK);
    }

    @RequestMapping(value = "employees/", method = RequestMethod.POST)

    public ResponseEntity<Employees> create(@RequestBody Employees blog) {
        Employees employees = employeeService.save(blog);
        return new ResponseEntity<Employees>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employees> getSmartphone(@PathVariable("id") int id) {

        Employees employees = employeeService.findById(id);
        return new ResponseEntity<Employees>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/", method = RequestMethod.PUT)
    public ResponseEntity<Employees> update(@RequestBody Employees employees) {
        employeeService.save(employees);
        return new ResponseEntity<Employees>(employees, HttpStatus.OK);
    }
}
