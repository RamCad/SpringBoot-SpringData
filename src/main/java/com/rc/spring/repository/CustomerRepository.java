package com.rc.spring.repository;

import com.rc.spring.model.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public List<Customer> findAll() {
    TypedQuery<Customer> query = entityManager
        .createQuery("SELECT c FROM Customer c", Customer.class);
    return query.getResultList();
  }

  public List<Customer> findByNameContaining(String name) {
    TypedQuery<Customer> query = entityManager.createQuery(
        "SELECT c FROM Customer c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name,'%'))",
        Customer.class);
    return query.setParameter("name", name).getResultList();
  }

  @Transactional
  public Customer save(Customer customer) {
    entityManager.persist(customer);
    return customer;
  }

  public Customer findById(long id) {
    return entityManager.find(Customer.class, id);
  }

  @Transactional()
  public Customer update(Customer customer) {
    entityManager.merge(customer);
    return customer;
  }

  @Transactional
  public Customer deleteById(long id) {
    Customer Customer = findById(id);
    if (Customer != null) {
      entityManager.remove(Customer);
    }
    return Customer;
  }

  @Transactional
  public int deleteAll() {
    Query query = entityManager.createQuery("DELETE FROM Customer");
    return query.executeUpdate();
  }

}
