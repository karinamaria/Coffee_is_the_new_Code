package com.luizacode.Coffee_is_the_new_Code.service;

import com.luizacode.Coffee_is_the_new_Code.dto.WishListInputDto;
import com.luizacode.Coffee_is_the_new_Code.dto.WishListOutputDto;
import com.luizacode.Coffee_is_the_new_Code.model.Customer;
import com.luizacode.Coffee_is_the_new_Code.model.Product;
import com.luizacode.Coffee_is_the_new_Code.model.WishList;
import com.luizacode.Coffee_is_the_new_Code.repository.WishListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WishListService {
    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;
    
    public WishList findById(Long id) {
    	WishList wishList = wishListRepository.findById(id).orElse(null);

    	return wishList;
    }
    
    public WishList save(WishListInputDto wishListInputDto){
        Product product = productService.findById(wishListInputDto.getIdProduct());
        Customer customer = customerService.findById(wishListInputDto.getIdCustomer());
        
        WishList wishListModel = new WishList();

        if(Objects.isNull(customer.getWishList())){
            wishListModel.setProducts(new HashSet<Product>());
        }else {
        	wishListModel = customer.getWishList();
        }
        
        wishListModel.getProducts().add(product);
        wishListModel.setCustomer(customerService.findById(wishListInputDto.getIdCustomer()));
        
        wishListModel = wishListRepository.save(wishListModel);

        if(Objects.isNull(customer.getWishList())) {
        	customer.setWishList(wishListModel);
        	customerService.save(customer);
        }
        return wishListModel;
    }

    public WishListOutputDto findAll(Long id){
        WishList wishList = findById(id);
        
        WishListOutputDto wishListOutputDto = modelMapper.map(wishList,WishListOutputDto.class);
        return wishListOutputDto;
    }

    public void deleteProductOfWishlist(WishListInputDto wishListInputDto){
    	Customer customer = customerService.findById(wishListInputDto.getIdCustomer());
    	
    	if(Objects.nonNull(customer.getWishList())){
    	    WishList wishList = customer.getWishList();
            //Buscar Produto que será excluido
            Product product = productService.findById(wishListInputDto.getIdProduct());

            if(wishList.getProducts().contains(product)) {
                wishList.getProducts().remove(product);
            }

            if(wishList.getProducts().size() == 0) {
                customer.setWishList(null);
                customerService.save(customer);
                wishListRepository.delete(wishList);
            }
        }
    	
    }
    
    public boolean checkProductWishList(Long idCustomer, Long idProduct) {
    	Customer customer = customerService.findById(idCustomer);
    	boolean wishListHasProduct = false;
    	if(Objects.nonNull(customer.getWishList().getProducts())) {
    		Product product = productService.findById(idProduct);
    		
    		if(Objects.nonNull(product)) {
    			wishListHasProduct = customer.getWishList().getProducts().contains(product);
    		}
    	}
    	
    	return wishListHasProduct;
    }
}
