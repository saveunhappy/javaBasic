package com.mypack.file.io;

import com.mypack.file.Files.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
//        Files.write("231234哈哈哈".getBytes(),new File("E:/a/b/1.txt"));
//        byte[] bytes = Files.read(new File("E:/a/b/1.txt"));
//        System.out.println(new String(bytes));
        Files.copy(new File("E:/a/b/1.txt"),new File("E:/ab/ab/30.txt"));
    }

    private static void testFileInput() throws IOException {
        File file = new File("E:/1.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int len = fis.read(bytes);
        String s = new String(bytes,0,len,"GBK");
        System.out.println(s+"_");
        fis.close();
    }

    static void testFos() throws Exception{
        FileOutputStream fos = new FileOutputStream("E:/1.txt",true);
        fos.write("MJ码哥".getBytes("GBK"));
        fos.close();
    }
}
