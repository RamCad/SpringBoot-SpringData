package com.rc.spring;

import com.rc.spring.model.CustomerJPA;
import com.rc.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateData implements CommandLineRunner {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public void run(String... args) {
    customerRepository.deleteAll();
    customerRepository.save(CustomerJPA.builder().name("cust1").build());
    customerRepository.save(CustomerJPA.builder().name("cust2").build());
    customerRepository.save(CustomerJPA.builder().name("cust3").build());
    customerRepository.save(CustomerJPA.builder().name("cust4").build());
    customerRepository.save(CustomerJPA.builder().name("cust5").build());
    customerRepository.save(CustomerJPA.builder().name("cust6").build());
    customerRepository.save(CustomerJPA.builder().name("cust7").build());
    customerRepository.save(CustomerJPA.builder().name("cust8").build());
  }
}
