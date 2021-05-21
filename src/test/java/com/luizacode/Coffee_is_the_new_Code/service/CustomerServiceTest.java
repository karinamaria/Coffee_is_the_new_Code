package com.luizacode.Coffee_is_the_new_Code.service;

import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import com.luizacode.Coffee_is_the_new_Code.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.luizacode.Coffee_is_the_new_Code.Mother.CustomerMother.createCustomer;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void givenAValidCustomerWhenCreateThenReturnEntityCustomer() {
        Customer customer = createCustomer();

        given(customerRepository.save(customer)).willReturn(customer);

        Customer customerResponse = customerService.registry(customer);

        then(customerResponse.getId()).isEqualTo(customer.getId());
        then(customerResponse.getNome()).isEqualTo(customer.getNome());
        then(customerResponse.getEmail()).isEqualTo(customer.getEmail());
        then(customerResponse.getPassword()).isEqualTo(customer.getPassword());

    }

    @Test
    void givenANullValueWhenGetCustomerByIdThenReturnEmpty() {

        given(customerRepository.findById(1L)).willReturn(Optional.of(createCustomer()));

        Customer customer = customerService.findById(1L);

        then(customerRepository.findById(2L)).isEmpty();
    }
}
