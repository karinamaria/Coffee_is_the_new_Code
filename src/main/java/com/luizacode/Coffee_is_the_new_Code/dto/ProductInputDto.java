package com.luizacode.Coffee_is_the_new_Code.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel(value = "Product")
public class ProductInputDto {
    @NotNull
    @ApiModelProperty(example = "title", required = true)
    private String title;

    @NotNull
    @ApiModelProperty(example = "100", required = true)
    private Integer avaliableQuantity;

    @NotNull
    @ApiModelProperty(example = "199.99", required = true)
    private BigDecimal price;

    public ProductInputDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvaliableQuantity() {
        return avaliableQuantity;
    }

    public void setAvaliableQuantity(Integer avaliableQuantity) {
        this.avaliableQuantity = avaliableQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
