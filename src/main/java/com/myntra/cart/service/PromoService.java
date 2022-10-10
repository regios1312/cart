package com.myntra.cart.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.myntra.cart.entity.Cart;
import com.myntra.cart.entity.Promo;
import com.myntra.cart.repository.PromoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PromoService {

	@Autowired
	private PromoRepository promoRepository;
	
	public BiFunction<Long,Long,Boolean> validatePriceBarrier = (totalCost,priceBarrier) -> {
		return totalCost >= priceBarrier;
	};
	
	public Promo validatePromoCodeApplication(Cart cart) {
		log.info("Inside validatePromoCodeApplication method of PromoService");
		Promo promo = promoRepository.getByPromoCode(cart.getAppliedPromoCode());
		String error = null;
		if(!validateDateRange(promo)) {
			error = "Promo Code is past validity";
		}
		else if(validatePriceBarrier.apply(cart.getTotalCost(),promo.getPriceBarrier())) {
			error = "Total cost of ietms in cart is below price barrier";
		}
		if(!ObjectUtils.isEmpty(error)) {
			promo.setError(error);
			promo.setApplicable(false);
		}
	    return promo;
	}
	
	public Date getEffectiveDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date returnDate = null;
		try {
		   returnDate = formatter.parse(date);
		}catch(Exception e) {
			log.error("Error occured while parsing date {}",e);
		}
		return returnDate;
	}
	
	public boolean validateDateRange(Promo promo) {
		boolean isValid = false;
		Date fromDate = getEffectiveDate(promo.getFromDate());
		Date toDate = getEffectiveDate(promo.getToDate());
		if(fromDate.after(new Date()) && toDate.before(new Date())) {
			isValid = true;
		}
		return isValid;
	}
}
