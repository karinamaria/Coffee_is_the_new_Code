package com.luizacode.Coffee_is_the_new_Code.service;

import com.luizacode.Coffee_is_the_new_Code.exception.NegocioException;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import com.luizacode.Coffee_is_the_new_Code.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveOrUpdate(Customer customer){
        return customerRepository.save(customer);
    }
    
    public void delete(Customer customer) {
    	customerRepository.delete(customer);
    }
    
    public Customer findById(Long id) {
    	return customerRepository.findById(id).orElse(null);
    }

    public void validateEmail(Customer customer) throws NegocioException {
        Customer aux = customerRepository.findByEmail(customer.getEmail());
        if(Objects.nonNull(aux)){
            throw new NegocioException("Email is already registered");
        }
    }
}
