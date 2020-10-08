package com.lanzycode.demo;

@FunctionalInterface
public interface Eatable {
    void eat();
}

class DemoEat {
    public static void main(String[] args) {
        useEatable(new EatableImpl());
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("匿名内部了类实现");
            }
        });
        useEatable(() -> {
            System.out.println("LambDa实现");
        });
    }

    public static void useEatable(Eatable eatable) {
        eatable.eat();
    }
}

class EatableImpl implements Eatable {

    @Override
    public void eat() {
        System.out.println("实现类实现了eat方法");
    }
}
