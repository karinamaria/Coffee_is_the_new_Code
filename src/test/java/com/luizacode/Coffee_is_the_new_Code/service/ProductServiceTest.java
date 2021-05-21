package com.luizacode.Coffee_is_the_new_Code.service;

import com.luizacode.Coffee_is_the_new_Code.model.Product;
import com.luizacode.Coffee_is_the_new_Code.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.luizacode.Coffee_is_the_new_Code.Mother.ProductMother.createProduct;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void givenAValidProductWhenCreateThenReturnEntityProduct() {
        Product product = createProduct();

        given(productRepository.save(product)).willReturn(product);

        Product productResponse = productService.save(product);

        then(productResponse.getId()).isEqualTo(product.getId());
        then(productResponse.getTitle()).isEqualTo(product.getTitle());
        then(productResponse.getPrice()).isEqualTo(product.getPrice());
        then(productResponse.getAvaliableQuantity()).isEqualTo(product.getAvaliableQuantity());
    }

    @Test
    void givenANullValueWhenGetProductByIdThenReturnEmpty() {

        given(productRepository.findById(1L)).willReturn(Optional.of(createProduct()));

        Product product = productService.findById(1L);

        then(productRepository.findById(2L)).isEmpty();
    }
}
