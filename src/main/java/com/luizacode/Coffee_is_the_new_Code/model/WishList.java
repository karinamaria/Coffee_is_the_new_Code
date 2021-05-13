package com.luizacode.Coffee_is_the_new_Code.model;

import java.util.Objects;
import java.util.Set;

public class WishList extends AbstractEntity {
    private Customer customer;
    private Set<Product> product;

    public WishList (){}

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WishList wishList = (WishList) o;
        return customer.equals(wishList.customer) && product.equals(wishList.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customer, product);
    }
}
