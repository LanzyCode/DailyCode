package com.lanzycode.domain;

public class Desk {

//    public static boolean flag=false;
    private boolean flag;
//    public static int count=10;
    private int count;
//    public static final Object lock=new Object();
    private final Object lock=new Object();

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Desk{");
        sb.append("flag=").append(flag);
        sb.append(", count=").append(count);
        sb.append(", lock=").append(lock);
        sb.append('}');
        return sb.toString();
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getLock() {
        return lock;
    }

    public Desk() {
        this(false,10);
    }

    public Desk(boolean flag, int count) {
        this.flag = flag;
        this.count = count;
    }
}
