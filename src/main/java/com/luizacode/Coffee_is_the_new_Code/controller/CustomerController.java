package com.luizacode.Coffee_is_the_new_Code.controller;

import com.luizacode.Coffee_is_the_new_Code.dto.CustomerInputDto;
import com.luizacode.Coffee_is_the_new_Code.dto.CustomerOutputDto;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;

import com.luizacode.Coffee_is_the_new_Code.service.CustomerService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

import org.modelmapper.ModelMapper;
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
	private ModelMapper modelMapper;

	@PostMapping
	@ApiOperation(value = "Create an customer")
	public ResponseEntity<?> save(@RequestBody @Valid CustomerInputDto customerInputDto){
		Customer customerModel = modelMapper.map(customerInputDto, Customer.class);
		customerModel = customerService.save(customerModel);

		CustomerOutputDto customerOutput =  new CustomerOutputDto();
		customerOutput.setNome(customerModel.getNome());
		customerOutput.setEmail(customerModel.getEmail());
		customerOutput.setPassword(customerModel.getPassword());
		customerOutput.setWishList(customerModel.getWishList());

		modelMapper.map(customerModel, CustomerOutputDto.class);

		return new ResponseEntity<>(customerOutput, HttpStatus.CREATED);
	}
	@GetMapping("/{idCustomer}")
	@ApiOperation(value = "Find customer by id")
	public ResponseEntity<?> findCustomerById(@PathVariable Long idCustomer){
		Customer customer = customerService.findById(idCustomer);
		CustomerOutputDto customerOutputDto = modelMapper.map(customer, CustomerOutputDto.class);

		return new ResponseEntity<>(customerOutputDto, HttpStatus.OK);
	}
}
