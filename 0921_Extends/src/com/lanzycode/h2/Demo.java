package com.lanzycode.h2;

public class Demo {
    public static void main(String[] args) {
        Car car=new BMW("宝马",9999);
        System.out.println(car.equals(car));
        car.run();
        System.out.println("品牌"+car.getBrand()+"价格"+car.getPrice()+"拥有");
        BMW bmw=(BMW)car;
        bmw.GPS();
    }
}
