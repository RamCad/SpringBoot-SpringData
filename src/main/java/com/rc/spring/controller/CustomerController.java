package com.rc.spring.controller;

import com.rc.spring.model.Customer;
import com.rc.spring.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/customer")
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @GetMapping("/customer/{id}")
  public Customer getCustomerById(@PathVariable Long id) {
    return customerRepository.findById(id);
  }

  @PostMapping("/customer")
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerRepository.save(customer);
  }

  @ModelAttribute
  public void addAttributes(Model model) {
    model.addAttribute("msg", "Some msg!");
  }

}
