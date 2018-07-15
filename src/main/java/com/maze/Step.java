package com.maze;

import lombok.Data;

@Data
public class Step extends Point {

    private int distance;

    public Step(Point point) {
        this.row = point.getRow();
        this.column = point.getColumn();
    }

    public Step(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }

}
