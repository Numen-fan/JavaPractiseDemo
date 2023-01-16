package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class Solution328 {

    public static void main(String[] args) {

        Solution328 s = new Solution328();
        System.out.println(s.countGood(ArrayUtils.string2IntArray("[2,3,1,3,2,3,3,3,1,1,3,2,2,2]"), 18));

    }

    /**
     * 6291. 数组元素和与数字和的绝对差
     * @param nums
     * @return
     */
    public int differenceOfSum(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            cnt1 += num;
            cnt2 += getCnt(num);
        }
        return Math.abs(cnt1 - cnt2);
    }

    private int getCnt(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return  ans;
    }

    /**
     * 6292. 子矩阵元素加 1
     * @param n
     * @param queries
     * @return
     */
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    mat[i][j]++;
                }
            }
        }
        return mat;
    }

    /**
     * 6293. 统计好子数组的数目
     * @param nums
     * @param k
     * @return
     *
     * 输入：nums = [3,1,4,3,2,2,4], k = 2
     * 输出：4
     * 解释：总共有 4 个不同的好子数组：
     * - [3,1,4,3,2,2] 有 2 对。
     * - [3,1,4,3,2,2,4] 有 3 对。
     * - [1,4,3,2,2,4] 有 2 对。
     * - [4,3,2,2,4] 有 2 对。
     */
    public long countGood(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> map;
        // 需要由k反推所需要的最小长度，并根据此长度初始化map，后面滑动处理这个map即可
        int l = calMinLen(k);
        map = initMap(nums, 0, l); // map初始化
        int end = l;
        if (getMapPairCnt(map) >= k) {
            ans += nums.length - end;
        }
        // 遍历子数组的起点和重点
        for (int i = 0; i < nums.length - l; i++) { // 注意这里 - l
            if (i > 0) {
                // 需要将前一个元素从map中移除
                int cnt = map.get(nums[i - 1]);
                map.put(nums[i - 1], cnt - 1);

                if (end >= nums.length -1) {
                    if (getMapPairCnt(map) >= k) {
                        ans += 1;
                    }
                    continue;
                }
            }

            end++;
            while (end < nums.length) {
                // 需要往map里面新增
                int cnt = map.getOrDefault(nums[end], 0);
                map.put(nums[end], ++cnt);
                if (getMapPairCnt(map) >= k) {
                    ans += nums.length - end;
                    break;
                }
                end++;
            }
        }

        return ans;
    }

    /**
     * 将start和end之间的数映射到map中
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private Map<Integer, Integer> initMap(int[] nums, int start, int end) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while (start <= end) {
            int cnt = map.getOrDefault(nums[start], 0);
            map.put(nums[start], ++cnt);
            start++;
        }
        return map;
    }

    /**
     * 计算当前map中的配对数量
     * @param map
     * @return
     */
    private int getMapPairCnt(Map<Integer, Integer> map) {
        int ans = 0;
        // map中key是元素，value是出现的次数
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            if (cnt < 2) {
                continue;
            }
            // 出现了cnt次key，那么可以配对多少C cnt / 2，配对是(cnt- 1)！
            ans += calSum(cnt - 1);
        }
        return ans;
    }

    private int calSum(int t) {
        int ans = 0;
        while (t > 0) {
            ans += t;
            t--;
        }
        return ans;
    }

    private int calMinLen(int k) {
        int len = 0;
        do {
            len++;
            k -= len;
        } while (k > 0);
        return k < 0 ? len - 1 : len;
    }

}
