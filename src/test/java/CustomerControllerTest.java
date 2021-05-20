import com.google.gson.Gson;
import com.luizacode.Coffee_is_the_new_Code.Mother.CustomerMother;
import com.luizacode.Coffee_is_the_new_Code.dto.CustomerInputDto;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import com.luizacode.Coffee_is_the_new_Code.repository.CustomerRepository;
import com.luizacode.Coffee_is_the_new_Code.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static com.luizacode.Coffee_is_the_new_Code.Mother.CustomerMother.createCustomerInputDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest({

     //   CustomerController.class,
        //CustomerService.class,
       // ModelMapper.class
//})
public class CustomerControllerTest {

    private static final String CUSTOMER_ENDPOINT = "/api/v1/customer";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;
    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private ModelMapper modelMapper;

    private CustomerInputDto customer;


    @Test
    public void givenValidCustomerWhenCreateThenReturnEntityCustomer() throws Exception {

        customer = createCustomerInputDto();

        given(customerService.save(any())).willReturn(modelMapper.map(customer, Customer.class));

        Gson gson = new Gson();
        String jsonBody = gson.toJson(customer);

        mvc.perform(post(CUSTOMER_ENDPOINT)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.nome").value(customer.getNome()))
                .andExpect(jsonPath("$.password").value(customer.getPassword()))
                .andExpect(jsonPath("$.email").value(customer.getEmail()));
    }


    @Test
   public void givenValidIdWhenGetCustomerByIdThenReturnOk() throws Exception {

        Customer customer = CustomerMother.createCustomer();
        given(customerService.findById(1L)).willReturn(modelMapper.map(customer, Customer.class));
        given(customerRepository.findById(1L)).willReturn(Optional.of(customer));

        mvc.perform(get(CUSTOMER_ENDPOINT + "/" + customer.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id").value(customer.getId()))
                .andExpect(jsonPath("$.nome").value(customer.getNome()))
                .andExpect(jsonPath("$.email").value(customer.getEmail()))
                .andExpect(jsonPath("$.password").value(customer.getPassword()));

        verify(customerService, times(1)).findById(1L);
    }


//   public void givenINvalidClientWhenCreateThenReturnBadRequest() throws Exception {
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
}
