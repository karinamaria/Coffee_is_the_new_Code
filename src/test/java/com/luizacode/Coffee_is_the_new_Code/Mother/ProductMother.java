package com.luizacode.Coffee_is_the_new_Code.Mother;

import com.luizacode.Coffee_is_the_new_Code.dto.ProductInputDto;
import com.luizacode.Coffee_is_the_new_Code.dto.ProductOutputDto;
import com.luizacode.Coffee_is_the_new_Code.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductMother {

    public static Product createProduct(){
        return new Product(1L, "Computador", 1, new BigDecimal(5.59600));
    }


    public static ProductInputDto createProductInputDto() {
        return new ProductInputDto("Computador", 1, new BigDecimal(5.59600));

    }
    public static ProductOutputDto createProductOutputDto() {
        return new ProductOutputDto(1L, "Computador", 1, new BigDecimal(5.59600));
    }

    public static List<ProductOutputDto> createListProductOutputDto(){
        return Arrays.asList(new ProductOutputDto(1L, "Computador", 1, new BigDecimal(5.59600)));
    }

    public static List<Product> createListProduct(){
        return Arrays.asList(new Product(1L, "Computador", 1, new BigDecimal(5.59600)));
    }
}
