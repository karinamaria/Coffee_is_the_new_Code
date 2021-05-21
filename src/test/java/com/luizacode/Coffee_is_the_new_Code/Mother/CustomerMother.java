package com.luizacode.Coffee_is_the_new_Code.Mother;

import static com.luizacode.Coffee_is_the_new_Code.Mother.WishlistMother.createWishList;

import com.luizacode.Coffee_is_the_new_Code.dto.CustomerInputDto;
import com.luizacode.Coffee_is_the_new_Code.dto.CustomerOutputDto;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import org.springframework.http.ResponseEntity;

public class CustomerMother {

  public static CustomerInputDto createCustomerInputDto() {
    return new CustomerInputDto("Luciana", "luciana@email.com", "122452");
  }

  public static Customer createCustomer() {
    return new Customer(1L, "Luciana", "luciana@email.com", "122452");
  }

  public static CustomerOutputDto createCustomerOutputDto() {
    return new CustomerOutputDto(1L, "Luciana", "luciana@email.com", "122452", createWishList());
  }
}

