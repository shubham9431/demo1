package com.sparkleweb.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({
//	@NamedQuery(name = "getCartData", query = "from Cart where User.userId=:id")
})
 public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private String cartItemName;
	private String cartItemImage;
	private int cartItemPrice;
	private int cartItemQuantity;
	@ManyToOne
	private User user;
	
	public int getCartId() {
		return cartId;
	}
	public String getCartItemName() {
		return cartItemName;
	}
	public void setCartItemName(String cartItemName) {
		this.cartItemName = cartItemName;
	}
	public String getCartItemImage() {
		return cartItemImage;
	}
	public void setCartItemImage(String cartItemImage) {
		this.cartItemImage = cartItemImage;
	}
	public int getCartItemPrice() {
		return cartItemPrice;
	}
	public void setCartItemPrice(int cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}
	public int getCartItemQuantity() {
		return cartItemQuantity;
	}
	public void setCartItemQuantity(int cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
