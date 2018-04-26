package com.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author qing.lan
 * @date 2018/4/26 17:11
 * @Description 直接内存OOM
 * vm:option -Xmx20M -Xms20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];

        unsafeField.setAccessible(true);

        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {

            unsafe.allocateMemory(_1MB);

        }
    }

}
