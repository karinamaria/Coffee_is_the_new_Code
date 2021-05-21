package com.luizacode.Coffee_is_the_new_Code;

import com.luizacode.Coffee_is_the_new_Code.model.WishList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WishListTeste {
    @Test
    public void objectMustBeEquals(){
        WishList wishlist1 = new WishList();
        wishlist1.setCustomer(wishlist1.getCustomer());
        wishlist1.setId(26826L);
        wishlist1.setProducts(wishlist1.getProducts());

        WishList wishlist2 = new WishList();
        wishlist2.setCustomer(wishlist2.getCustomer());
        wishlist2.setId(26826L);
        wishlist2.setProducts(wishlist2.getProducts());

        Assertions.assertEquals(wishlist1, wishlist2);
    }
    @Test
    public void objectMustNotBeEquals () {
        WishList wishlist1 = new WishList();
        wishlist1.setCustomer(wishlist1.getCustomer());
        wishlist1.setId(26826L);
        wishlist1.setProducts(wishlist1.getProducts());

        WishList wishlist2 = new WishList();
        wishlist2.setCustomer(wishlist2.getCustomer());
        wishlist2.setId(2652266L);
        wishlist2.setProducts(wishlist2.getProducts());

        Assertions.assertNotEquals(wishlist1, wishlist2);
    }

}
