package com.maze;

import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest {

    @Test
    public void calculateShortestPath1() {
        /*
		 * 0,1,0,0,0,0
		 * 0,1,0,1,1,1
		 * 0,0,0,0,1,1
		 * 1,0,0,0,0,0
		 * 0,0,0,0,1,0
		 * 0,0,0,0,1,0
		 */
        int[][] input = {{0,1,0,0,0,0}, {0,1,0,1,1,1}, {0,0,0,0,1,1}, {1,0,0,0,0,0},{0,0,0,0,1,0},{0,0,0,0,1,0}};
        Maze maze = new Maze(input);
        Point source = new Point(0,0);
        Point destination = new Point(0,2);
        int distance = maze.calculateShortestPath(source, destination);

        assertEquals(6, distance, 0);
    }

    @Test
    public void calculateShortestPath2() {
        /*
		 * 0,1,0,0
		 * 0,0,1,0
		 */
        int[][] input = {{0,1,0,0}, {0,0,1,0}};
        Maze maze = new Maze(input);
        Point source = new Point(0,2);
        Point destination = new Point(1,3);
        int distance = maze.calculateShortestPath(source, destination);

        assertEquals(2, distance, 0);
    }

    @Test
    public void calculateShortestPath3() {
        /*
		 * 0,1,0,0
		 * 0,0,0,0
		 * 0,0,1,0
		 */
        int[][] input = {{0,1,0,0}, {0,0,0,0}, {0,0,1,0}};
        Maze maze = new Maze(input);
        Point source = new Point(2,3);
        Point destination = new Point(0,0);
        int distance = maze.calculateShortestPath(source, destination);

        assertEquals(5, distance, 0);
    }

    @Test(expected = RuntimeException.class)
    public void calculateShortestPath4() {
        /*
		 * 0,1,0,0
		 * 0,0,1,0
		 */
        int[][] input = {{0,1,0,0}, {0,0,1,0}};
        Maze maze = new Maze(input);
        Point source = new Point(0,0);
        Point destination = new Point(1,3);
        maze.calculateShortestPath(source, destination);
    }

}