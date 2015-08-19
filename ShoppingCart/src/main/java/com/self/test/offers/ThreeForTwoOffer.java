package com.self.test.offers;

import java.util.Collection;
import java.util.HashSet;

import com.self.test.product.Item;

public class ThreeForTwoOffer extends AbstractOfferTypes {
	private static final int OFFER_QUANTITY = 3;
	private Collection<Item> offerItems = new HashSet<Item>();

	public ThreeForTwoOffer() {
		//Mock Offer Items for simplicity
		offerItems.add(new Item(2, "Orange")); 
	}
 
	@Override
	public Collection<Item> getOfferItems() {
		return new HashSet<>(offerItems);
	}

	@Override
	protected int getOfferQnty(Item item) {
		if(offerItems.contains(item)){
			return OFFER_QUANTITY;
		}
		return 0;
	}
	
}
