package com.self.test;

import java.util.Collection;
import java.util.Map;

import com.self.test.product.Item;

public class CheckoutServiceImpl implements CheckoutService{

	 
	public CheckoutServiceImpl() {
	}
	
	@Override
	public Double getTotalPrice(Collection<Item> items) {
		Double totalPrice = new Double(0);
		Map<Item, Double> pricelist = PriceList.getPricelist();
		if(items == null || items.size() == 0){
			return totalPrice;
		}
		for (Item item : items) {
			Double price = (pricelist.get(item));
			totalPrice += price;
		}
		return totalPrice;
	}
}
