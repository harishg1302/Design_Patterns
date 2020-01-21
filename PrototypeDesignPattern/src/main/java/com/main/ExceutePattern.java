package com.main;

import com.main.prototype.MobileProduct;
import com.main.prototype.OSProduct;

public class ExceutePattern {

	public static void main(String[] args) {

		MobileProduct product = new MobileProduct();
		product.name = "Samsung";
		product.price = 25000;
		product.types = "Touch Screen";
		MobileProduct mproduct = (MobileProduct)product.clone();
		System.out.println(product +" & "+mproduct);
		System.out.println(mproduct.equals(product));
		
		
		OSProduct osproduct = new OSProduct();
		osproduct.name = "Samsung";
		osproduct.price = 25000;
		osproduct.version = "10";
		OSProduct osproductclone = (OSProduct)osproduct.clone();
		System.out.println(osproduct +" & "+osproductclone);
		System.out.println(osproduct.equals(osproductclone));
		
	}

}
