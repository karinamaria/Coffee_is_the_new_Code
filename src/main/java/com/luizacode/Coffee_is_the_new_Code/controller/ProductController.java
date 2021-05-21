package com.luizacode.Coffee_is_the_new_Code.controller;

import com.luizacode.Coffee_is_the_new_Code.dto.ProductInputDto;
import com.luizacode.Coffee_is_the_new_Code.dto.ProductMapper;
import com.luizacode.Coffee_is_the_new_Code.dto.ProductOutputDto;
import com.luizacode.Coffee_is_the_new_Code.model.Product;
import com.luizacode.Coffee_is_the_new_Code.service.ProductService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@ApiModel(value = "Product Controller")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an product", notes = "Also returns a link to retrieve the saved product in the location header")
    public ResponseEntity<?> register(@RequestBody @Valid ProductInputDto product){
        Product productModel = productService.save(productMapper.productInputDtoToProduct(product));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productModel.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/{idProduct}")
    @ApiOperation(value = "Find product by id")
    public ResponseEntity<ProductOutputDto> findProductById(@PathVariable Long idProduct){
        ProductOutputDto productOutputDto = productMapper.productToProductOutputDto(productService.findById(idProduct));

        return new ResponseEntity<>(productOutputDto, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Lists all registered products")
    public ResponseEntity<?> listAllProducts(){
    	return new ResponseEntity<>(productService.listsAllProducts(), HttpStatus.OK);
    }
}
