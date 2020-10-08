package com.lanzycode.h2;

public class Car extends VehicleProperty implements Vehicle {
    @Override
    public void run() {
        System.out.println("汽车行驶需要C驾照");
    }

    public Car() {
    }

    public Car(String brand, double price) {
        super(brand, price);
    }
}
