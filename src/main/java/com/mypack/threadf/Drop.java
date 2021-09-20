package com.mypack.threadf;

public class Drop {
    private String food;
    private boolean empty = true;

    public synchronized String get(){
        while (empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        return food;
    }
    public synchronized void add(String food){
        while (!empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.food = food;
        notifyAll();
    }
}
