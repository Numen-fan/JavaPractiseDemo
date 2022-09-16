package com.jiajia.test;

import java.util.ArrayList;
import java.util.List;

public class Demo1  {

    private  port1 po1;
    private  port2 po2;

    public static void main(String[] args) {

        List<People> list1 = new ArrayList<>();
        list1.add(new People("11", 1));
        list1.add(new People("22", 22));

        System.out.println(Demo1.class.getSimpleName());

        List<People> list2 = new ArrayList<>(list1);

        System.out.println(list1.get(0));
        System.out.println(list2.get(0));

        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());

//        System.out.println(1 / 0);

        int aa = new CrashHandler().a;

        String str = "asdas" + "sdfsdfs" + 2;

        String ss = "23";
        switch (ss) {
            case "23":
                System.out.println("23");
                break;
            case "32":
                System.out.println("32");
                break;
            case "33":
            case "44":
                System.out.println("3344");
                break;
            case "34":
                System.out.println("34");
            case "45":
                System.out.println("45");
                break;
            default:
                break;
        }

        Demo1 demo1 = new Demo1();
        demo1.print();

    }

    public void print() {
        Point point = new Point();
        po1 = point;
        po2 = point;

        po1.print();
        po2.print();

    }

    public void  aaaa() {
        int aba = new CrashHandler().a;
    }


    private static class CrashHandler implements Thread.UncaughtExceptionHandler {

        private int a;
        public int b;
        private static int c;
        public static int d;

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Application crashed, msg = " + e.getMessage());
        }
    }

}

class Point implements port1, port2 {

    @Override
    public void print() {
        System.out.println("print");
    }
}

interface port1 {
    default void print() {
        System.out.println("print1");
    }
}

interface port2 {
    default void print() {
        System.out.println("print2");
    }
}
