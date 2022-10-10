package com.myntra.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myntra.cart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{
	
    public Cart findByCartId(Long cartId);
    
    public Cart findByUserId(Long userId);
}
