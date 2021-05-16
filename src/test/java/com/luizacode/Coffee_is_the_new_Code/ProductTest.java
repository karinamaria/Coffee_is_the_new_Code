package com.luizacode.Coffee_is_the_new_Code;

import com.luizacode.Coffee_is_the_new_Code.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ProductTest {
    @Test
    public void objectMustBeEquals() {
        Product product1 = new Product();
        product1.setTitle("computer");
        product1.setAvaliableQuantity(0);
        product1.setPrice(new BigDecimal(350));
        product1.setId(1235L);

        Product product2 = new Product();
        product2.setTitle("computer");
        product2.setAvaliableQuantity(0);
        product2.setPrice(new BigDecimal(350));
        product2.setId(1235L);

        Assertions.assertEquals(product1, product2);
    }

    @Test
    public void objectMustNotBeEquals (){
        Product product1 = new Product();
        product1.setTitle("computer");
        product1.setAvaliableQuantity(0);
        product1.setPrice(new BigDecimal(350));
        product1.setId(1235L);

        Product product2 = new Product();
        product2.setTitle("computer");
        product2.setAvaliableQuantity(1);
        product2.setPrice(new BigDecimal(350));
        product2.setId(1235L);

        Assertions.assertNotEquals(product1, product2);
    }

    @Test
    public void generateHashTest (){
        Product product = new Product();
        product.setTitle("computer");
        product.setAvaliableQuantity(0);
        product.setPrice(new BigDecimal(350));
        product.setId(1235L);

        int hash = product.hashCode();
        Assertions.assertEquals(1414045044, hash);
    }
}