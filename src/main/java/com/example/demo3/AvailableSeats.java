package com.example.demo3;

public class AvailableSeats {
    private int row;
    private int column;
    public int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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
        if (row <= 4) {
            this.price = 10;
            setPrice(10);
        } else {
            this.price = 8;
            setPrice(8);
        }

    }

    public AvailableSeats() {
    }

}
