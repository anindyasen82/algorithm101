package com.Island;

import java.util.ArrayList;
import java.util.List;

public class IslandCounter {
	
	private List<Island> islands = new ArrayList<Island>();
	
	public int count(int[][] world) {
		if(world == null || world.length == 0) {
			return 0;
		}
		
		for (int x = 0; x < world.length; x++) {
			int[] currentRow = world[x];
			for (int y = 0; y < currentRow.length; y++) {
				if(currentRow[y] == 1) { // found land
					Island adjecentIsland = findAdjecentIsland(x, y);
					if(adjecentIsland == null) {
						adjecentIsland = new Island();
						adjecentIsland.addXCoordinate(x);
						adjecentIsland.addYCoordinate(y);
						islands.add(adjecentIsland);
					}
				}
			}
		}
		
		return islands.size();
	}

	private Island findAdjecentIsland(int x, int y) {
		for(Island island : islands) {
			boolean xCoordinateInRange = false;
			boolean yCoordinateRange = false;
			
			int currentXRangeMin = x - 1;
			int currentXRangeMax = x + 1;
			
			int currentYRangeMin = y - 1;
			int currentYRangeMax = y + 1;
			
			for(int xRange = currentXRangeMin; xRange <= currentXRangeMax; xRange++) { // Fixed time complexity O(3) => O(1)
				if(island.isXCoordinateExists(xRange)) {
					xCoordinateInRange = true;
					break;
				}
			}
			for(int yRange = currentYRangeMin; yRange <= currentYRangeMax; yRange++) { // Fixed time complexity O(3) => O(1)
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
