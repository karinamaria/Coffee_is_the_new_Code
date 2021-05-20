package com.luizacode.Coffee_is_the_new_Code.Mother;

import com.luizacode.Coffee_is_the_new_Code.dto.CustomerInputDto;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;

public class CustomerMother {

    public static CustomerInputDto createCustomerInputDto() {
        return new CustomerInputDto ("Luciana", "luciana@email.com", "122452");
    }
    public static Customer createCustomer() {
        return new Customer ("Luciana", "luciana@email.com", "122452");
    }
}

