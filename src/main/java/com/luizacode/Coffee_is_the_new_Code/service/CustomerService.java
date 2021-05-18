package com.luizacode.Coffee_is_the_new_Code.service;

import com.luizacode.Coffee_is_the_new_Code.error.ResourceNotFoundException;
import com.luizacode.Coffee_is_the_new_Code.error.NegocioException;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import com.luizacode.Coffee_is_the_new_Code.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
        verificarExistenciaEmail(customer);
        if(Objects.isNull(customer.getId())){
            customer.setWishList(null);
        }
        customer = registry(customer);
        log.info("Customer email: "+customer.getEmail()+" was saved");
        return customer;
    }

    public Customer registry(Customer customer){
        return customerRepository.save(customer);
    }
    
    public void delete(Customer customer) {
        log.info("Customer email: "+customer.getEmail()+" it was excluded");
        customerRepository.delete(customer);
    }
    
    public Customer findById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found for ID: "+id));

        return customer;
    }

    public void verificarExistenciaEmail(Customer customer){
        Customer aux = customerRepository.findByEmail(customer.getEmail());
        if(Objects.nonNull(aux)){
            if (!aux.getId().equals(customer.getId())) {
                log.warn("Email already exists");
                throw new NegocioException("Email is already registered");
            }
        }
    }
}
