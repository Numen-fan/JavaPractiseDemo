package com.jiajia.jingsai;

import com.jiajia.common.ListNode;

import java.util.*;

/**
 * Created by Numen_fan on 2022/7/3
 * Desc:
 */
public class Solution300 {

    public static void main(String[] args) {

        Solution300 solution300 = new Solution300();

        System.out.println(solution300.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));

        solution300.spiralMatrix(3, 5, ListNode.buildList(new int[] {3,0,2,6,8,1,7,9,4,2,5,5,0}));

        System.out.println(solution300.peopleAwareOfSecret( 684, 18 , 496));


    }


    /**
     * 6108. 解密消息
     * @param key
     * @param message
     * @return
     */
    public String decodeMessage(String key, String message) {

        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == ' ' || map.containsKey(key.charAt(i))) {
                continue;
            }
            map.put(key.charAt(i), map.size());
        }


        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch == ' ') {
                sb.append(" ");
            } else {
                sb.append((char) ('a' + map.get(ch)));
            }
        }
        return sb.toString();

    }

    /**
     * 6111. 螺旋矩阵 IV
     * @param m
     * @param n
     * @param head
     * @return
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }

        int i = 0;
        int j = 0; // 用来标识到了哪一步

        while (head != null) {
            // 向右边走, 边界条件是j < n && arr[i][j] == -1
            while (head != null && j < n && arr[i][j] == -1) {
                arr[i][j] = head.val;
                head = head.next;
                j++;
            }

            if (head == null) {
                break;
            }

            j--; // 走过了，需要退一步
            i++;

            // 向下走，边界条件是 i < m && arr[i][j] == -1
            while (head != null && i < m && arr[i][j] == -1) {
                arr[i][j]  = head.val;
                head = head.next;
                i++;
            }

            if (head == null) {
                break;
            }

            i--;
            j--;

            // 向左走，边界条件是 j >= 0 && arr[i][j] == -1;

            while (head != null && j >= 0 && arr[i][j] == -1) {
                arr[i][j]  = head.val;
                head = head.next;
                j--;
            }

            if (head == null) {
                break;
            }

            j++;
            i--;

            // 向上走
            while (head != null && i >= 0 && arr[i][j] == -1) {
                arr[i][j] = head.val;
                head = head.next;
                i--;
            }

            if (head == null) {
                break;
            }

            i++;
            j++;

        }


        return arr;

    }

    /**
     * 6109. 知道秘密的人数
     * @param delay
     * @param forget
     * @return
     */
    public int peopleAwareOfSecret(int k, int delay, int forget) {


        Map<Integer, Long> map = new HashMap<>(); // value表示这些人是从第key天知道秘密的

        long mod = (long) 1e9 + 7;

        map.put(1, 1L); // 第一天有一个人知道

        long ans = 1;

        for (int i = 2; i <= k; i++) {
            long m = 0, n = 0; // m 表示知道能分享秘密的人，n表示遗忘秘密的人
            for (Map.Entry<Integer, Long> entry : map.entrySet()) {
                if (i - entry.getKey() >= forget) {
                    n += entry.getValue() % mod;
                    entry.setValue(0L);
                } else if (i - entry.getKey() >= delay) {
                    m += entry.getValue() % mod;
                }
            }

            ans = (ans + m - n) % mod;

            if (m != 0) {
                map.put(i, m % mod);
            }
        }

        return (int) ans;

    }

}
