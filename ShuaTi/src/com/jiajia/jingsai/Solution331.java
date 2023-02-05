package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.*;

/**
 * Created by Numen_fan on 2023/2/5
 * Desc:
 */
public class Solution331 {

    public static void main(String[] args) {
        Solution331 s = new Solution331();
        System.out.println(s.pickGifts(ArrayUtils.string2IntArray("[1,1,1,1]"), 4));
        ArrayUtils.print(s.vowelStrings(new String[]{"aba","bcb","ece","aa","e"}, ArrayUtils.string2IntArray2("[[0,2],[1,4],[1,1]]")));
    }

    /**
     * 6348. 从数量最多的堆取走礼物
     * @param gifts
     * @param k
     * @return
     */
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            queue.add(gift);
        }

        for (int i = 0; i < k; i++) {
            if (queue.peek() == 1) {
                break;
            }
            int gift = queue.poll();
            queue.add((int) Math.floor(Math.sqrt(gift)));
        }

        long ans = 0;

        for (int a : queue) {
            ans += a;
        }
        return ans;
    }

    /**
     * 6347. 统计范围内的元音字符串数
     * @param words
     * @param queries
     * @return
     * 直接暴力会卡在最后一个用例
     * 【正解】使用前缀和
     */
    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;

        int[] flags = new int[n]; // word[i]满足元音起始记为1，否着记0

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (matchChar(word.charAt(0)) && matchChar(word.charAt(word.length() - 1))) {
               flags[i] = 1;
            }
        }

        int[] pre = new int[n + 1]; // 前缀和， 注意这里多一个元素
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + flags[i - 1];
        }
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ans[i] = pre[query[1] + 1] - pre[query[0]];
        }

        return ans;
    }

    private boolean matchChar(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    /**
     * 6346. 打家劫舍 IV
     * @param nums
     * @param k
     * @return
     */
    public int minCapability(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (check(nums, k, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean check(int[] nums, int k, int mid) {
        int cnt = 0;
        // 从左到右枚举每座房子，能抢就抢
        // j 是上一次抢夺的下标
        for (int i = 0, j = -2; i < nums.length; i++) {
            if (nums[i] <= mid && i - j > 1) {
                cnt++;
                j = i;
            }
        }

        return cnt >= k;
    }
}
