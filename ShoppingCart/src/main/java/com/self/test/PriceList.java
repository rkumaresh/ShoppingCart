package com.self.test;

import java.util.HashMap;
import java.util.Map;

import com.self.test.product.Item;

public class PriceList { 
	//Mock the price for simplicity
	private static final Map<Item, Double> priceList = new HashMap<Item, Double>();
	static{
		priceList.put(new Item(1, "Apple"), Double.valueOf(.60));
		priceList.put(new Item(2, "Orange"), Double.valueOf(.25));
	}
 
	public static Map<Item, Double> getPricelist() {
		return new HashMap<>(priceList);
	}
}
