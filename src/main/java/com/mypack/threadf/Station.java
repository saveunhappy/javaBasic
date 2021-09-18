package com.mypack.threadf;

public class Station implements Runnable {
    private int tickets = 100;

    public boolean saleTicket() {
        synchronized (new Object()){
            if (tickets < 1) return false;
            tickets--;
            String name = Thread.currentThread().getName();
            System.out.println(name + "卖了1张票，还剩" + tickets + "张");
            return tickets > 0;
        }

    }

    @Override
    public void run() {
        while (saleTicket());
    }
}
