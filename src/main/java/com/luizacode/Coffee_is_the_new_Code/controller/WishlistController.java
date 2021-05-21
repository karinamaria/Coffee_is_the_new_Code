package com.luizacode.Coffee_is_the_new_Code.controller;

import com.luizacode.Coffee_is_the_new_Code.dto.WishListInputDto;
import com.luizacode.Coffee_is_the_new_Code.model.WishList;
import com.luizacode.Coffee_is_the_new_Code.service.WishListService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@ApiModel(value = "Wishlist Controller")
@RestController
@RequestMapping("/api/v1/wishlist")
public class WishlistController {
    @Autowired
    private WishListService wishListService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adds a product to wishList", notes = "Also returns a link to retrieve the saved wishList in the location header")
    public ResponseEntity<?> register(@RequestBody @Valid WishListInputDto wishListInputDto){
        WishList wishListModel = wishListService.save(wishListInputDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(wishListModel.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/{idWishlist}")
    @ApiOperation(value = "Returns all products from the wishlist")
    public ResponseEntity<?> consultWishlist(@PathVariable("idWishlist") Long idWishList){
        return new ResponseEntity<>(wishListService.findAllProductWishList(idWishList), HttpStatus.OK);
    }
    
    @GetMapping("/{idCustomer}/{idProduct}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Checks if a wishlist has a product")
    public ResponseEntity<String> consultProductWishlist(@PathVariable("idCustomer") Long idCustomer, @PathVariable("idProduct") Long idProduct){
        String resultado = "A wishList possui o produto";
        
        resultado = wishListService.checkProductWishList(idCustomer, idProduct) ? resultado :
        			"A wishList não possui o produto";
        
    	return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a product of wishlist")
    public void deleteProductWishList(@RequestBody @Valid WishListInputDto wishListInputDto){
    	wishListService.deleteProductOfWishlist(wishListInputDto);
    }

}
