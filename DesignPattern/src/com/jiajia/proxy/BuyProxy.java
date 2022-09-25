package com.jiajia.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Numen_fan on 2022/9/25
 * Desc: 代理类
 */
public class BuyProxy implements InvocationHandler {

    final IBuy sub; // 持有需要被代理的类, 可以替换掉

    public BuyProxy(IBuy obj) {
        this.sub = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("先来到了代理类, method = " + method.getName());
        return method.invoke(sub, args);
    }
}
