package com.luizacode.Coffee_is_the_new_Code.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
public class WishListInputDto {
//	@ApiModelProperty(example = "1", required = true)
//	private Long idWishList;
	@NotNull
	@Positive
	@ApiModelProperty(example = "1", required = true)
	private Long idProduct;

	@NotNull
	@Positive
	@ApiModelProperty(example = "1", required = true)
	private Long idCustomer;

	public WishListInputDto() {

	}

//	public Long getIdWishList() {
//		return idWishList;
//	}
//
//	public void setIdWishList(Long idWishList) {
//		this.idWishList = idWishList;
//	}

	public WishListInputDto(Long idProduct, Long idCustomer) {
		this.idProduct = idProduct;
		this.idCustomer = idCustomer;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	

}
