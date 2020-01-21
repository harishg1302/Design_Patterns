package com.builderpattern.houses;

import com.builderpattern.components.Garden;
import com.builderpattern.components.Room;
import com.builderpattern.components.SwimmingPool;

public class SimpleHouse {

	private final int floors;
	private final String walls;
	private final Room room;
	private final Garden garden;
	private final SwimmingPool swimmingPool;
	
	public SimpleHouse(int floors, String walls, Room room, Garden garden, SwimmingPool swimmingPool) {
		this.floors = floors;
		this.walls = walls;
		this.room = room;
		this.garden = garden;
		this.swimmingPool = swimmingPool;
	}
	
	public int getFloors() {
		return floors;
	}

	public String getWalls() {
		return walls;
	}

	public Room getRoom() {
		return room;
	}

	public Garden getGarden() {
		return garden;
	}

	public SwimmingPool getSwimmingPool() {
		return swimmingPool;
	}

	
	
	
}
