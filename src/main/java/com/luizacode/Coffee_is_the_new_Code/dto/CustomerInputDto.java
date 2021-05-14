package com.luizacode.Coffee_is_the_new_Code.dto;

import com.luizacode.Coffee_is_the_new_Code.model.WishList;

public class CustomerInputDto {
	private String nome;
	private String email;
	private String password;
	private WishList products;
	
	public CustomerInputDto() {
		
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
	public WishList getProducts() {
		return products;
	}
	public void setProducts(WishList products) {
		this.products = products;
	}
	
}
