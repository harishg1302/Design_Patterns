package com.builderpattern;

import com.builderpattern.builder.BigHouseBuilder;
import com.builderpattern.builder.SimpleHouseBuilder;
import com.builderpattern.director.HouseDirector;
import com.builderpattern.houses.BigHouse;
import com.builderpattern.houses.SimpleHouse;

public class ExecuteBuilder {

	public static void main(String[] args) {

		HouseDirector director = new HouseDirector();
		SimpleHouseBuilder simplebuilder = new SimpleHouseBuilder();
		director.constructSimpleHouse(simplebuilder);
		
		SimpleHouse simplehouse = simplebuilder.getResult();
		System.out.println("Floor="+simplehouse.getFloors() +", Walls="+simplehouse.getWalls()+", Rooms="+simplehouse.getRoom().getBedrooms()+"");
		
		
		BigHouseBuilder bigBuilder = new BigHouseBuilder();
		director.constructBigHouse(bigBuilder);
		
		BigHouse bigHouse= bigBuilder.getResult();
		System.out.println("Floor="+bigHouse.getFloors() +", Walls="+bigHouse.getWalls()+", Rooms="+bigHouse.getRoom().getBedrooms()+"");
		
	}

}
