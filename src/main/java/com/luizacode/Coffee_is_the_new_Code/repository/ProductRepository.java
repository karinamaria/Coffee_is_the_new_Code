package com.luizacode.Coffee_is_the_new_Code.repository;

import com.luizacode.Coffee_is_the_new_Code.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
