package com.factorymethod;

import com.factorymethod.factory.BrandFactory;
import com.factorymethod.factory.Factory;
import com.factorymethod.factory.HomeMadeFactory;
import com.factorymethod.factory.SecondHandFactory;

public class MyFactoryMethod {

	private static Factory f;

	public static void main(String[] args) {
		MyFactoryMethod myFactoryMethod = new MyFactoryMethod();
		myFactoryMethod.configure("Brandfg");
		f.commanProductObject();
	}

	public void configure(String str) {
		if (str.equals("Home Made product")) {
			f = new HomeMadeFactory();
		} else if (str.equals("Brand"))
			f = new BrandFactory();
		else
			f = new SecondHandFactory();
	}

}
