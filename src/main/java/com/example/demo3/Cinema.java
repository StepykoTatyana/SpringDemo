package com.example.demo3;

import java.util.ArrayList;

public class Cinema {
    private int total_rows;
    private int total_columns;
    private ArrayList<AvailableSeats> available_seats = new ArrayList<>();

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public ArrayList<AvailableSeats> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(ArrayList<AvailableSeats> available_seats) {
        this.available_seats = available_seats;
    }

    public Cinema() {
    }

    public Cinema(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        addAvailableSeats();

    }

    public void addAvailableSeats() {
        //AvailableSeats availableSeats = new AvailableSeats();
        for (int i = 1; i <= total_rows; i++) {
            for (int j = 1; j <= total_columns; j++) {
//                availableSeats.setRow(i);
//                availableSeats.setColumn(j);
                available_seats.add(new AvailableSeats(i, j));
            }
        }
    }
}
