package com.luizacode.Coffee_is_the_new_Code;

import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 public class CustomerTest {
     @BeforeEach
     void setUp() {
     }

     @Test
     public void objectMustBeEquals() {
         Customer customer1 = new Customer();
         customer1.setId(1L);
         customer1.setNome("nome");
         customer1.setEmail("email@email.com");
         customer1.setPassword("12345");

         Customer customer2 = new Customer();
         customer2.setId(1L);
         customer2.setNome("nome");
         customer2.setEmail("email@email.com");
         customer2.setPassword("12345");

         Assertions.assertEquals(customer1, customer2);
     }

    @Test
    public void objectMustNotBeEquals (){
         Customer customer1 = new Customer();
         customer1.setId(1L);
         customer1.setNome("ISAC");
         customer1.setEmail("email@email.com");
         customer1.setPassword("12345");

         Customer customer2 = new Customer();
         customer2.setId(1L);
         customer2.setNome("nome");
         customer2.setEmail("email@email.com");
         customer2.setPassword("12345");

         Assertions.assertNotEquals(customer1, customer2);
     }

     @Test
     public void generateHashTest (){
         Customer customer = new Customer();
         customer.setId(1L);
         customer.setNome("nome");
         customer.setEmail("email@email.com");
         customer.setPassword("12345");

         int hash = customer.hashCode();
         Assertions.assertEquals(577662749, hash);
     }
 }