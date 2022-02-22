package com.jia.jia.dartcompare;

import com.jiajia.test.People;

public class Main {

    public static void main(String[] args) {
        Pupil pupil = new Pupil("王五", 21, 60);
        System.out.println(pupil.toString());

        Student student = new Student();
        System.out.println();

        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 1500; i++) {
//            sb.append("sb");
//        }
//        System.out.println(sb.toString());

        try {
            getException();
        } catch(Exception e) {
            System.out.println("来了");
        }

    }

    public static void getException() throws Exception {
        int a = 1 / 0;
        System.out.println("继续执行");
    }

}
