package com.maze;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

@AllArgsConstructor
public class Maze {

    private int[][] maze;

    public int calculateShortestPath(Point source, Point destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        visited[source.getRow()][source.getColumn()] = true;
        Queue<Step> steps = new LinkedList<>();
        Step startStep = new Step(source);
        steps.offer(startStep);

        // These arrays are used to get row and column numbers of 4 neighbours of a given cell
        int rowNum[] = {-1, 0, 0, 1};
        int colNum[] = {0, -1, 1, 0};

        while (!steps.isEmpty()) {
            Step currentStep = steps.poll();
            if (isDestinationReached(currentStep, destination)) {
                return currentStep.getDistance();
            }

            for (int i = 0; i < 4; i++) {
                int currentNeighbourRowNumber = currentStep.getRow() + rowNum[i];
                int currentNeighbourColumnNumber = currentStep.getColumn() + colNum[i];

                // If the neighbour is not a wall and is in the range of maze and not already visited
                // then enqueue the neighbour for visit
                if(isValidCell(currentNeighbourRowNumber, currentNeighbourColumnNumber) &&
                        !visited[currentNeighbourRowNumber][currentNeighbourColumnNumber]) {
                    visited[currentNeighbourRowNumber][currentNeighbourColumnNumber] = true;
                    Step step = new Step(currentNeighbourRowNumber, currentNeighbourColumnNumber, currentStep.getDistance() + 1);
                    steps.offer(step);
                }
            }

        }

        throw new RuntimeException("Destination cannot be reached");
    }

    private boolean isDestinationReached(Step currentStep, Point destination) {
        return (currentStep.getRow() == destination.getRow() &&
                currentStep.getColumn() == destination.getColumn());
    }

    private boolean isValidCell(int rowNumber, int columnNumber) {
        return rowNumber >= 0 && rowNumber < maze.length &&
                columnNumber >= 0 && columnNumber < maze[0].length &&
                maze[rowNumber][columnNumber] != 1;
    }
}
