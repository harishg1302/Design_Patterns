package com.main.prototype;

public class OSProduct extends Product{

	public String version;
	
	public OSProduct() {
		
	}
	
	private OSProduct(OSProduct osproduct) {
		super(osproduct);
		this.version = osproduct.version;
	}
	
	@Override
	public Product clone() {
		return new OSProduct(this);
	}

	
}
