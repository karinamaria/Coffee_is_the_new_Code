package com.luizacode.Coffee_is_the_new_Code.Mother;

import com.luizacode.Coffee_is_the_new_Code.dto.WishListInputDto;
import com.luizacode.Coffee_is_the_new_Code.model.WishList;

import java.util.HashSet;

import static com.luizacode.Coffee_is_the_new_Code.Mother.CustomerMother.createCustomer;
import static com.luizacode.Coffee_is_the_new_Code.Mother.ProductMother.createListProduct;

public class WishlistMother {

    public static WishList createWishList() {
        return new WishList();
    }
    public static WishList createNewWishList(){
        return new WishList(1L, createCustomer(), new HashSet<>(createListProduct()));
    }

    public static WishListInputDto createWishListInputDto(){
        return new WishListInputDto(1L, 1L);
    }

}
