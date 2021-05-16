package com.luizacode.Coffee_is_the_new_Code.service;

import com.luizacode.Coffee_is_the_new_Code.model.Product;
import com.luizacode.Coffee_is_the_new_Code.dto.ProductOutputDto;
import com.luizacode.Coffee_is_the_new_Code.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Product saveOrUpdate(Product product) {
		return productRepository.save(product);
	}

	public Product findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public List<ProductOutputDto> listsAllProducts() {
		List<Product> products = productRepository.findAll();

		List<ProductOutputDto> productOutput = products.stream()
				.map(element -> modelMapper.map(element, ProductOutputDto.class)).collect(Collectors.toList());
		return productOutput;
	}
}
