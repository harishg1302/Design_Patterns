package com.main.prototype;

public abstract class Product {
	
	public String name;
	public double price;
	
	public Product() {
		
	}
	
	public Product(Product product) {
		if(product!=null) {
			this.name = product.name;
			this.price = product.price;
		}
	}
	
	public abstract Product clone();
	
	public boolean equals(Product product) {
		if(product==null)
			return false;
		else {
			return((product.name.equals(this.name)) && (product.price == this.price));
		}
	}

}
