package com.swaraj.shop.model.catalog.product.type;

import java.io.Serializable;

import com.swaraj.shop.model.entity.Entity;

public class ProductTypeEntity extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private boolean visible;
	boolean allowAddToCart;

	public boolean isAllowAddToCart() {
		return allowAddToCart;
	}

	public void setAllowAddToCart(boolean allowAddToCart) {
		this.allowAddToCart = allowAddToCart;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}


}
