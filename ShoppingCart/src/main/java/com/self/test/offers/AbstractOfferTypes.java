package com.self.test.offers;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import com.self.test.PriceList;
import com.self.test.product.Item;

public abstract class AbstractOfferTypes implements ShoppingOfferTypes{

	@Override
	public BigDecimal getTotalDiscountPrice(Map<Item, Integer> itemQnty) {
		BigDecimal discountAmt = BigDecimal.valueOf(0);
		if(itemQnty == null || itemQnty.size() == 0){
			return discountAmt;
		} 
		
		Map<Item, Double> pricelist = PriceList.getPricelist();
		for (Entry<Item, Integer> item : itemQnty.entrySet()) {
			Integer qnty = item.getValue();
			int offerQnty = getOfferQnty(item.getKey());
			int noOfOffers = 0;
			if(offerQnty > 0 ){
				noOfOffers = qnty / offerQnty;
			}
			Double price = pricelist.get(item.getKey());
			if(noOfOffers > 0){
				discountAmt = discountAmt.add(BigDecimal.valueOf(noOfOffers * price));
			}
		}		
		return discountAmt;
	}
	
	protected abstract int getOfferQnty(Item item) ;
}
