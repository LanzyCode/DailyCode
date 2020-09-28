package com.itheima.h2;

public class Moto extends VehicleProperty implements Vehicle {
    @Override
    public void run() {
        System.out.println("摩托车行驶需要D驾照");
    }
}
