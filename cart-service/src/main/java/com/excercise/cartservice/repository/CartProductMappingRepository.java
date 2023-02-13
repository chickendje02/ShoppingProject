package com.excercise.cartservice.repository;

import com.excercise.cartservice.model.orm.CartProductKey;
import com.excercise.cartservice.model.orm.CartProductMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductMappingRepository extends JpaRepository<CartProductMapping, CartProductKey> {
}
