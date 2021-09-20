package com.mypack.threadf;

import java.util.concurrent.locks.ReentrantLock;

public class Station implements Runnable {
    /**
     * 可重入锁原理就是，你拿到一个锁之后，，锁的持有计数会加一，如果你调用了两次那就再加一变成二
     * 如果另一个线程这个时候到了，那么就会设置成1，注意，这两个不是共享的，还是自己的，这个不能共享
     * 否则万一第一个已经到2了，那另一个一直等着的变成了1不就覆盖了嘛，那第一个还怎么释放两次，不就
     * 报错了么，然后第一个释放之后，变成0了，第二个线程是一，就代表能获取锁，获取到之后，如果要是释放
     * 那么就变成了0，释放出来了
     */
    private int tickets = 100;
    private ReentrantLock lock = new ReentrantLock();
    public boolean saleTicket() {
        try{
            lock.lock();
            if (tickets < 1) return false;
            tickets--;
            String name = Thread.currentThread().getName();
            System.out.println(name + "卖了1张票，还剩" + tickets + "张");
            return tickets > 0;
        }finally {
            lock.unlock();
        }


    }

    @Override
    public void run() {
        while (saleTicket()) ;
    }
}
