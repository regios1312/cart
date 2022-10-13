package com.myntra.cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	private String itemName;
	private String cost;
	private long quantity;
	@ManyToOne
	@JoinColumn(name = "cart",referencedColumnName = "cartId")
	private Cart cart;
}
