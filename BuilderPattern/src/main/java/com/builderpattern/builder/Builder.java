package com.builderpattern.builder;

import com.builderpattern.components.Garden;
import com.builderpattern.components.Room;
import com.builderpattern.components.SwimmingPool;

public interface Builder {

	void setFloors(int floors);

	void setWalls(String walls);

	void setRoom(Room room);

	void setGarden(Garden garden);

	void setSwimmingPool(SwimmingPool swimmingPool);

}
