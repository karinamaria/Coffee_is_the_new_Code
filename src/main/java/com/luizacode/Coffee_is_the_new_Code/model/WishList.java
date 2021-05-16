package com.luizacode.Coffee_is_the_new_Code.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="wishlist")
public class WishList extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy = "wishList")
	@JsonBackReference
	private Customer customer;

    //@ManyToMany(mappedBy="wishLists") , targetEntity = Product.class, fetch = FetchType.EAGER
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="wishlist_product",
            joinColumns={@JoinColumn(name="wishilist_id")},
            inverseJoinColumns={@JoinColumn(name="produto_id")})
    @JsonBackReference
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
    
    
}
