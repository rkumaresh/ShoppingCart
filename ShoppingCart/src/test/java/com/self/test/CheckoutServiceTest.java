package com.self.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.self.test.CheckoutService;
import com.self.test.CheckoutServiceImpl;
import com.self.test.product.Item;

@RunWith(JUnit4.class)
public class CheckoutServiceTest{
	//Put Sample Items with id same as in PriceList
	private Item apple = new Item(1, "Apple");
	private Item orange = new Item(2, "Orange");
	private CheckoutService service = new CheckoutServiceImpl();

	@Test
	public void testCheckoutServiceReturnsCorrectTotal() throws Exception {
		Collection<Item> items = null;
		BigDecimal totalPrice = service.getTotalPrice(items);
		
		Assert.assertEquals(Double.valueOf(0), Double.valueOf(totalPrice.doubleValue()));
		
		items = new ArrayList<Item>();
		Assert.assertEquals(Double.valueOf(0), Double.valueOf(totalPrice.doubleValue()));

		items.add(apple);
		items.add(orange);
		totalPrice = service.getTotalPrice(items);
		Assert.assertEquals(Double.valueOf(.85), Double.valueOf(totalPrice.doubleValue()));
	}

	@Test
	public void testCheckoutServiceReturnsCorrectTotalForBuyOneGetOneFree() throws Exception {
		Collection<Item> items = new ArrayList<Item>();
		items.add(apple);
		items.add(apple);
		items.add(apple);
		BigDecimal totalPrice = service.getTotalPrice(items);
		Assert.assertEquals(Double.valueOf(1.20), Double.valueOf(totalPrice.doubleValue()));
		items.add(orange);
		totalPrice = service.getTotalPrice(items);
		Assert.assertEquals(Double.valueOf(1.45), Double.valueOf(totalPrice.doubleValue())); 
	}
	
	@Test
	public void testCheckoutServiceReturnsCorrectTotalThreeForTwoOffer() throws Exception {
		Collection<Item> items = new ArrayList<Item>();
		items.add(orange);
		items.add(orange);
		items.add(orange);
		BigDecimal totalPrice = service.getTotalPrice(items);
		Assert.assertEquals(Double.valueOf(.50), Double.valueOf(totalPrice.doubleValue()));
		items.add(orange);
		totalPrice = service.getTotalPrice(items);
		Assert.assertEquals(Double.valueOf(.75), Double.valueOf(totalPrice.doubleValue()));
		items.add(apple);
		totalPrice = service.getTotalPrice(items);
		Assert.assertEquals(Double.valueOf(1.35), Double.valueOf(totalPrice.doubleValue()));
	}
	
	@Test
	public void testCheckoutServiceReturnsCorrectTotalWithAllOffers() throws Exception {
		Collection<Item> items = new ArrayList<Item>();
		items.add(orange);
		items.add(orange);
		items.add(orange);
		items.add(apple);
		items.add(apple);
		BigDecimal totalPrice = service.getTotalPrice(items);
		Assert.assertEquals(Double.valueOf(1.10), Double.valueOf(totalPrice.doubleValue()));
	}
	

}
