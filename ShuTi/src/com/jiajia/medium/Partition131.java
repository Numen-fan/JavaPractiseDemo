package com.jiajia.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Numen_fan on 2022/4/3
 * Desc:
 */
public class Partition131 {

    List<List<String>> result = new ArrayList<>();
    List<String> subList = new ArrayList<>();

    public static void main(String[] args) {
        Partition131 p = new Partition131();
        p.partition("aab");
        System.out.println(p.result);
    }

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;
    }

    private void backTracking(String s, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(subList));
            return;
        }

        /**
         * 相当于第一遍遍历，就是切分为单独的字符（满足回文）
         * 然后再从后面回溯，去掉最后一个字符
         *
         * e.g."aab" 第一遍的结果为[a,a,b],
         */
        for (int i = start; i < s.length(); i++) {
            if(isPartition(s, start, i)) {
                subList.add(s.substring(start, i + 1));
            } else {
                continue;
            }
            // start = 2最后一位，下一步i + 1 = 3时添加到result中，退出来
            backTracking(s, i + 1);
            // 退出来后，移出b得到[a,a]，但是start = 2，已经到最后，此时继续退出递归函数回到上一层，i = 1处
            // 继续移出，a,得到[a], i 进入下一位 2
            subList.remove(subList.size() - 1);
        }
    }

    private  boolean isPartition(String str, int start, int end) {
        if(str.length() == 0 || start > end || end > str.length()) {
            return false;
        }
        for (int i = start, j = end; i < j; i++, j--) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
