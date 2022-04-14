package com.jiajia.test;

import java.util.ArrayList;
import java.util.List;

public class People {
    private String name;
    private int age;
    private final List<String> favorite = new ArrayList<>();

    private static int a;
    public static int b;


//    public People() {
//
//    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;

        favorite.add("English");
        favorite.add("math");
        favorite.add("chinese");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favorite=" + favorite +
                '}';
    }
}
