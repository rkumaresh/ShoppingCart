package com.self.test.offers;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

import com.self.test.product.Item;

public interface ShoppingOfferTypes {

	/**
	 * Gets the Total Discount price after calculating offers for each Item.
	 * @param itemQnty Map containing Item with quantity
	 * @return BigDecimal total discount price
	 */
	public BigDecimal getTotalDiscountPrice(Map<Item, Integer> itemQnty);
	
	/**
	 * Gets Item's available on offer.
	 * @return items Collection of items availble on offer
	 */
	public Collection<Item> getOfferItems();
} 