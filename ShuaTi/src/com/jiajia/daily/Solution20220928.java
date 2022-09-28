package com.jiajia.daily;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 试题 17.09. 第 k 个数
 */
public class Solution20220928 {

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(643));
    }

    public static int getKthMagicNumber(int k) {

        int[] factors = {3, 5, 7};
        Set<Long> set = new HashSet<>();

        PriorityQueue<Long> heap = new PriorityQueue<>(); // 小根堆， 第一个元素是最小的

        set.add(1L);
        heap.offer(1L);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            // 从heap中取k此
            long cur = heap.poll();
            ans = (int) cur;
            for (int factor : factors) {
                long next = factor * cur;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ans;
    }
}
