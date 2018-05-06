package com.island;

import java.util.ArrayList;
import java.util.List;

public class IslandCounter {
	
	public int count(int[][] world) {
		if(world == null || world.length == 0) {
			return 0;
		}

		List<Island> islands = new ArrayList<Island>();

		for (int x = 0; x < world.length; x++) {
			int[] currentRow = world[x];
			for (int y = 0; y < currentRow.length; y++) {
				if(currentRow[y] == 1) { // found land
					Island adjacentIsland = findAdjacentIsland(islands, x, y);
					if(adjacentIsland == null) {
						adjacentIsland = new Island();
						adjacentIsland.addXCoordinate(x);
						adjacentIsland.addYCoordinate(y);
						islands.add(adjacentIsland);
					}
				}
			}
		}
		
		return islands.size();
	}

	private Island findAdjacentIsland(List<Island> islands, int x, int y) {
		for(Island island : islands) {
			boolean xCoordinateInRange = false;
			boolean yCoordinateRange = false;
			
			int currentXRangeMin = x - 1;
			int currentXRangeMax = x;
			
			int currentYRangeMin = y - 1;
			int currentYRangeMax = y;
			
			for(int xRange = currentXRangeMin; xRange <= currentXRangeMax; xRange++) { // Fixed time complexity O(2) => O(1)
				if(island.isXCoordinateExists(xRange)) {
					xCoordinateInRange = true;
					break;
				}
			}
			for(int yRange = currentYRangeMin; yRange <= currentYRangeMax; yRange++) { // Fixed time complexity O(2) => O(1)
				if(island.isYCoordinateExists(yRange)) {
					yCoordinateRange = true;
					break;
				}
			}
			
			if(xCoordinateInRange == true && yCoordinateRange == true) {
				island.addXCoordinate(x);
				island.addYCoordinate(y);
				return island;
			}
		}
		
		return null;
	}

}
