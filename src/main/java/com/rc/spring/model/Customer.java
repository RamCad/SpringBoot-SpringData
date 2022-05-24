package com.rc.spring.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "customer_product",
      joinColumns = { @JoinColumn(name = "customer_id") },
      inverseJoinColumns = { @JoinColumn(name="product_id") })
  private List<Product> products = new ArrayList<>();

  public void addProduct(Product product){
    this.products.add(product);
    product.getCustomers().add(this);
  }
}
