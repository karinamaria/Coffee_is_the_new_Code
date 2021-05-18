package com.luizacode.Coffee_is_the_new_Code.repository;

import com.luizacode.Coffee_is_the_new_Code.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    public Customer findByEmail(String email);

    public Customer findByWishList(WishList wishList);
}
