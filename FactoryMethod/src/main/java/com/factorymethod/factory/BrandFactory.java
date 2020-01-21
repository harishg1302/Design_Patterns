package com.factorymethod.factory;

import com.factorymethod.products.BrandedProduct;
import com.factorymethod.products.Product;

public class BrandFactory implements Factory {


	public Product createProduct() {
		return new BrandedProduct();
		
	}
	
}
