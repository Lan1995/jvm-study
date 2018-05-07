package com.monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author qing.lan
 * @date 2018/4/29 21:59
 * @Description 使用Jconsole来监控内存变化
 * vm:option -Xmx100M -Xms100M -XX:+UseSerialGC
 */
public class MemoryMonitor {

    /**
     * @author qing.lan
     * @date 2018/4/29 22:06
     * @Description  一个OOMObject占据大约64kb     */
    static class OOMbject{
        public byte[] placeholder = new byte[64*1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMbject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            TimeUnit.MILLISECONDS.sleep(50);
            list.add(new OOMbject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception{
        fillHeap(1000);
    }
}
