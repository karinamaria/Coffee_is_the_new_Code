package com.luizacode.Coffee_is_the_new_Code.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Entity
@Table(name = "customer")
public class Customer extends AbstractEntity {

  private static final long serialVersionUID = 1L;

  @Column(name = "nome")
  @NotEmpty
  private String nome;

  @Column(name = "email")
  @NotEmpty
  private String email;

  @Column(name = "password")
  @NotEmpty
  @JsonIgnore
  private String password;

  @OneToOne
  @JoinColumn(name = "wishlist_id", referencedColumnName = "id")
  @JsonIgnore
  private WishList wishList;

  public Customer(Long id, String nome, String email, String password) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.password = password;
  }

  public Customer() {
    wishList = new WishList();
  }

  public WishList getWishList() {
    return wishList;
  }

  public void setWishList(WishList wishList) {
    this.wishList = wishList;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      if (!super.equals(o)) {
          return false;
      }
    Customer customer = (Customer) o;
    return Objects.equals(nome, customer.nome) && Objects.equals(email, customer.email) && Objects
        .equals(password, customer.password) && Objects.equals(wishList, customer.wishList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), nome, email, password, wishList);
  }
}
