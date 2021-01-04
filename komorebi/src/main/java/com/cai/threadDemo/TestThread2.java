package com.cai.threadDemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author: Cai
 * @date: 2020/12/9 14:37
 * @description:
 */
public class TestThread2 extends Thread {
    private String url;
    private String name;


    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载文件名为:" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://img-blog.csdnimg.cn/20201209124058286.png", "1.jpg");
        TestThread2 t2 = new TestThread2("https://img-blog.csdnimg.cn/20201209124058286.png", "2.jpg");
        TestThread2 t3 = new TestThread2("https://img-blog.csdnimg.cn/20201209124058286.png", "3.jpg");

        t1.start();
        t2.start();
        t3.start();


    }
}

//下载器
class WebDownloader {

    //下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("downloader异常");
        }
    }
}
