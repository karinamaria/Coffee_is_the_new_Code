package com.luizacode.Coffee_is_the_new_Code.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "Customer")
public class CustomerInputDto {

  @NotNull
  @ApiModelProperty(example = "nome", required = true)
  private String nome;

  @NotNull
  @Email(message = "Email should be valid")
  @ApiModelProperty(example = "user@user.com", required = true)
  private String email;

  @NotNull
  @ApiModelProperty(example = "P@ssw0rd", required = true)
  private String password;

  public CustomerInputDto() {

  }

  public CustomerInputDto(String nome, String email, String password) {
    this.nome = nome;
    this.email = email;
    this.password = password;
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


}
