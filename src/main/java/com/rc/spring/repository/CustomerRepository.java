package com.rc.spring.repository;

import com.rc.spring.model.CustomerJPA;
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

  public List<CustomerJPA> findAll() {
    TypedQuery<CustomerJPA> query = entityManager.createQuery("SELECT c FROM CustomerJPA c", CustomerJPA.class);
    return query.getResultList();
  }

  public List<CustomerJPA> findByNameContaining(String name) {
    TypedQuery<CustomerJPA> query = entityManager.createQuery(
        "SELECT c FROM CustomerJPA c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name,'%'))",
        CustomerJPA.class);
    return query.setParameter("name", name).getResultList();
  }

  @Transactional
  public CustomerJPA save(CustomerJPA customer) {
    entityManager.persist(customer);
    return customer;
  }
  public CustomerJPA findById(long id) {
    return  entityManager.find(CustomerJPA.class, id);
  }
  @Transactional
  public CustomerJPA update(CustomerJPA customer) {
    entityManager.merge(customer);
    return customer;
  }
  @Transactional
  public CustomerJPA deleteById(long id) {
    CustomerJPA Customer = findById(id);
    if (Customer != null) {
      entityManager.remove(Customer);
    }
    return Customer;
  }
  @Transactional
  public int deleteAll() {
    Query query = entityManager.createQuery("DELETE FROM CustomerJPA");
    return query.executeUpdate();
  }

}
