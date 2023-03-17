package com.jiajia.rxjava;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Numen_fan on 2023/3/16
 * Desc:
 */
public class Solution {

    public static void main(String[] args) {
        hello("Ben", "George");
    }

    public static void hello(String... names) {
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("hello " + s + "!");
            }
        });
    }

}
