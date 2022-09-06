package com.jiajia.daily;

import java.util.*;

/**
 * 828. 统计子串中的唯一字符
 */
public class Solution20220906 {

    // key是起点
    // value（map, key是终点，int[]是26个字符出现的次数）
    Map<Integer, Map<Integer, Integer[]>> map = new HashMap<>();

    // key是起点
    // value（map, key是终点，value是这个区间的唯一字符数量）
    Map<Integer, Map<Integer, Integer>> countMap = new HashMap<>();

    public static void main(String[] args) {
        Solution20220906 solution20220906 = new Solution20220906();
        long timeBefore = System.currentTimeMillis();
        System.out.println(solution20220906.uniqueLetterString2("ABC"));
        System.out.println(System.currentTimeMillis() - timeBefore);
    }

    public int uniqueLetterString(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                ans += countUniqueChars(s, i , j);
            }
        }

        return ans;
    }

    private int uniqueLetterString2(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                List<Integer> list = new ArrayList<>();
                list.add(-1);
                map.put(c, list);
            }
            map.get(c).add(i);
        }

        int ans = 0;

        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            list.add(s.length()); // ????  ABC自己手动模拟一遍
            for (int i = 1; i < list.size() - 1; i++) {
                ans += ((list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i)));
            }
        }
        return ans;

    }


    /**
     * 超时了啊，唉，菜鸡啊
     */
    private int countUniqueChars(String t, int start, int end) {

        int ans = 0;

        // 先从缓存中取
        // 1 先取start的map
        Map<Integer, Integer[]> endMap = map.getOrDefault(start, new HashMap<>());
        if (endMap.isEmpty()) {
            // 说明这个起点是第一次开始遍历
            Integer[] a = new Integer[26];
            char ch = t.charAt(start);
            ans++;
            a[ch - 'A'] = 1;

            Map<Integer, Integer[]> tempMap = new HashMap<>();
            tempMap.put(end, a);
            map.put(start, tempMap);

            // 计数map
            Map<Integer, Integer> ansMap = new HashMap<>();
            ansMap.put(end, ans);
            countMap.put(start, ansMap);
        } else {
            // 这个start已经有了前面区间，那么直接找end-1的子区间
            Integer[] chCounts = endMap.get(end - 1); // start -> end - 1的字符分析情况
            int lastCount = getCountFromArr(start, end - 1); // start -> end - 1的唯一字符长度

            Integer[] endCounts = Arrays.copyOf(chCounts, 26);  // 难道是它太费时间了？

            int index = t.charAt(end) - 'A';
            if (endCounts[index] == null) { // 说明这个字符是唯一字符
                ans = lastCount + 1;
                endCounts[index] = 1;
            } else {
                // 说明这个字符串不是唯一的，此时应该判断在前一个串中这个字符是否是唯一的
                if (endCounts[index] == 1) { // 说明在前一个串中是唯一的，那么在新串中就不是唯一的了
                    ans = lastCount - 1;
                } else {
                    ans = lastCount;
                }
                endCounts[index]++;
            }
            endMap.put(end, endCounts);
            countMap.get(start).put(end, ans);
        }
        return ans;
    }

    private int getCountFromArr(int start, int end) {
        Map<Integer, Integer> map = countMap.get(start);
        return map.get(end);
    }

}
