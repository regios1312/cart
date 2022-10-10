package com.myntra.cart.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.cart.entity.Cart;
import com.myntra.cart.entity.Item;
import com.myntra.cart.repository.CartRepository;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public Set<Item> getCartById(Long userId) {
		log.info("Inside getCartById method");
		Set<Item> items = new HashSet<>();
	    try {
		  Cart cart = cartRepository.findByCartId(userId);
		  items = cart.getItems();
	    }catch(Exception e){
	    	log.error("Exception occured while fetching items inside cart");
	    }
		return items;
	}

	public Item addItemToCart(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Item removeItemFromCart(Item item) {
		// TODO Auto-generated method stub
		return null;
	}
}
