package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qing.lan
 * @date 2018/4/26 16:35
 * @Description -XX:PermSize:10M -XX:MaxPermSize:10M,JDK1.6及以下会出现OOM,JDK1.7之后常量池移入堆内，不容易出现OOM
 */
public class ConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        System.out.printf("begin");
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
