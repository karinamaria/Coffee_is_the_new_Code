package com.luizacode.Coffee_is_the_new_Code.service;

import com.luizacode.Coffee_is_the_new_Code.error.ResourceNotFoundException;
import com.luizacode.Coffee_is_the_new_Code.error.NegocioException;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import com.luizacode.Coffee_is_the_new_Code.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
        verificarExistenciaEmail(customer);
        customer.setWishList(null);
        customer = customerRepository.save(customer);

        return customer;
    }
    
    public void delete(Customer customer) {
    	customerRepository.delete(customer);
    }
    
    public Customer findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for ID: "+id));

        return customer;
    }

    public void verificarExistenciaEmail(Customer customer){
        Customer aux = customerRepository.findByEmail(customer.getEmail());
        if(Objects.nonNull(aux)){
            throw new NegocioException("Email is already registered");
        }
    }
}
