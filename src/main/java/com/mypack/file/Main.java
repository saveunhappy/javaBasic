package com.mypack.file;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //File代表了一个文件或者目录(文件夹)
        File file = new File("E:\\datastructure");
        String[] files = file.list((dir, name) -> name.startsWith("0"));
        System.out.println(Arrays.toString(files));
    }
}
