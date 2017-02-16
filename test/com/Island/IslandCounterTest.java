package com.Island;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IslandCounterTest {
	
	private IslandCounter islandCounter;
	
	@Before
	public void init() {
		islandCounter = new IslandCounter();
	}

	@Test
	public void testCount1() {
		/*
		 * 0,1,0,0,0,0
		 * 0,1,0,1,1,1
		 * 0,0,0,0,1,1
		 * 1,0,0,0,0,0
		 * 0,0,0,0,1,0
		 * 0,0,0,0,1,0
		 */
		int[][] world = {{0,1,0,0,0,0}, {0,1,0,1,1,1}, {0,0,0,0,1,1}, {1,0,0,0,0,0},{0,0,0,0,1,0},{0,0,0,0,1,0}};
		int result = islandCounter.count(world);
		
		assertEquals(4, result, 0);
	}

	@Test
	public void testCount2() {
		/*
		 * 0,1,0,0
		 * 0,0,1,0
		 */
		int[][] world = {{0,1,0,0}, {0,0,1,0}};
		int result = islandCounter.count(world);
		
		assertEquals(1, result, 0);
	}

	@Test
	public void testCount3() {
		/*
		 * 0,1,0,0
		 * 0,0,0,0
		 * 0,0,1,0
		 */
		int[][] world = {{0,1,0,0}, {0,0,0,0}, {0,0,1,0}};
		int result = islandCounter.count(world);
		
		assertEquals(2, result, 0);
	}

	@Test
	public void testAllWaterWorldCount() {
		/*
		 * 0,0,0,0
		 * 0,0,0,0
		 * 0,0,0,0
		 */
		int[][] world = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		int result = islandCounter.count(world);
		
		assertEquals(0, result, 0);
	}

	@Test
	public void testAllLandWorldCount() {
		/*
		 * 1,1,1,1
		 * 1,1,1,1
		 * 1,1,1,1
		 */
		int[][] world = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
		int result = islandCounter.count(world);
		
		assertEquals(1, result, 0);
	}

	@Test
	public void testEmptyWorldCount() {
		int[][] world = {};
		int result = islandCounter.count(world);
		
		assertEquals(0, result, 0);
	}

	@Test
	public void testNullWorldCount() {
		int result = islandCounter.count(null);
		
		assertEquals(0, result, 0);
	}

}
