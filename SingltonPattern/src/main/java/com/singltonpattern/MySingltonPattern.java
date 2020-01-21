package com.singltonpattern;

public class MySingltonPattern {

	public String value;
	private static MySingltonPattern instance;

	private MySingltonPattern(String value) {
		this.value = value;

	}

	public synchronized static MySingltonPattern getInstance(String value) {
		if (instance == null) {
			instance = new MySingltonPattern(value);
		}
		return instance;
	}

}
