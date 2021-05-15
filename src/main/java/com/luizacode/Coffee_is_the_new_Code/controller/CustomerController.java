package com.luizacode.Coffee_is_the_new_Code.controller;

import com.luizacode.Coffee_is_the_new_Code.dto.CustomerInputDto;
import com.luizacode.Coffee_is_the_new_Code.dto.CustomerOutputDto;
import com.luizacode.Coffee_is_the_new_Code.exception.NegocioException;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;

import com.luizacode.Coffee_is_the_new_Code.service.CustomerService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@ApiModel(value = "Customer Controller")
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ModelMapper modelMapper;

//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	@ApiOperation(value = "Create an customer", notes = "Also returns a link to retrieve the saved customer in the location header")
//    public ResponseEntity<CustomerInputDto> register(@RequestBody @Valid CustomerInputDto customer){
//    	Customer customerModel = modelMapper.map(customer, Customer.class);
//    	customerModel = customerService.create(customerModel);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(customerModel.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
	@PostMapping
	@ApiOperation(value = "Create an customer")
	public ResponseEntity<?> register(@RequestBody @Valid CustomerInputDto customer){
		try{
			Customer customerModel = modelMapper.map(customer, Customer.class);
			customerService.validateEmail(customerModel);
			//criptografar a senha
			customerModel = customerService.create(customerModel);
			CustomerOutputDto customerOutput = modelMapper.map(customerModel, CustomerOutputDto.class);

			return new ResponseEntity<>(customerOutput, HttpStatus.CREATED);
		}catch(NegocioException ne){
			return new ResponseEntity<>(ne.getMessage(), HttpStatus.CONFLICT);
		}



	}
}
