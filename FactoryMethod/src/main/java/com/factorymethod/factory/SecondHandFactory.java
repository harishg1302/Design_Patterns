package com.factorymethod.factory;

import com.factorymethod.products.Product;
import com.factorymethod.products.SecondHandProduct;

public class SecondHandFactory implements Factory{

	public Product createProduct() {
		return new SecondHandProduct();
	}

}
