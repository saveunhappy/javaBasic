package com.mypack.file.Files;

import java.io.*;
import java.util.function.Consumer;

public class Files {
    public static void delete(File file) {
        if (file == null || !file.exists()) return;
        //这个清除的是目录，如果到里面发现是文件，直接就return了，clean中也是一直在调用delete在删除文件
        //删除目录里面的文件成功之后，再删除自己，就是文件夹。
        clean(file);
        file.delete();
    }

    private static void clean(File dir) {
        if (dir == null || !dir.exists()) return;
        if (dir.isFile()) return;
        File[] files = dir.listFiles();
        assert files != null;
        for (File sf : files) {
            delete(sf);
        }
    }
    public static void move(String src, String dest) {
        move(new File(src),new File(dest));
    }

    public static void move(File src, File dest) {
        if (src == null || dest == null) return;
        if (!src.exists() || dest.exists()) return;
        //如果复制的
        mkparents(dest);
        src.renameTo(dest);
    }

    private static void mkparents(File dest) {
        File parent = dest.getParentFile();
        if (parent.exists()) return;
        parent.mkdirs();
    }

    public static void search(File dir, Consumer<File> operation) {
        if (dir == null || operation == null) return;
        if (!dir.exists() || dir.isFile()) return;
        File[] files = dir.listFiles();
        for (File file : files) {
            operation.accept(file);
            if (file.isFile()) continue;
            search(file, operation);
        }
    }

    public static void write(byte[] bytes, File file) {
        if (bytes == null || file == null) return;
        if (file.exists()) return;
        mkparents(file);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] read(File file){
        if(file == null || !file.exists())return null;
        if(file.isDirectory())return null;
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int)file.length()];
            fis.read(bytes);
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        search(new File("E:\\datastructure"), file -> {
//            System.out.println(file);
//        });
//        move(new File("E:\\copy\\ccc.txt"), new File("E:\\a\\b\\ccc.txt"));

    }
}
