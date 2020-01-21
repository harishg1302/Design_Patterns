package com.build;

public class BuilderExecution {

	public static void main(String[] args) {

		Product product =new Product.ProductBuilder().setName("Laptop").setBrand("HP").setPrice(35000.00).setWarranty(2).build();
		product.display();
	}

}
