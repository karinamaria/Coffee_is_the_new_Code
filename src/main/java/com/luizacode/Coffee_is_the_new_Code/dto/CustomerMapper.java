package com.luizacode.Coffee_is_the_new_Code.dto;

import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer customerInputDtoToCustomer(CustomerInputDto customerInputDto);

    CustomerOutputDto customerToCustomerOutputDto(Customer customer);
}
