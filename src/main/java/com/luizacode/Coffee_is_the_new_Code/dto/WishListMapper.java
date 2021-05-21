package com.luizacode.Coffee_is_the_new_Code.dto;

import com.luizacode.Coffee_is_the_new_Code.model.WishList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WishListMapper {

    WishListOutputDto wishListToWishListOutputDto(WishList wishList);

    WishListInputDto wishListToWishListInputDto(WishList wishList);
}
