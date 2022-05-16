package com.jiajia.jingsai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Numen_fan on 2022/5/15
 * Desc:
 */
public class Solution293 {

    public static void main(String[] args) {

        Solution293 solution293 = new Solution293();

        String[] words = {"abba","baba","bbaa","cd","cd"};

        System.out.println(solution293.removeAnagrams(words));

        System.out.println(solution293.maxConsecutive(6, 8, new int[]{7, 6, 8}));


        System.out.println(solution293.largestCombination2(new int[]{84,40,66,44,91,90,1,14,73,51,47,35,18,46,18,65,55,18,16,45,43,58,90,92,91,43,44,76,85,72,24,89,60,94,81,90,86,79,84,41,41,28,44}));


    }


    /**
     * 5234. 移除字母异位词后的结果数组
     * @param words
     * @return
     */
    public List<String> removeAnagrams(String[] words) {
//
//        List<String> result = new ArrayList<>();
//
//        String preStr = words[0];
//        result.add(preStr);
//
//        for (int i = 1; i < words.length; i++) {
//            if (isSameWord(words[i], preStr)) {
//                continue;
//            }
//            result.add(words[i]);
//            preStr = words[i];
//        }
//        return result;


        ArrayList<String> list = new ArrayList<>(List.of(words[0]));
        for (int i = 1; i < words.length; i++) {
            if (!Arrays.equals(words[i].chars().sorted().toArray(), words[i - 1].chars().sorted().toArray())) {
                list.add(words[i]);
            }
        }
        return list;
    }

    private boolean isSameWord(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return  false;
        }

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);

        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s2Arr);

        String str1 = String.valueOf(s1Arr);
        String str2 = String.valueOf(s2Arr);

        return str1.equals(str2);
    }


    /**
     * 6064. 不含特殊楼层的最 大连续楼层数
     * 暴力求解
     */
    public int maxConsecutive(int bottom, int top, int[] special) {
        int answer = 0;
        Arrays.sort(special); // 数组是无序的

        int preFloor = bottom; // 前一个办公楼层

        for (int i = 0; i < special.length; i++) {
            int temp = special[i] - preFloor;
            if (temp == 0) { // 说明i处的楼层是特殊楼层，那么办公的楼层应该从下一层开始
                preFloor++;
                continue;
            }
            answer = Math.max(answer, temp);
            preFloor = special[i] + 1;
        }

        if (top != special[special.length - 1]) {
            answer = Math.max(answer, top - preFloor + 1); // 容易忽略
        }

        return answer;
    }

    /**
     * 6065. 按位与结果大于零的最长组合
     * 注意特点，如果与运算的结果出现0，那么后面都都是0，这点很关键，所以，出现res为0或者遍历到最后时，记录此条路径的最大值
     * 递归回溯，一定是遍历结束，找到
     * @param candidates
     * @return
     */

    private int maxCnt = 0;

    public int largestCombination(int[] candidates) {


        method1(candidates, new ArrayList<>(), 0, candidates[0]);

        return maxCnt;

    }

    private void method1(int[] candidates, List<Integer> ans, int startIndex, int res) {

        if (res == 0 || startIndex == candidates.length) {
            // 判断当前的路径的长度
            maxCnt = Math.max(maxCnt, ans.size() - (res == 0 ? 1 : 0));
            return;
        }

        // 处理本层的逻辑
        for (int i = startIndex; i < candidates.length; i++) {

            ans.add(candidates[i]);

            method1(candidates, ans, i + 1, res & candidates[i]);

            // 回溯
            ans.remove(ans.size() - 1);

        }

    }

    /**
     * 其本质是找到多少个数，他们有共有的二进制位
     * 计算每个二进制位上的1
     */
    public int largestCombination2(int[] candidates) {

        int ans = 0;

        for (int i = 0; i < 30; i++) {
            int cnt = 0;
            for (int num : candidates) {
                if ((num & (1 << i)) > 0) {
                    cnt++;
                }
            }
            ans = Math.max(cnt, ans);
        }

        return ans;




    }




}
