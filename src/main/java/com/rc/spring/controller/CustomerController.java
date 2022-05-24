package com.rc.spring.controller;

import com.rc.spring.model.Customer;
import com.rc.spring.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @GetMapping("/customer/{id}")
  public Customer getCustomerById(@PathVariable Long id){
   return customerRepository.findById(id).orElse(new Customer());
  }

  @DeleteMapping("/customer/{id}")
  public ResponseEntity<String> deleteTutorial(@PathVariable long id) {
    customerRepository.deleteById(id);

    return ResponseEntity.ok("Deleted!");
  }

  @PostMapping("/customer")
  public ResponseEntity<Customer> createTutorial(@RequestBody Customer customer) {
    Customer _customer = customerRepository.save(customer);
    return new ResponseEntity<>(_customer, HttpStatus.CREATED);
  }
}
