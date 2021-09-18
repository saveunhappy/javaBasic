package com.mypack.threadf;

public class MusicThread extends Thread{
    @Override
    public void run() {
        System.out.println("播放音乐" + Thread.currentThread() + getName());
    }
}
