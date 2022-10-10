package com.myntra.cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Promo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String promoCode;
		
	private int discountPercent;
		
	private String error;
	
	private boolean isApplicable = true;
	
	private String fromDate;
	
	private String toDate;

	private Long priceBarrier;
	
}
