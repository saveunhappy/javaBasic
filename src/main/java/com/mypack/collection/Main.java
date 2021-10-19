package com.mypack.collection;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var hashSet = new HashSet<Integer>();
        hashSet.add(81);
        hashSet.add(7);
        hashSet.add(2);
        hashSet.add(3);
        System.out.println(hashSet.stream().
                map(x->x.toString()).collect(Collectors.joining(",")));

        Integer a = 3;
        var treeSet = new TreeSet<Integer>(){
            {
                add(a);
                add(7);
                add(2);
                add(81);
            }
        };
        Integer lower = treeSet.lower(a);
        Integer higher = treeSet.higher(a);
        System.out.println("lower:" + lower);
        System.out.println("higher:" + higher);
        System.out.println(treeSet.stream().
                map(x->x.toString()).collect(Collectors.joining(",")));
    }
}
