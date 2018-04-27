package com.GC;

/**
 * @author qing.lan
 * @date 2018/4/27 17:13
 * @Description 测试设置一次GC后就进入老年代
 *
 * TODO:赋值为null是表明可回收，可达性算法
 */
public class testTenuringThreshold {

    private static int _1MB = 1024*1024;
    /**
     * @author qing.lan
     * @date 2018/4/27 18:20
     * @Description 测试动态年龄判断
     * vm:option: -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1/15
     */
    /*public static void main(String[] args) {
        byte[] allo1,allo2,allo3;
        allo1 = new byte[_1MB/4];

        allo2 = new byte[_1MB*4];
        allo3 = new byte[_1MB*4];
        allo3 = null;
        allo3 = new byte[_1MB*4];
    }*/

    /**
     * @author qing.lan
     * @date 2018/4/27 18:20
     * @Description 测试动态年龄判断
     * vm:option: -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
     */
    /*public static void main(String[] args) {

        byte[] allo1,allo2,allo3,allo4;
        allo1 = new byte[_1MB/4];
        allo2 = new byte[_1MB/4];
        allo3 = new byte[_1MB*4];
        allo4 = new byte[_1MB*4];
        allo4 = null;
        allo4 = new byte[_1MB*4];
    }*/


    /**
     * @author qing.lan
     * @date 2018/4/27 18:20
     * @Description 测试空间担保分配
     * vm:option: -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HandlePromotionFailure
     */
    public static void main(String[] args) {
        byte[] allo1,allo2,allo3,allo4,allo5,allo6,allo7;
        allo1 = new byte[_1MB*2];
        allo2 = new byte[_1MB*4];
        allo3 = new byte[_1MB*2];
        allo1 = null;

        allo4 = new byte[_1MB*2];
        allo5 = new byte[_1MB*2];
        allo6 = new byte[_1MB*2];

        allo4 = null;
        allo5 = null;
        allo6 = null;

        allo7 = new byte[_1MB*2];

    }
}
