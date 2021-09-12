package com.mypack.file.Files;

import java.io.File;
import java.util.function.Consumer;

public class Files {

    public static void move(File src, File dest) {
        if (src == null || dest == null) return;
        if (!src.exists() || dest.exists()) return;
        //如果复制的
        mkparents(dest);
        src.renameTo(dest);
    }

    private static void mkparents(File dest) {
        File parent = dest.getParentFile();
        if(parent.exists())return;
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

    public static void main(String[] args) {
//        search(new File("E:\\datastructure"), file -> {
//            System.out.println(file);
//        });
        move(new File("E:\\copy\\ccc.txt"),new File("E:\\a\\b\\ccc.txt"));
    }
}
