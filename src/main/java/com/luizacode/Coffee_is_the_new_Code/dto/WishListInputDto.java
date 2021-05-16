package com.luizacode.Coffee_is_the_new_Code.dto;

import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
public class WishListInputDto {
//	@ApiModelProperty(example = "1", required = true)
//	private Long idWishList;

	@ApiModelProperty(example = "1", required = true)
	private Long idProduct;

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
