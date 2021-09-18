package com.mypack.threadf;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public synchronized void hello(Person p){
        System.out.format("[%s] hello to [%s]%n",name,p.name);
        p.smile(this);
    }

    private synchronized void smile(Person p) {
        System.out.format("[%s] hello to [%s]%n",name,p.name);
    }
}
