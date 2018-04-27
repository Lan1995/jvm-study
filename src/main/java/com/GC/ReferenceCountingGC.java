package com.GC;

/**
 * @author qing.lan
 * @date 2018/4/26 22:02
 * @Description  testGC
 * VM:options -XX:+PrintGCDetails 打印GC日志
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024*1024;

    //占用内存，方便观察GC日志是否被回收
    private byte[] bigSize = new byte[2*_1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
