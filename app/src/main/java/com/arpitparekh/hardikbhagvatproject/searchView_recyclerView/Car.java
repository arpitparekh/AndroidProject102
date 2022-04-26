package com.arpitparekh.hardikbhagvatproject.searchView_recyclerView;

public class Car {

    String name;
    String model_name;
    int average;
    int no_of_seat;

    public String getName() {
        return name;
    }

    public String getModel_name() {
        return model_name;
    }

    public int getAverage() {
        return average;
    }

    public int getNo_of_seat() {
        return no_of_seat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public void setNo_of_seat(int no_of_seat) {
        this.no_of_seat = no_of_seat;
    }

    public Car(String name, String model_name, int average, int no_of_seat) {
        this.name = name;
        this.model_name = model_name;
        this.average = average;
        this.no_of_seat = no_of_seat;
    }
}
