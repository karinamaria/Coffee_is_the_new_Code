package com.luizacode.Coffee_is_the_new_Code.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "email", unique = true, nullable = false)
    private String email;
	
	@Column(name = "password", nullable = false)
    private String password;
    
    @OneToOne
    @JoinColumn(name = "wishlist_id", referencedColumnName = "id")
    private WishList wishList;

    public Customer (){}

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword(){
        return password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return nome.equals(customer.nome) && email.equals(customer.email) && password.equals(customer.password) && wishList.equals(customer.wishList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nome, email, password, wishList);
    }
}
