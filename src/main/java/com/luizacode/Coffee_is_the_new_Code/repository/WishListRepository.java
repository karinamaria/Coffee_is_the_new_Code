package com.luizacode.Coffee_is_the_new_Code.repository;

import com.luizacode.Coffee_is_the_new_Code.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long> {

}
