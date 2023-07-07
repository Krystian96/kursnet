package com.example.demo.employment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

   @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping(
            path = "/",
            produces = "application/json")
    public Employess getEmployess() {
        return employeeDAO.getAllEmployess();
    }

    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Objects> addEmployee(@RequestBody Employee employee) {
        Integer id = employeeDAO.getAllEmployess().getEmployeeList().size() + 1;
        employee.setId(id);
        employeeDAO.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
        return  ResponseEntity.created(location).build();

    }
}