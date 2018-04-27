package com.GC;

/**
 * @author qing.lan
 * @date 2018/4/27 16:28
 * @Description 测试垃圾回收器
 * vm:option -verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 本机测试Minor GC 使用的是PS GC ，如果按照书中要重新指定为-XX:+UseParallelGC
 *
 * SerialGC结果为
 * [GC (Allocation Failure) [DefNew: 7455K->611K(9216K), 0.0038351 secs] 7455K->6755K(19456K), 0.0038749 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * Heap
 * def new generation   total 9216K, used 7191K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 * eden space 8192K,  77% used [0x00000000fec00000, 0x00000000ff23b870, 0x00000000ff400000)
 * from space 1024K,  79% used [0x00000000ff500000, 0x00000000ff5ca690, 0x00000000ff600000)
 * to   space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
 * tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 * the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00020, 0x00000000ffa00200, 0x0000000100000000)
 *
 * PS GC结果为
 * [GC (Allocation Failure) [PSYoungGen: 6730K->904K(9216K)] 6730K->5000K(19456K), 0.0029210 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 * PSYoungGen      total 9216K, used 7286K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 * eden space 8192K, 77% used [0x00000000ff600000,0x00000000ffc3b870,0x00000000ffe00000)
 * from space 1024K, 88% used [0x00000000ffe00000,0x00000000ffee2020,0x00000000fff00000)
 * to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
 * ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 * object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000020,0x00000000ff600000)
 *  *** 这没有发送GC，alloc4直接进入老年代了，和书中描写不一致，将4M改成 3M就成功 GC了
 *  原因：-XX:PretenureSizeThreshold 这个参数只在Serial和ParNew中有作用， 其他回收器由允许情况决定
 */
public class TestGC {

    private static  int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        allocation4 = new byte[3*_1MB];
    }
}
