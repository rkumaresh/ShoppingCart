package com.self.test;

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

	@Test
	public void testCheckoutServiceReturnsCorrectTotal() throws Exception {
		CheckoutService service = new CheckoutServiceImpl();
		Collection<Item> products = null;
		Double totalPrice = service.getTotalPrice(products);
		
		Assert.assertEquals(Double.valueOf(0), totalPrice);
		
		products = new ArrayList<Item>();
		Assert.assertEquals(Double.valueOf(0), totalPrice);

		products.add(apple);
		products.add(orange);
		totalPrice = service.getTotalPrice(products);
		Assert.assertEquals(Double.valueOf(.85), totalPrice);
	}
	 
}
