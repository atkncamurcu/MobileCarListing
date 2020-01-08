package com.example.newcarapp.Models;

public class Cars {
    private String brand_name;
    private String serial;      // Ex : Focus
    private String model;       // Ex : 1.6 TDCi Trend X
    private int year;           // Ex : 2018
    private String fuel;        // Ex : Diesel,LPG, Gasoline
    private int imageResource;


    public Cars(String brands, String serial, String model, int year, String fuel, int imageResource) {
        this.brand_name = brands;
        this.serial = serial;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.imageResource = imageResource;
    }

    public String getBrands() {
        return brand_name;
    }

    public void setBrands(String brands) {
        this.brand_name = brands;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
