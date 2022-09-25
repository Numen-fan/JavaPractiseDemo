package com.jiajia.test;

/**
 * Created by Numen_fan on 2022/9/20
 * Desc:
 */
public class Student extends Person {

    interf inte;

    public Student() {
        inte = () -> "你好";
    }

    @Override
    String getName(interf name) {
        return "你好, " + name.get();
    }
}

abstract class Person {

    abstract String getName(interf name);

}

interface interf {

    String get();

}
