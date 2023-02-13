package com.excercise.cartservice.repository;

import com.excercise.cartservice.model.orm.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Optional<Cart> findByCustomerId(Long customerId);
}
