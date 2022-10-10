package com.myntra.cart.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myntra.cart.entity.Cart;
import com.myntra.cart.entity.Item;
import com.myntra.cart.entity.Promo;
import com.myntra.cart.service.CartService;
import com.myntra.cart.service.PromoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/cart")
@Slf4j
public class CartController{
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private PromoService promoService;
	
	@PostMapping("/add/item")
	public Item addItemToCart(@RequestBody Item item) {
		return cartService.addItemToCart(item);
	}
	
	@PostMapping("/remove/item")
	public Item removeItemFromCart(@RequestBody Item item) {
		return cartService.removeItemFromCart(item);
	}
	
	@GetMapping("/{id}")
    public Set<Item> getCartItemsByUserId(@PathVariable("id") Long id) {
		log.info("Inside getCartById method of CartController");
		return cartService.getCartById(id);
	}
	
	@PostMapping("/promo/validate")
	public Promo validatePromoCodeApplication(@RequestBody Cart cart) {
		log.info("Inside validatePromoCodeApplication method of CartController");
		return promoService.validatePromoCodeApplication(cart);
	}
	
}
