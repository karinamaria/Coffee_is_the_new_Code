//package com.luizacode.Coffee_is_the_new_Code.controller;
//
//import com.google.gson.Gson;
//import com.luizacode.Coffee_is_the_new_Code.dto.CustomerInputDto;
//import com.luizacode.Coffee_is_the_new_Code.dto.CustomerOutputDto;
//import com.luizacode.Coffee_is_the_new_Code.model.Customer;
//import com.luizacode.Coffee_is_the_new_Code.model.Product;
//import com.luizacode.Coffee_is_the_new_Code.repository.CustomerRepository;
//import com.luizacode.Coffee_is_the_new_Code.repository.ProductRepository;
//import com.luizacode.Coffee_is_the_new_Code.service.CustomerService;
//import com.luizacode.Coffee_is_the_new_Code.service.ProductService;
//import org.junit.jupiter.api.Test;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Optional;
//
//import static com.luizacode.Coffee_is_the_new_Code.Mother.CustomerMother.*;
//import static com.luizacode.Coffee_is_the_new_Code.Mother.CustomerMother.createCustomerInputDto;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class ProductControllerTest {
//
//    private static final String PRODUCT_ENDPOINT = "/api/v1/product";
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private ProductService productService;
//
//    @MockBean
//    private ProductRepository productRepository;
//
//    @MockBean
//    private ModelMapper modelMapper;
//
//    @Test
//    public void givenValidProductWhenCreateThenReturnEntityProduct() throws Exception {
//
//        Product product = create
//        CustomerInputDto customerInputDto = createCustomerInputDto();
//        CustomerOutputDto customerOutputDto = createCustomerOutputDto();
//
//        given(customerService.save(any())).willReturn((customer));
//        given(customerRepository.save(any())).willReturn(customer);
//
//        Gson gson = new Gson();
//        String jsonBody = gson.toJson(customerInputDto);
//
//        mvc.perform(post(CUSTOMER_ENDPOINT)
//                .content(jsonBody)
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("utf-8")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andDo(print())
//                .andExpect(jsonPath("$.nome").value(customerOutputDto.getNome()))
//                .andExpect(jsonPath("$.password").value(customerOutputDto.getPassword()))
//                .andExpect(jsonPath("$.email").value(customerOutputDto.getEmail()));
//    }
//
//
//    @Test
//    public void givenValidIdWhenGetCustomerByIdThenReturnOk() throws Exception {
//
//        Customer customer = createCustomer();
//        CustomerOutputDto customerOutputDto = createCustomerOutputDto();
//
//        given(customerService.findById(1L)).willReturn(customer);
//        given(customerRepository.findById(1L)).willReturn(Optional.of(customer));
//        given(modelMapper.map(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any()))
//                .willReturn(customerOutputDto);
//
//        mvc.perform(get(CUSTOMER_ENDPOINT + "/" + customerOutputDto.getId()))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(jsonPath("$.id").value(customerOutputDto.getId()))
//                .andExpect(jsonPath("$.nome").value(customerOutputDto.getNome()))
//                .andExpect(jsonPath("$.email").value(customerOutputDto.getEmail()))
//                .andExpect(jsonPath("$.password").value(customerOutputDto.getPassword()));
//
//        verify(customerService, times(1)).findById(1L);
//    }
//
//    @Test
//    public void givenInvalidClientWhenCreateThenReturnBadRequest() throws Exception {
//        Gson gson = new Gson();
//        String jsonBody = gson.toJson(null);
//
//        mvc.perform(post(CUSTOMER_ENDPOINT)
//                .content(jsonBody)
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("utf-8")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest());
//
//    }
//
//    @Test
//    public void givenANullNameWhenCreateThenReturnBadRequest() throws Exception {
//
//        CustomerInputDto customerInputDto = createCustomerInputDto();
//        customerInputDto.setNome(null);
//        Gson gson = new Gson();
//        String jsonBody = gson.toJson(customerInputDto);
//
//        mvc.perform(post(CUSTOMER_ENDPOINT)
//                .content(jsonBody)
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("utf-8")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void givenANullEmailWhenCreateThenReturnBadRequest() throws Exception {
//
//        CustomerInputDto customerInputDto = createCustomerInputDto();
//        customerInputDto.setEmail(null);
//        Gson gson = new Gson();
//        String jsonBody = gson.toJson(customerInputDto);
//
//        mvc.perform(post(CUSTOMER_ENDPOINT)
//                .content(jsonBody)
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("utf-8")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    public void givenANullPasswordWhenCreateThenReturnBadRequest() throws Exception {
//
//        CustomerInputDto customerInputDto = createCustomerInputDto();
//        customerInputDto.setPassword(null);
//        Gson gson = new Gson();
//        String jsonBody = gson.toJson(customerInputDto);
//
//        mvc.perform(post(CUSTOMER_ENDPOINT)
//                .content(jsonBody)
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("utf-8")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }
//}
