package com.myntra.cart.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.cart.entity.Cart;
import com.myntra.cart.entity.Item;
import com.myntra.cart.entity.Transaction;
import com.myntra.cart.repository.CartRepository;
import com.myntra.cart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Set<Item> getItemsInCart(Long cartId){
		log.info("Inside getItemsInCart method");
		Set<Item> items = null;
		try {
		   items = itemRepository.findAllByCartId(cartId);
		}catch(Exception e){
	    	log.error("Exception occured while fetching items inside cart");
		}
		return items;
	}
	
	public Set<Item> getCartById(Long userId) {
		log.info("Inside getCartById method");
		Set<Item> items = new HashSet<>();
	    try {
		  Cart cart = cartRepository.findByUserId(userId);
		  items = cart.getItems();
	    }catch(Exception e){
	    	log.error("Exception occured while fetching items inside cart");
	    }
		return items;
	}

	public Transaction addItemToCart(Item item) {
		log.info("Inside addItemToCart method");
		Transaction tx = new Transaction();
		try{
		   itemRepository.save(item);
		   tx.setResult("SUCCESS");
		}catch(Exception e) {
			log.error("Exception occured while adding items inside cart");
			tx.setError(e.getMessage());
			tx.setResult("FAILED");
		}
		return tx;
	}

	public Transaction removeItemFromCart(Item item) {
		log.info("Inside addItemToCart method");
		Transaction tx = new Transaction();
		try{
		   itemRepository.delete(item);
		   tx.setResult("SUCCESS");
		}catch(Exception e) {
			log.error("Exception occured while adding items inside cart");
			tx.setError(e.getMessage());
			tx.setResult("FAILED");
		}
		return tx;
	}
}
