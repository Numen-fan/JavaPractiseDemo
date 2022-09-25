package com.jiajia.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Numen_fan on 2022/9/25
 * Desc:
 */
public class ProxyDemo {

    public static void main(String[] args) {

        IBuy sub = new Sub();

        IBuy proxy = (IBuy) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(),
                new Class[]{IBuy.class}, new BuyProxy(sub));

        proxy.buy();
        proxy.pay();

    }

}
