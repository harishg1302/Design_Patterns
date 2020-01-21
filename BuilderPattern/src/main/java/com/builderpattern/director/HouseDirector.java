package com.builderpattern.director;

import com.builderpattern.builder.Builder;
import com.builderpattern.components.Garden;
import com.builderpattern.components.Room;
import com.builderpattern.components.SwimmingPool;

public class HouseDirector {

	public void constructSimpleHouse(Builder builder) {
		builder.setFloors(2);
		builder.setRoom(new Room(4,4,2));
		builder.setWalls("Sand");
		builder.setGarden(null);
		builder.setSwimmingPool(null);
	}
	
	public void constructBigHouse(Builder builder) {
		builder.setFloors(4);
		builder.setRoom(new Room(8,8,4));
		builder.setWalls("Concrete");
		builder.setGarden(new Garden(15));
		builder.setSwimmingPool(new SwimmingPool(5));
	}
}
