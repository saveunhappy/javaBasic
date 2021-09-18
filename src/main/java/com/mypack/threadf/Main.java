package com.mypack.threadf;

public class Main {
    public static void main(String[] args) {
        Person jack = new Person("jack");
        Person rose = new Person("rose");
        new Thread(()-> jack.hello(rose)).start();
        new Thread(()-> rose.hello(jack)).start();
    }

    private static void deadLock() {
        new Thread(()->{
           synchronized ("1"){
               System.out.println("1 - 1");
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized ("2"){
                   System.out.println("1 - 2");
               }
           }
        }).start();
        new Thread(()->{
            synchronized ("2"){
                System.out.println("2 - 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized ("1"){
                    System.out.println("2 - 2");
                }
            }
        }).start();
    }

    private static void ThreadSafe() {
        Station station = new Station();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(station);
            thread.setName(""+i);
            thread.start();
        }
    }

    private static void Threadjoin() {
        /**
         * 有了join之后，可以理解为，可惜顺序执行了，就是得等前一个运行完才能去执行下面的
         * 如果指定了时间，那么就可以等指定的时间
         */
        Thread thread = new Thread(() -> {
            System.out.println(1);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(3);
    }

    private static void concurrencyRun() {
        /**
         * 不要想着顺序执行，1 2 3 了，执行了打印1，睡了，然后新的线程启动了
         * 睡了1秒，打印了3，然后1线程醒了，睡够3秒了，打印了2
         */
        Thread thread = new Thread(() -> {
            System.out.println(1);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(3);
        thread.interrupt();
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
