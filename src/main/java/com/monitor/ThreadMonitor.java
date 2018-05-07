package com.monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author qing.lan
 * @date 2018/4/29 22:22
 * @Description Jconsole观察线程
 */
public class ThreadMonitor {

    /**
     * @author qing.lan
     * @date 2018/4/29 22:25
     * @Description 线程死循环演示
     * @params
     */
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        },"testBusyThread");
        thread.start();
    }

    public static void createLockThread(final Object lock){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object o = new Object();
        createLockThread(o);
    }
}
