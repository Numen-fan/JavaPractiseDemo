package com.jiajia.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Numen_fan on 2022/4/7
 * Desc:
 */
public class RestoreIpAddresses93 {



    public static void main(String[] args) {
        RestoreIpAddresses93 restoreIpAddresses93 = new RestoreIpAddresses93();
        restoreIpAddresses93.restoreIpAddresses("25525511135");
        System.out.println(restoreIpAddresses93.result);
    }

    public List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, 0);
        return result;
    }

    /**
     * @param s 当前分割后的ip串
     * @param startIndex 当前分割的起点
     * @param pointNum 当前已经分割次数，插入多少个点
     */
    public void backTracking(String s, int startIndex, int pointNum) {

        // 递归退出条件
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s); // 说明当前的s符合IP地址格式
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) { // 横向遍历, 分割[startIndex, i]
            if (isValid(s, startIndex, i)) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i + 1, "."); // 在i之后插入"."
                // 由于插入了一个『.』,下一次分割的起点在i + 2
                backTracking(sb.toString(), i + 2, pointNum + 1);
                // 回溯处理, 移出上面添加的『.』
            } else { // 本次已经不合法了，直接break
                break;
            }
        }
    }

    /**
     * 判断 s 中[start, end]区间的字符串是否符合一段IP地址
     * 不能以0开头，满足 [0-255]
     */
    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }

        if (start != end && s.charAt(start) == '0') { // 不能以0开头
            return false;
        }

        if (end - start >= 3) { // 超过3位，注意end是右闭合区间
            return false;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false; // 包含非数字
            }

            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 已经大于255
                return false;
            }
        }

        return true;
    }

}
