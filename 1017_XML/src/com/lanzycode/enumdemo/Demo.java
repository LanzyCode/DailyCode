package com.lanzycode.enumdemo;

public enum Demo {
    SPRING("春"){
        @Override
        public void show() {
            System.out.println("来了");
        }
    },
    SUMMER("夏"){
        @Override
        public void show() {
            System.out.println("来了");
        }
    },
    AUTUMN("秋"){
        @Override
        public void show() {
            System.out.println("来了");
        }
    },
    WINNER("冬"){
        @Override
        public void show() {
            System.out.println("来了");
        }
    };
    private String name;

//    Demo() {
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Demo(String name) {
        this.name = name;
    }
    public abstract void show();
}
class Test{
    public static void main(String[] args) {
        System.out.print(Demo.SPRING.getName());
        Demo.SPRING.show();
        System.out.println(Demo.SUMMER);
        System.out.println(Demo.AUTUMN);
        System.out.println(Demo.WINNER);
        System.out.println(Demo.SPRING.ordinal());
        System.out.println(Demo.SPRING.compareTo(Demo.AUTUMN));
        Demo spring = Enum.valueOf(Demo.class, "SPRING");
        System.out.println(spring);
        Demo[] values = Demo.values();
        for (Demo value : values) {
            System.out.println(value);
        }
    }
}