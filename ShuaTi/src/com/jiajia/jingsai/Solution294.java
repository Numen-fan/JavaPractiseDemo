package com.jiajia.jingsai;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Numen_fan on 2022/5/22
 * Desc:
 */
public class Solution294 {


    public static void main(String[] args) {

        Solution294 solution294 = new Solution294();

        System.out.println(solution294.percentageLetter("vmvvvvvzrvvpvdvvvvyfvdvvvvpkvvbvvkvvfkvvvkvbvvnvvomvzvvvdvvvkvvvvvvvvvlvcvilaqvvhoevvlmvhvkvtgwfvvzy", 'v'));

        System.out.println(solution294.minimumLines(new int[][]{{200,1},{201,499999999},{202,999999998},{203,1000000000}}));

    }

    /**
     * 6074. 字母在字符串中的百分比
     */
    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt = cnt + (s.charAt(i) == letter ? 1 : 0);
        }

        return cnt * 100 / s.length();
    }

    /**
     * 6075. 装满石头的背包的最大数量
     * @param capacity capacity[i] 表示第i个背包能装的石头数量
     * @param rocks rocks[i] 表示第i背包已经装的石头数量
     * @param additionalRocks 表示还可以拿几个石头 【有可能这个数量用不完】
     * @return 返回最大能装满的背包数量
     * 另外单独起一个数组，res[i] = capacity[i] - rocks[i]; == 0 表示已经装满
     * 然后按照从小到大排序，依次填满即可
     */
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int n = capacity.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(res); // 让res从小到大排序了

        int ans = 0;

        for (int j = 0; j < n; j++) { // 贪心填充res[j]
            if (additionalRocks >= res[j]) {
                additionalRocks -= res[j];
                res[j] = 0;
            }
            ans = ans + (res[j] == 0 ? 1 : 0);
        }
        return ans;
    }

    /**
     * 6076. 表示一个折线图的最少线段数
     * @param stockPrices stockPrices[day][prices] 表示第day天的股票价格
     * 【思想】先进行二维数组进行排序，按照day进行排序，因为day各不相同
     *                    随后计算相邻点之间的斜率即可
     *  但是计算斜率可能存在浮点数的误差啊
     *
     */
    public int minimumLines(int[][] stockPrices) {

        int ans = 0;

        if (stockPrices.length < 2) {
            return ans; // 少于两个点直接返回0条折线
        }

        // 1 先排序, 因为day不同，所以直接使用day排序即可
        Arrays.sort(stockPrices, (Comparator.comparingInt(o -> o[0])));

        int pre0X = stockPrices[0][0];
        int pre0Y = stockPrices[0][1];
        int pre1X = stockPrices[1][0];
        int pre1Y = stockPrices[1][1];
        ans += 1;
        for (int i= 2; i < stockPrices.length; i++) {

            // 得判断0
            if ((stockPrices[i][0] - pre1X) * (pre1Y - pre0Y)  != (pre1X - pre0X) * (stockPrices[i][1] - pre1Y) ) {
                ans += 1;
            }

            pre0X = pre1X;
            pre0Y = pre1Y;

            pre1X = stockPrices[i][0];
            pre1Y = stockPrices[i][1];

        }
        return ans;
    }


}
