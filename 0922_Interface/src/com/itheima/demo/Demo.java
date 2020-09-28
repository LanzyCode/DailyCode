package com.itheima.demo;

public class Demo {
    public static void main(String[] args) {
        useAnimal(new Cat());
    }


    public static void useAnimal(Animal animal) {
        animal.eat();
    }


}

abstract class Animal {
    public abstract void eat();
}

class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("fish");
    }
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("bone");
    }
}