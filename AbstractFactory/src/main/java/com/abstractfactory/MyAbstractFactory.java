package com.abstractfactory;

import com.abstractfactory.factory.Factory;
import com.abstractfactory.products.Computer;
import com.abstractfactory.products.Laptop;

public class MyAbstractFactory {

	private Computer computer;
	private Laptop laptop;

	public void produceItems(Factory factory) {
		computer = factory.getComputer();
		laptop = factory.getLaptop();
	}

	public void producefinalProduct() {
		computer.getProduct();
		laptop.getProduct();
	}
}
