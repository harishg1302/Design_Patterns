package com.abstractfactory;

import com.abstractfactory.factory.DellFactory;
import com.abstractfactory.factory.Factory;
import com.abstractfactory.factory.HpFactory;

public class MyMainApp {

	static Factory factory;

	public static void setFactory(String company) {
		if (company.equals("Dell")) {
			factory = new DellFactory();
		} else {
			factory = new HpFactory();
		}
	}

	public static void main(String[] args) {
		MyAbstractFactory abstractFactory = new MyAbstractFactory();
		setFactory("Hp");
		abstractFactory.produceItems(factory);
		abstractFactory.producefinalProduct();
	}

}
