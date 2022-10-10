package com.myntra.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myntra.cart.entity.Promo;

@Repository
public interface PromoRepository extends JpaRepository<Promo,Long>{

	public Promo getByPromoCode(String promoCode);
	
}
