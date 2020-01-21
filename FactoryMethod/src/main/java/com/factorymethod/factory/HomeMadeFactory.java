package com.factorymethod.factory;

import com.factorymethod.products.HomeMadeProduct;
import com.factorymethod.products.Product;

public class HomeMadeFactory implements Factory {


	public Product createProduct() {
		return new HomeMadeProduct();
	}

}
