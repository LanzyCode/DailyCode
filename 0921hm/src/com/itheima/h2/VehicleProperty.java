package com.itheima.h2;

public class VehicleProperty {
    private String brand;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public VehicleProperty() {
    }

    public VehicleProperty(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }
}
