package com.luizacode.Coffee_is_the_new_Code.controller;

import com.luizacode.Coffee_is_the_new_Code.dto.CustomerInputDto;
import com.luizacode.Coffee_is_the_new_Code.dto.CustomerMapper;
import com.luizacode.Coffee_is_the_new_Code.dto.CustomerOutputDto;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import com.luizacode.Coffee_is_the_new_Code.service.CustomerService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@ApiModel(value = "Customer Controller")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    @ApiOperation(value = "Create an customer")
    public ResponseEntity<?> save(@RequestBody @Valid CustomerInputDto customerInputDto) {
        return new ResponseEntity<>(customerMapper.customerToCustomerOutputDto(
                customerService.save(customerMapper.customerInputDtoToCustomer(customerInputDto))), HttpStatus.CREATED);
    }

    @GetMapping("/{idCustomer}")
    @ApiOperation(value = "Find customer by id")
    public ResponseEntity<?> findCustomerById(@PathVariable Long idCustomer) {
        Customer customer = customerService.findById(idCustomer);

        return new ResponseEntity<>(customerMapper.customerToCustomerOutputDto(customer), HttpStatus.OK);
    }
}
