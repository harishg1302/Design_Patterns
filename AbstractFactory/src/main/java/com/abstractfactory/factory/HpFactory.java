package com.abstractfactory.factory;

import com.abstractfactory.products.Computer;
import com.abstractfactory.products.HpComputer;
import com.abstractfactory.products.HpLaptop;
import com.abstractfactory.products.Laptop;

public class HpFactory implements Factory {

	@Override
	public Computer getComputer() {
		return new HpComputer();
	}

	@Override
	public Laptop getLaptop() {
		// TODO Auto-generated method stub
		return new HpLaptop();
	}

}
