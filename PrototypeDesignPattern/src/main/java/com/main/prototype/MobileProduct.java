package com.main.prototype;

public class MobileProduct extends Product {

	public String types;
	
	public MobileProduct() {
		
	}
	
	private MobileProduct(MobileProduct mproduct) {
		super(mproduct);
		this.types = mproduct.types;
	}
	
	@Override
	public Product clone() {
		return new MobileProduct(this);
	}
	
}
