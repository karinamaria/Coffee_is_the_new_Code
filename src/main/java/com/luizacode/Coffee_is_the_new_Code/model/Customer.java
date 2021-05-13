package com.luizacode.Coffee_is_the_new_Code.model;

import java.util.Objects;

public class Customer extends AbstractEntity {
    private String nome;
    private String email;
    private String password;
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
