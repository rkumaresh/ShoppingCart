package com.self.test.offers;

import java.util.Collection;
import java.util.HashSet;

import com.self.test.product.Item;

public class BuyOneGetOneFreeOffer extends AbstractOfferTypes {
	private static final int OFFER_QUANTITY = 2;
	private Collection<Item> offerItems = new HashSet<Item>();
	
	public BuyOneGetOneFreeOffer() {
		//Mock Offer Items for simplicity
		offerItems.add(new Item(1, "Apple"));
	} 
 
	@Override
	public Collection<Item> getOfferItems() {
		return new HashSet<Item>(offerItems);
	}

	@Override
	protected int getOfferQnty(Item item) {
		if(offerItems.contains(item)){
			return OFFER_QUANTITY;
		}
		
		return 0;
	}
}
