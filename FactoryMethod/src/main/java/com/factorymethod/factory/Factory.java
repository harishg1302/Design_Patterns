package com.factorymethod.factory;

import com.factorymethod.products.Product;

public interface Factory {

	default public void commanProductObject() {
		Product p = createProduct();
		p.produce();
	}

	public Product createProduct();
}
