package com.luizacode.Coffee_is_the_new_Code.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class Product extends AbstractEntity {
    private String title;
    private int avaliableQuantity;
    private BigDecimal price;
    private Set<WishList> wishLists;

    public Product (){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvaliableQuantity() {
        return avaliableQuantity;
    }

    public void setAvaliableQuantity(int avaliableQuantity) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return avaliableQuantity == product.avaliableQuantity && title.equals(product.title) && price.equals(product.price) && wishLists.equals(product.wishLists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, avaliableQuantity, price, wishLists);
    }
}
