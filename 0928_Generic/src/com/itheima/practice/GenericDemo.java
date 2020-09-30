package com.itheima.practice;

public class GenericDemo {
    public static void main(String[] args) {
        Box<String> box = new Box<>("哈哈");
        System.out.println(box);
    }
}

class Box<E> {
    private E e;

    public Box(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Box{");
        sb.append("e=").append(e);
        sb.append('}');
        return sb.toString();
    }
}