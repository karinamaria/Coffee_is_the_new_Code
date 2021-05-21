package com.luizacode.Coffee_is_the_new_Code.controller;

import com.luizacode.Coffee_is_the_new_Code.dto.ProductOutputDto;
import com.luizacode.Coffee_is_the_new_Code.service.WishListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.luizacode.Coffee_is_the_new_Code.Mother.ProductMother.createListProductOutputDto;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({
        WishlistController.class,
        WishListService.class
})
public class WishListControllerTest {
    private static final String WISHLIST_ENDPOINT = "/api/v1/wishlist";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WishListService wishListService;

    @Test
    public void givenAValidIdWishListWhenGetListProductsThenReturnListProduct() throws Exception {
        List<ProductOutputDto> productOutputDtoListList = createListProductOutputDto();
        given(wishListService.findAllProductWishList(1L)).willReturn(productOutputDtoListList);

        mvc.perform(get(WISHLIST_ENDPOINT + "/" + "1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].id").value(productOutputDtoListList.get(0).getId()))
                .andExpect(jsonPath("$[0].title").value(productOutputDtoListList.get(0).getTitle()))
                .andExpect(jsonPath("$[0].avaliableQuantity").value(productOutputDtoListList.get(0).getAvaliableQuantity()))
                .andExpect(jsonPath("$[0].price").value(productOutputDtoListList.get(0).getPrice()));
    }

    @Test
    public void givenValidIdCustomerAndIdProductWhenReturnMessageSucess() throws Exception {
        given(wishListService.checkProductWishList(1L, 1L)).willReturn(true);
        mvc.perform(get(WISHLIST_ENDPOINT + "/" + "1" + "/" + "1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").value("A wishList possui o produto"));
    }

}
