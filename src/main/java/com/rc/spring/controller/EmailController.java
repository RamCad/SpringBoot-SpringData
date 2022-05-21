package com.rc.spring.controller;

import com.rc.spring.Model.Email;
import com.rc.spring.repository.EmailRepository;
import com.rc.spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private EmailRepository emailRepository;

  @PostMapping("/{empId}/email")
  public void createEmail(@PathVariable Long empId, @RequestBody Email email) {
    Email email1 = employeeRepository.findById(empId).map(emp -> {
      email.setEmployee(emp);
      return emailRepository.save(email);
    }).orElse(Email.builder().build());
  }
}
