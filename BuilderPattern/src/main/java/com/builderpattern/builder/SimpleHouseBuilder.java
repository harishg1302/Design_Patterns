package com.builderpattern.builder;

import com.builderpattern.components.Garden;
import com.builderpattern.components.Room;
import com.builderpattern.components.SwimmingPool;
import com.builderpattern.houses.SimpleHouse;

public class SimpleHouseBuilder implements Builder {
	
	private int floors;
	private String walls;
	private Room room;
	private Garden garden;
	private SwimmingPool swimmingPool;

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public void setWalls(String walls) {
		this.walls = walls;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setGarden(Garden garden) {
		this.garden = garden;
	}

	public void setSwimmingPool(SwimmingPool swimmingPool) {
			this.swimmingPool = swimmingPool;
	}

	public SimpleHouse getResult() {
		return new SimpleHouse(floors, walls, room, garden, swimmingPool);
	}
	
}
