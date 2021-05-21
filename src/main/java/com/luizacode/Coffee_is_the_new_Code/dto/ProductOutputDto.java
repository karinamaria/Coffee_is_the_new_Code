package com.luizacode.Coffee_is_the_new_Code.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luizacode.Coffee_is_the_new_Code.model.WishList;

import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.util.Set;

@ApiIgnore
public class ProductOutputDto {
    private Long id;
    private String title;
    private Integer avaliableQuantity;
    private BigDecimal price;
    @JsonIgnore
    private Set<WishList> wishLists;

    public ProductOutputDto(Long id, String title, Integer avaliableQuantity, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.avaliableQuantity = avaliableQuantity;
        this.price = price;
    }

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
