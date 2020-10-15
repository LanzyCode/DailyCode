package com.lanzycode.domain;

public class Cooker extends Thread{
    private final Desk desk;
    public Cooker(Desk desk) {
        this.desk=desk;
    }

    @Override
    public void run() {
        while(true){
            synchronized (desk.getLock()){
                if(desk.getCount()==0){
                    break;
                }else if(!desk.isFlag()){
                    System.out.println("正在制作");
                    desk.setFlag(true);
                    desk.getLock().notifyAll();
                }else {
                    try {
                        desk.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
