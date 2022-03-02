package com.example.demo3;

public class AvailableSeats {
    private int row;
    private int column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public AvailableSeats(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
