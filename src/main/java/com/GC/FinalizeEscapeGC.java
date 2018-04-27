package com.GC;

import java.util.concurrent.TimeUnit;

/**
 * @author qing.lan
 * @date 2018/4/26 22:26
 * @Description 测试通过重写finalize方法使得对象逃离GC
 * GC回收会进行两次标记，第一次可达性标记， 判断是否需要执行finalize()，如果finalize()没有被重写或者已经调用过一次了就默认“没必要执行了”，
 * 进行第二次标记。
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVA_HOOK = null;

    public void isAlive(){
        System.out.println("我还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("要执行finalize了,此时已经被标记过一次了");
        SAVA_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVA_HOOK = new FinalizeEscapeGC();

        SAVA_HOOK = null;
        System.gc();
        TimeUnit.SECONDS.sleep(5);
        if(SAVA_HOOK != null) {
            SAVA_HOOK.isAlive();
        } else{
            System.out.println("我要被GC第一次回收啦");
        }

        SAVA_HOOK = null;
        TimeUnit.SECONDS.sleep(5);
        if(SAVA_HOOK != null) {
            SAVA_HOOK.isAlive();
        } else{
            System.out.println("我要被GC第二次回收啦");
        }

    }
}
