package com.luizacode.Coffee_is_the_new_Code.dto;

import com.luizacode.Coffee_is_the_new_Code.model.WishList;

import java.math.BigDecimal;
import java.util.Set;

public class ProductOutputDto {
    private Long id;
    private String title;
    private Integer avaliableQuantity;
    private BigDecimal price;
    private Set<WishList> wishLists;

    public ProductOutputDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvaliableQuantity() {
        return avaliableQuantity;
    }

    public void setAvaliableQuantity(Integer avaliableQuantity) {
        this.avaliableQuantity = avaliableQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(Set<WishList> wishLists) {
        this.wishLists = wishLists;
    }
}
