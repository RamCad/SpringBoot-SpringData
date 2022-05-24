package com.rc.spring.controller;

import com.rc.spring.ResourceNotFoundException;
import com.rc.spring.model.Customer;
import com.rc.spring.model.Product;
import com.rc.spring.repository.CustomerRepository;
import com.rc.spring.repository.ProductRepository;
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
public class ProductController {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/product")
  public List<Product> getAllCustomers() {
    return productRepository.findAll();
  }

  @GetMapping("/product/{id}")
  public Product getCustomerById(@PathVariable long id){
    return productRepository.findById(id).orElse(new Product());
  }

  @DeleteMapping("/product/{id}")
  public ResponseEntity<String> deleteTutorial(@PathVariable long id) {
    productRepository.deleteById(id);

    return ResponseEntity.ok("Deleted!");
  }

  @PostMapping("/customer/{id}/product")
  public ResponseEntity<Product> createTutorial(@PathVariable long id, @RequestBody Product product) {
    Product _product = customerRepository.findById(id).map(cust -> {
      cust.addProduct(product);
      return productRepository.save(product);
    }).orElseThrow(() -> new ResourceNotFoundException("Not found"));
    return  new ResponseEntity<>(_product, HttpStatus.CREATED);
  }
}
