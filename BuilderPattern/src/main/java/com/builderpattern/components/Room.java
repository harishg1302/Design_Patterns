package com.builderpattern.components;

public class Room {

	private int bedrooms;
	private int washrooms;
	private int storerooms;

	public Room(int bedrooms, int washrooms, int storerooms) {
		this.bedrooms = bedrooms;
		this.washrooms = washrooms;
		this.storerooms = storerooms;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getWashrooms() {
		return washrooms;
	}

	public void setWashrooms(int washrooms) {
		this.washrooms = washrooms;
	}

	public int getStorerooms() {
		return storerooms;
	}

	public void setStorerooms(int storerooms) {
		this.storerooms = storerooms;
	}

}
