package com.jia.jia.dartcompare;

public class Pupil extends Student {

    public int score;

    public Pupil(int score) {
        this.score = score;
    }

    public Pupil(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "scope=" + score +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
