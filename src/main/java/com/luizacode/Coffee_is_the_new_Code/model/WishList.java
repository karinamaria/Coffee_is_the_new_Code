package com.luizacode.Coffee_is_the_new_Code.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@Table(name="wishlist")
public class WishList extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy = "wishList")
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name="wishlist_products",
	            joinColumns={@JoinColumn(name="wishilist_id")},
	            inverseJoinColumns={@JoinColumn(name="produto_id")})
    private Set<Product> products;

    public WishList (){}

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WishList wishList = (WishList) o;
        return customer.equals(wishList.customer) && products.equals(wishList.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customer, products);
    }
}
