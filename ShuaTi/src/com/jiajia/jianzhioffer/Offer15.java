package com.jiajia.jianzhioffer;

public class Offer15 {

    public static void main(String[] args) {
        Offer15 o = new Offer15();
        System.out.println(o.hammingWeight(11));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n & 1);
            n = n >>> 1;
        }
        return ans;
    }
}
