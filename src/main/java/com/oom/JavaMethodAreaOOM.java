package com.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author qing.lan
 * @date 2018/4/26 16:40
 * @Description 方法区OOM，主要是class过多导致， JSP，Servlet也会产生class, 通过CGLIB产生大量的class
 * VM:Option -XX:PermSize=10 -XX:MaxPermSize=10
 */
public class JavaMethodAreaOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o,objects);
                }
            });
            enhancer.create();
        }
    }
}
