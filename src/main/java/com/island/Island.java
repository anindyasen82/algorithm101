package com.island;

import java.util.HashSet;
import java.util.Set;

public class Island {

	private Set<Integer> xCoordinates = new HashSet<Integer>();
	private Set<Integer> yCoordinates = new HashSet<Integer>();
	
	public void addXCoordinate(int xCoordinate) {
		xCoordinates.add(xCoordinate);		
	}
	
	public void addYCoordinate(int yCoordinate) {
		yCoordinates.add(yCoordinate);		
	}
	
	public boolean isXCoordinateExists(int xCoordinate) {
		return xCoordinates.contains(xCoordinate);
	}
	
	public boolean isYCoordinateExists(int yCoordinate) {
		return yCoordinates.contains(yCoordinate);
	}

}
