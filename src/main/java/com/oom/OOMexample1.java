package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qing.lan
 * @date 2018/4/26 14:31
 * @Description -Xms20M -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class OOMexample1 {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list= new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
