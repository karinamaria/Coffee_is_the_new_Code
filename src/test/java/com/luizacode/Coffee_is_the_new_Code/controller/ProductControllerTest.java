package com.luizacode.Coffee_is_the_new_Code.controller;

import com.google.gson.Gson;
import com.luizacode.Coffee_is_the_new_Code.dto.ProductInputDto;
import com.luizacode.Coffee_is_the_new_Code.dto.ProductMapper;
import com.luizacode.Coffee_is_the_new_Code.dto.ProductOutputDto;
import com.luizacode.Coffee_is_the_new_Code.model.Product;
import com.luizacode.Coffee_is_the_new_Code.repository.ProductRepository;
import com.luizacode.Coffee_is_the_new_Code.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static com.luizacode.Coffee_is_the_new_Code.Mother.ProductMother.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({

        ProductController.class,
        ProductService.class,
        ProductMapper.class
})
public class ProductControllerTest {

    private static final String PRODUCT_ENDPOINT = "/api/v1/product";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;


    @Test
    public void givenValidProductWhenCreateThenReturnEntityProduct() throws Exception {

        Product product = createProduct();
        ProductInputDto productInputDto = createProductInputDto();

        given(productService.save(any())).willReturn((product));
        given(productRepository.save(any())).willReturn(product);

        Gson gson = new Gson();
        String jsonBody = gson.toJson(productInputDto);

        mvc.perform(post(PRODUCT_ENDPOINT)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void givenValidIdWhenGetProductByIdThenReturnOk() throws Exception {

        Product product = createProduct();
        ProductOutputDto productOutputDto = createProductOutputDto();

        given(productService.findById(1L)).willReturn(product);
        given(productRepository.findById(1L)).willReturn(Optional.of(product));

        mvc.perform(get(PRODUCT_ENDPOINT + "/" + productOutputDto.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.title").value(productOutputDto.getTitle()))
                .andExpect(jsonPath("$.avaliableQuantity").value(productOutputDto.getAvaliableQuantity()))
                .andExpect(jsonPath("$.price").value(productOutputDto.getPrice()));

        verify(productService, times(1)).findById(1L);
    }

    @Test
    public void givenANullTitleWhenCreateThenReturnBadRequest() throws Exception {
        ProductInputDto productInputDto = createProductInputDto();
        productInputDto.setTitle(null);

        Gson gson = new Gson();
        String jsonBody = gson.toJson(productInputDto);

        mvc.perform(post(PRODUCT_ENDPOINT)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}

