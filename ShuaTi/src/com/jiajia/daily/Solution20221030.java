package com.jiajia.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Numen_fan on 2022/10/30
 * Desc: 784. 字母大小写全排列
 */
public class Solution20221030 {

    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        Solution20221030 s = new Solution20221030();
        s.letterCasePermutation("mQe");
        System.out.println(s.ans);
    }

    public List<String> letterCasePermutation(String s) {
        method(s, 0);
        return ans;
    }

    private void method(String s, int i) {

        // 一定是最后添加进取，这个条件一定要注意
        if (i >= s.length()) {
            ans.add(s);
            return;
        }

        method(s, i + 1);

        char a = s.charAt(i);
        if (Character.isLetter(a)) {
            // 进行转换
            String s1 = s.substring(0, i);
            if (a - 'a' >= 0 && a - 'a' < 26) {
                // 小写字母
                s1 += Character.toUpperCase(a);
            } else {
                s1 += Character.toLowerCase(a);
            }
            s1 += s.substring(i + 1);
            method(s1, i + 1);
        }
    }
}
