package com.jiajia.daily;

/**
 * Created by Numen_fan on 2022/12/26
 * Desc: 1759. 统计同构子字符串的数目
 */
public class Solution20221226 {

    int ans = 0;

    int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        System.out.println(new Solution20221226().countHomogenous("zzzzz"));
    }


    public int countHomogenous(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        char lastChar = s.charAt(0);
        int lastIndex = 0;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != lastChar) {
                // 计算本段对结果的贡献
                int len = i - lastIndex;
                ans = (ans + getCnt(len)) % mod;
                // 下一段的起点
                lastChar = c;
                lastIndex = i;
            }
        }

        // 最后一段
        int len = s.length() - lastIndex;
        ans = (ans + getCnt(len)) % mod;

        return ans;
    }

    private int getCnt(int a) {
        int ans = 0;
        for (int i = 1; i <= a; i++) {
            ans = (ans + i) % mod;
        }
        return ans;
    }
}
