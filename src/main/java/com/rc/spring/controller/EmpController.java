package com.rc.spring.controller;

import com.rc.spring.model.Employee;
import com.rc.spring.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @PostMapping("/emp")
  public void createEmp(@RequestBody Employee employee) {
    employeeRepository.save(employee);
  }

  @GetMapping("/emp")
  public List<Employee> getEmp() {
    return employeeRepository.findAll();
  }
}
