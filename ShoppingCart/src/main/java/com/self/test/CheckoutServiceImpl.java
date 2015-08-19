package com.self.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.self.test.offers.BuyOneGetOneFreeOffer;
import com.self.test.offers.ShoppingOfferTypes;
import com.self.test.offers.ThreeForTwoOffer;
import com.self.test.product.Item;

public class CheckoutServiceImpl implements CheckoutService{

	private Collection<ShoppingOfferTypes> offers = new ArrayList<ShoppingOfferTypes>();  

	 
	public CheckoutServiceImpl() {
		offers.add(new BuyOneGetOneFreeOffer());
		offers.add(new ThreeForTwoOffer());
	}
	
	@Override
	public BigDecimal getTotalPrice(Collection<Item> items) {
		BigDecimal totalPrice = BigDecimal.valueOf(0.00);
		Map<Item, Double> pricelist = PriceList.getPricelist();
		if(items == null || items.size() == 0){
			return totalPrice;
		}
		Map<Item, Integer> itemQnty = new HashMap<Item, Integer>();
		for (Item item : items) {
			Double itemPrice = (pricelist.get(item));
			totalPrice = totalPrice.add(BigDecimal.valueOf(itemPrice));
			Integer qnty = itemQnty.get(item);
			if(qnty == null){
				itemQnty.put(item, Integer.valueOf(1));
			}else{
				itemQnty.put(item, ++ qnty);
			}
		}
		for (ShoppingOfferTypes offer : offers) {
			BigDecimal discountPrice = offer.getTotalDiscountPrice(itemQnty);
			totalPrice = totalPrice.subtract(discountPrice);
		}
		return totalPrice;
	}
}
