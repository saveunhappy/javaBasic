package com.mypack.threadf;

public class Main {
    public static void main(String[] args) {
        ThreadState();
    }

    private static void ThreadState() {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getState());
        Thread thread = new Thread();
        System.out.println(thread.getState());
    }

    private static void runStart() {
        /**
         * 为什么不能直接调用run方法？因为start方法才是真正开启新的线程，run方法就相当于你定义了一个类
         * 调用了一个普通方法，
         *
         */
        Thread thread = new MusicThread();
        thread.run();
        thread.start();
        /*
        播放音乐Thread[main,5,main]Thread-0
        播放音乐Thread[Thread-0,5,main]Thread-0
         */
    }

    private static void test1() {
        Thread thread = new Thread(() -> System.out.println("新线程 - "+Thread.currentThread().getName()));
        thread.setName("线程666");
//        thread.setPriority(10);
        thread.start();
    }
}
