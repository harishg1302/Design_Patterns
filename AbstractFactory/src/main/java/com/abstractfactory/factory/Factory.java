package com.abstractfactory.factory;

import com.abstractfactory.products.Computer;
import com.abstractfactory.products.Laptop;

public interface Factory {

	public Computer getComputer();
	
	public Laptop getLaptop();
}
