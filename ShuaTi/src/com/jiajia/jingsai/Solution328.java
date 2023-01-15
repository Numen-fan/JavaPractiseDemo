package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class Solution328 {

    public static void main(String[] args) {

        Solution328 s = new Solution328();
        System.out.println(s.countGood(ArrayUtils.string2IntArray("[3,1,4,3,2,2,4]"), 2));

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
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 检查i-j之间是否满足需求
                // 如果i-j的长度不能配对k个组，那么也不需要进行计算了，做剪枝
                int len = j - i + 1;
                if (calSum(len) < k) {
                    continue;
                }
                if (calPair(nums, i , j) >= k) {
                    // 当前满足, 那么j之后的所有元素都满足
                    ans += nums.length - j;
                    break; // 不再进行后面的计算了
                }
            }
        }

        return ans;
    }

    private int calPair(int[] nums, int start, int end) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (start <= end) {
            int cnt = map.getOrDefault(nums[start], 0);
            map.put(nums[start], ++cnt);
            start++;
        }

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

}
