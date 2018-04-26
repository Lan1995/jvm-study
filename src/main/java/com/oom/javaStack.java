package com.oom;

/**
 * @author qing.lan
 * @date 2018/4/26 15:54
 * @Description 虚拟机栈在单线程情况下不易出现OOM，容易出现由于递归调用导致的StackOverflowError。多线程情况下由于虚拟栈申请内存会导致OOM
 * VM option: -Xss 128K
 */
public class javaStack {

    static  class stackLeak{
        public void stackLoop(){
            stackLoop();
        }
    }

    public static void main(String[] args) {
        new stackLeak().stackLoop();
    }
}
