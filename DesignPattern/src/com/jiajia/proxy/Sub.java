package com.jiajia.proxy;

/**
 * Created by Numen_fan on 2022/9/25
 * Desc: 需要被代理的对象
 */
public class Sub implements IBuy {

    @Override
    public void buy() {
        System.out.println("我自己买");
    }

    @Override
    public void pay() {
        System.out.println("我自己付钱");
    }
}
