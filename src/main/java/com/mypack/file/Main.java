package com.mypack.file;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //File代表了一个文件或者目录(文件夹)
        File file = new File("E:\\copy\\ccc.txt");
        System.out.println(file.getName());//获取文件或者目录的名称
        System.out.println(file.getParent());//获取父路径
        System.out.println(file.getParentFile());//获取父文件
        System.out.println(file.getPath());//获取路径
        System.out.println(file.getAbsolutePath());//获取绝对领
        System.out.println(file.lastModified());//获取最后一次的修改时间
        System.out.println(file.length());//获取文件的大小(不支持目录，因为到时候算的还是文件的大小，文件夹是没有大小的)

    }
}
