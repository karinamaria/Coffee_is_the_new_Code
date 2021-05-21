package com.luizacode.Coffee_is_the_new_Code.service;

import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import com.luizacode.Coffee_is_the_new_Code.model.Product;
import com.luizacode.Coffee_is_the_new_Code.model.WishList;
import com.luizacode.Coffee_is_the_new_Code.repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.luizacode.Coffee_is_the_new_Code.Mother.WishlistMother.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class WishListServiceTest {
    @InjectMocks
    private WishListService wishListService;

    @Mock
    private WishListRepository wishListRepository;

    @Mock
    private CustomerService customerService;

    @Mock
    private ProductService productService;

    @Test
    public void givenValidWishListInputDtoWhenCreateThenReturnEntityWishList() throws Exception {
        WishList wishList = createNewWishList();
        Customer customer = wishList.getCustomer();
        customer.setWishList(wishList);
        Product product = wishList.getProducts().iterator().next();

        given(customerService.findById(customer.getId())).willReturn(customer);
        given(productService.findById(product.getId())).willReturn(product);
        given(wishListRepository.save(wishList)).willReturn(wishList);

        WishList wishListResponse = wishListService.save(createWishListInputDto());
        then(wishListResponse.getId()).isEqualTo(customer.getId());
        then(wishListResponse.getProducts().iterator().next()).isEqualTo(product);
        then(wishListResponse.getCustomer()).isEqualTo(customer);
    }
    @Test
    void givenANullValueWhenGetWishListByIdThenReturnEmpty() {
        given(wishListRepository.findById(1L)).willReturn(Optional.of(createWishList()));

        WishList wishList = wishListService.findById(1L);

        then(wishListRepository.findById(2L)).isEmpty();
    }
}
