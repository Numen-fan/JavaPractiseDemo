package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Numen_fan on 2022/11/13
 * Desc:
 */
public class Solution319 {

    public static void main(String[] args) {
        Solution319 s = new Solution319();

        System.out.println(s.subarrayLCM(ArrayUtils.string2IntArray("[1]"), 1));

        System.out.println(s.maxPalindromes("fttfjofpnpfydwdwdnns", 2));
    }

    /**
     * 6233. 温度转换
     *
     * @param celsius
     * @return
     */
    public double[] convertTemperature(double celsius) {
        double[] ans = new double[2];
        ans[0] = celsius + 273.15;
        ans[1] = celsius * 1.80 + 32.00;
        return ans;
    }

    /**
     * 6234. 最小公倍数为 K 的子数组数目
     * 滑动数组
     */
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k || k % nums[i] != 0) {
                continue;
            }
            int temp = i;
            for (int j = i; j < nums.length; j++) {
                if (match(nums, i, j, k)) {
                    ans++;
                    if (nums[j] == k && i != j) {
                        // 出现了k，说明从i开始的每一个数都可以满足
                        ans += (j - i);
                        temp = j;
                    } else if (temp != i) {
                        // 说明k出现过
                        ans++;
                    }

                }
            }
            i = temp;
        }
        return ans;
    }

    private boolean match(int[] nums, int start, int end, int k) {
        int max = nums[start];
        for (int i = start; i <= end; i++) {
            if (k % nums[i] != 0) {
                return false;
            }
            max = get(max, nums[i]);
            if (max > k) {
                return false;
            }
        }
        return max == k;
    }

    private int get(int a, int b) {
        int c = a % b;
        int d = a * b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        return d / b;
    }

    /**
     * 6236. 不重叠回文子字符串的最大数目
     * @param s
     * @param k
     * @return
     */
    public int maxPalindromes(String s, int k) {
        int ans = 0;
        Set<String> list = new HashSet<>();
        for (int i = 0; i < s.length() - k; i++) {
            for (int j = i + k - 1; j < s.length(); j++) {
                if (isP(s, i, j)) {
                    list.add(s.substring(i, j + 1));
                }
            }
        }
        System.out.println(list);
        return list.size();
    }

    private boolean isP(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }


}
