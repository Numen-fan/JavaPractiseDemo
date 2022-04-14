package com.jiajia.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {

    public static void main(String[] args) {
        System.out.println(method1("ababcbacadefegdehijhklij"));
    }

    /**
     * 重点：
     * 1 单个字母只出现一个串中
     * 2 需要尽可能的多划分
     * 思想：
     * 从前向后遍历, 记录start，然后从后向前遍历找到end，满足start和end的字符相同
     * 这说明从start到end之间的串至少为一个划分单位。
     * 然后截取start到end之间的串，再次从后面向前面遍历，如果某个字符在这个串中，那么更新end下标
     * 最后得到start到end，为一个串。
     * 【能AC，但是时间复杂度有点高】
     */
    private static List<Integer> method1(String s) {
        List<Integer> ansList = new ArrayList<>();
        if(s.length() == 1) {
            ansList.add(1);
            return ansList;
        }

        int end = 0;
        int start =0;
        while(start < s.length()) {
            char startChar = s.charAt(start); // 子串开始的字符
            // 在startChar后面找到距离它最远的相同的字符
            for(int j = s.length() - 1; j >= start; j--) {
                if(s.charAt(j) == startChar) {
                    end = j;
                    break;
                }
            }
            // 找到end了。
            if (end == start) { // startChar只出现一次
                ansList.add(1);
                start++;
            } else {
                // 更新了之后需要check end的变化，如果end增加了，
                // 说明子串新增了字符，那么新增的字符同样需要上面的操作，
                // 确保满足一个字符只能出现在一个子串中
                int tempEnd = end;
                while(true){
                    // 更新end
                    String subStr = s.substring(start, tempEnd + 1); // 不包含end + 1
                    for (int k = s.length() - 1; k > tempEnd; k--) {
                        char curChar = s.charAt(k);
                        if (subStr.contains(String.valueOf(curChar))) {
                            tempEnd = k;
                            break;
                        }
                    }

                    if (end == tempEnd) {
                        break;
                    } else {
                        end = tempEnd;
                    }
                }

                ansList.add(end - start + 1); // 长度需要加1
                start = end + 1; // 开启下一次搜寻

            }
        }
        return ansList;
    }

    /**
     * 针对method1方法进行优化
     * 【并没有什么提升，因为lastIndexOf其实样式用遍历实现的，所以和上面方法啊没有本质区别】
     */
    public List<Integer> method2(String s) {
        List<Integer> ansList = new ArrayList<>();
        if(s.length() == 1) {
            ansList.add(1);
            return ansList;
        }

        int end = 0;
        int start =0;

        while(start < s.length()) {
            char startChar = s.charAt(start); // 子串开始的字符
            // 在startChar后面找到距离它最远的相同的字符

            String lastStr = s.substring(start, s.length()); // 不包括s.length()
            end = lastStr.lastIndexOf(String.valueOf(startChar)) + start; // 注意需要加上start

            // 找到end了。
            if (end == start) { // startChar只出现一次
                ansList.add(1);
                start++;
            } else {
                // 更新了之后需要check end的变化，如果end增加了，
                // 说明子串新增了字符，那么新增的字符同样需要上面的操作，
                // 确保满足一个字符只能出现在一个子串中
                int tempEnd = end;
                while(true){
                    // 更新end
                    String subStr = s.substring(start, tempEnd + 1); // 不包含end + 1
                    for (int k = s.length() - 1; k > tempEnd; k--) {
                        char curChar = s.charAt(k);
                        if (subStr.contains(String.valueOf(curChar))) {
                            tempEnd = k;
                            break;
                        }
                    }

                    if (end == tempEnd) {
                        break;
                    } else {
                        end = tempEnd;
                    }
                }

                ansList.add(end - start + 1); // 长度需要加1
                start = end + 1; // 开启下一次搜寻

            }
        }

        return ansList;
    }

    /**
     * 转变思想，利用一个长度为26的数组，记录a-z出现的最远位置
     * 然后二次遍历，针对位置i的字符，直接取i的最远位置, 并增加i，如果i == 最远位置，那么说明这是一个子串了
     */
    public List<Integer> method3(String s) {

        List<Integer> ansList = new ArrayList<>();

        int[] local = new int[26];
        for (int i = 0; i < s.length(); i++) {
            local[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            end = Math.max(local[s.charAt(i) - 'a'], end);
            if (i == end) {
                ansList.add(end - start + 1);
                start = end + 1;
            }
        }

        return ansList;
    }
}
