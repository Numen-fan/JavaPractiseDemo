package com.jiajia.builder;

public class Test {

    public static void main(String[] args) {
        Computer computer = new Computer.Builder("APPLE","M1")
                .setHasKeyboard(true).setDisplay("视网膜").build();
        System.out.println(computer);

        String str = String.format("%.2f", 0.02300003 * 100f);
        System.out.println(str);

        System.out.println(Float.isNaN(4.5f));

    }

}
