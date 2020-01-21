package com.abstractfactory.factory;

import com.abstractfactory.products.Computer;
import com.abstractfactory.products.DellComputer;
import com.abstractfactory.products.DellLaptop;
import com.abstractfactory.products.Laptop;

public class DellFactory implements Factory {

	@Override
	public Computer getComputer() {
		return new DellComputer();
	}

	@Override
	public Laptop getLaptop() {
		// TODO Auto-generated method stub
		return new DellLaptop();
	}

}
