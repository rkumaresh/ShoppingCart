package com.self.test;

import java.util.Collection;

import com.self.test.product.Item;

public interface CheckoutService { 

	Double getTotalPrice(Collection<Item> items);

}
