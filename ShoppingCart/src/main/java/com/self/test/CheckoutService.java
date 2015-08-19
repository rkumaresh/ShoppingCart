package com.self.test;

import java.math.BigDecimal;
import java.util.Collection;

import com.self.test.product.Item;

public interface CheckoutService { 

	BigDecimal getTotalPrice(Collection<Item> items);

}
