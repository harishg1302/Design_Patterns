package com.build;

public class Product {

	public Product(ProductBuilder builder) {
		this.name =builder.name;
		this.Brand = builder.Brand;
		this.price = builder.price;
		this.warranty = builder.warranty;
	}
	
	public void display() {
		System.out.println(this.name+", "+this.Brand+", "+this.price+", "+this.warranty);
	}

	private String name;
	private String Brand;
	private double price;
	private int warranty;
	
	static class ProductBuilder{
		private String name;
		private String Brand;
		private double price;
		private int warranty;
		
		public ProductBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public ProductBuilder setBrand(String brand) {
			Brand = brand;
			return this;
		}
		public ProductBuilder setPrice(double price) {
			this.price = price;
			return this;
		}
		public ProductBuilder setWarranty(int warranty) {
			this.warranty = warranty;
			return this;
		}
		
		public Product build() {
			return new Product(this);
		}
	}
}
