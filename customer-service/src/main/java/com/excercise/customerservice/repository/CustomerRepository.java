package com.excercise.customerservice.repository;

import com.excercise.customerservice.model.orm.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer save(Customer model);

    Optional<Customer> findByUsername(String username);

    Optional<Customer> findByUsernameOrPhoneNumber(String username, String phoneNumber);

    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
