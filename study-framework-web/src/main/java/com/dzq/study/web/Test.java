package com.dzq.study.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {


    private final static int parts = 5; //把文件分成5份

    /**
     * @param args
     */
    public static void main(String[] args) {
        for(int i = 0; i < parts; i ++){
            ReadFile rf = new ReadFile(i,parts,"F:\\test\\Spring Boot 学习笔记完整教程.pdf");
            rf.start();
        }
        System.out.println("复制成功！");
    }

}

class ReadFile extends Thread{
    private int start = 0;
    private int parts = 0;
    private String file = "";

    public ReadFile(int start,int parts, String file){
        this.start = start;
        this.file = file;
        this.parts = parts;
    }

    public void run(){
        System.out.println("第" + start + "个线程正在运行！");
        try {
            RandomAccessFile raf = new RandomAccessFile(file , "rw");
            long len =  raf.length();
            raf.seek(len*start/parts); //跳到第start部分开始读
            byte[] buf = new byte[(int)(len/parts)]; //读取len/parts个字节
            raf.read(buf);
            raf.close();

            int index = file.lastIndexOf(".");
            String newFileName = file.substring(0,index) + "_bak" + file.substring(index);
            raf = new RandomAccessFile(newFileName, "rw");
            raf.seek(len*start/parts);
            raf.write(buf);
            raf.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
