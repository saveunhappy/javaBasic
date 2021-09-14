package com.mypack.file.io;

import com.mypack.file.Files.Files;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        Files.write("231234哈哈哈".getBytes(),new File("E:/a/b/1.txt"));
//        byte[] bytes = Files.read(new File("E:/a/b/1.txt"));
//        System.out.println(new String(bytes));
//        Files.copy(new File("E:/a/b/1.txt"),new File("E:/ab/ab/30.txt"));
//        BufferedWriter writer = new BufferedWriter(new FileWriter("E:/1.txt"));
//        writer.write("123");
//        writer.flush();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("E:/gbk.txt"), "GBK"));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream("E:/utf-8.txt"), "UTF-8"));
        ) {
            char[] chars = new char[8192];
            int len;
            while ((len = reader.read(chars)) != -1){
                writer.write(chars,0,len);
            }

//            String line;
//            while ((line = reader.readLine())!=null){
//                writer.write(line);
//                writer.newLine();
//            }
        }
    }

    private static void BuferReaderTest() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("E:/a/b/s.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void FileReaderTest() throws IOException, InterruptedException {
        try (FileReader reader = new FileReader(new File("E:/a/b/s.txt"))) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
                Thread.sleep(10);
            }
        }
    }

    private static void testFileInput() throws IOException {
        File file = new File("E:/1.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int len = fis.read(bytes);
        String s = new String(bytes, 0, len, "GBK");
        System.out.println(s + "_");
        fis.close();
    }

    static void testFos() throws Exception {
        FileOutputStream fos = new FileOutputStream("E:/1.txt", true);
        fos.write("MJ码哥".getBytes("GBK"));
        fos.close();
    }
}
