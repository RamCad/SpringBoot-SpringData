package com.rc.spring.controller;

import com.rc.spring.model.CustomerJPA;
import com.rc.spring.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/customer")
  public List<CustomerJPA> getCustomers() {
    return customerRepository.findAll();
  }

  @GetMapping("/customer/{id}")
  public CustomerJPA getCustomerById(@PathVariable Long id) {
    return customerRepository.findById(id);
  }

  @PostMapping("/customer")
  public CustomerJPA createCustomer(@RequestBody CustomerJPA customerJPA) {
    return customerRepository.save(customerJPA);
  }

}
