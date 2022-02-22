package com.jia.jia.dartcompare;

public class Student {

    public String name;
    public int age;
    public static String aa = "aa";

    public Student() {
        name = "张三";
        age = 20;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void  printName() {
        System.out.println("printNAme");
    }
}
