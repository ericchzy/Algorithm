package com.deecheng.helloworld;

import java.io.*;

public class Ex0410_DirectoryList {
    public void list(File file) {
        list(file, 0);
    }


    /**
     * List all file in this directory.
     * @param file file object.
     * @param depth current depth from the root.
     */
    public void list(File file, int depth) {
        printName(file, depth);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File subFile : files) {
                list(subFile, depth + 1);
            }
        }
    }

    public void printName(File file, int depth) {

        //hint
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }

        //Directory total size

        if (file.isDirectory()) {
            System.out.println("Dir: " + file.getName());
        } else {
            System.out.println("File: " + file.getName() + " Size: " + file.length());
        }
    }

    public static void main(String[] args) {
        Ex0410_DirectoryList directoryList = new Ex0410_DirectoryList();
        File file = new File("D:\\PythonML\\Test\\venv");
        directoryList.list(file);
    }
}
