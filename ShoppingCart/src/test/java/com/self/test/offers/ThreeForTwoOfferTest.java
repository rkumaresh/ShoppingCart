package com.self.test.offers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.self.test.offers.ThreeForTwoOffer;
import com.self.test.product.Item;

@RunWith(JUnit4.class)
public class ThreeForTwoOfferTest{

	@Test
	public void testBuyOneGetOneFreeReturnsCorrectDiscountPrice() throws Exception {
		ThreeForTwoOffer offer = new ThreeForTwoOffer();
		Map<Item, Integer> itemOffers = new HashMap<Item, Integer>();
		Item apple = new Item(1, "Apple");
		Item orange = new Item(2, "Orange");
		itemOffers.put(apple, 1);
		itemOffers.put(orange, 1);
		BigDecimal totalDiscountPrice = offer.getTotalDiscountPrice(itemOffers);
		Assert.assertEquals(Double.valueOf(0.0), Double.valueOf(totalDiscountPrice.doubleValue()));
		itemOffers.put(apple, 2);
		itemOffers.put(orange, 3);
		totalDiscountPrice = offer.getTotalDiscountPrice(itemOffers);
		Assert.assertEquals(Double.valueOf(.25), Double.valueOf(totalDiscountPrice.doubleValue())); //Only Orange is on offer for ThreeForTwoOffer.
		itemOffers.put(orange, 4);
		totalDiscountPrice = offer.getTotalDiscountPrice(itemOffers);
		Assert.assertEquals(Double.valueOf(.25), Double.valueOf(totalDiscountPrice.doubleValue())); //Only Apple is on offer for ThreeForTwoOffer.
	} 
}
