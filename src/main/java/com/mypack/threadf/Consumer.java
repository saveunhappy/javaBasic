package com.mypack.threadf;

public class Consumer implements Runnable{
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String food = null;
        while ((food = drop.get())!=null){
            System.out.format("消费者接受到生产者生产的食物:%s%n",food);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //ignore
            }
        }
    }
}
