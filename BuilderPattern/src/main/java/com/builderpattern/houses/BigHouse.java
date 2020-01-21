package com.builderpattern.houses;

import com.builderpattern.components.Garden;
import com.builderpattern.components.Room;
import com.builderpattern.components.SwimmingPool;

public class BigHouse {
	
	private final int floors;
	private final String walls;
	private final Room room;
	private final Garden garden;
	private final SwimmingPool swimmingPool;
	private int pillars = 4;
	
	public BigHouse(int floors, String walls, Room room, Garden garden, SwimmingPool swimmingPool) {
		this.floors = floors;
		this.walls = walls;
		this.room = room;
		this.garden = garden;
		this.swimmingPool = swimmingPool;
	}
	
	
	public int getPillars() {
		return pillars;
	}


	public void setPillars(int pillars) {
		this.pillars = pillars;
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
