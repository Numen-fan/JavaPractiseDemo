package com.jiajia.jingsai;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Numen_fan on 2022/5/29
 * Desc:
 */
public class Solution295 {

    public static void main(String[] args) {
        Solution295 solution295 = new Solution295();

        System.out.println(solution295.rearrangeCharacters("abbaccaddaeea", "aaaaa"));

        System.out.println(solution295.discountPrices("there are $1 $2 and 5$ candies in the shop", 50));

        System.out.println(solution295.totalSteps(new int[]{5,3,4,4,7,3,6,11,8,5,11}));

    }

    /**
     * 6078. 重排字符形成目标字符串
     */
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> targetMap = new HashMap<>();

        // 记录目标所需要的值
        for (int i = 0; i < target.length(); i++) {
            Character ch = target.charAt(i);
            int cnt = targetMap.containsKey(ch) ? targetMap.get(ch) + 1 : 1;
            targetMap.put(ch, cnt);
        }


        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (target.contains(String.valueOf(s.charAt(i)))) {
                int cnt = map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) + 1 : 1;
                map.put(s.charAt(i), cnt);
            }
        }

        if (map.isEmpty()) {
            return 0;
        }

        int cnt = Integer.MAX_VALUE;

        for (Character ch : targetMap.keySet()) {
            int sum = map.get(ch) == null ? 0 : map.get(ch);
            cnt = Math.min(sum / targetMap.get(ch), cnt);
        }

        return cnt;
    }

    /**
     * 6079. 价格减免
     * 超时了
     */
    public String discountPrices(String sentence, int discount) {

        DecimalFormat df = new DecimalFormat("#0.00");
        List<Point> prices = new ArrayList<>();

        for (int i = 0 ; i < sentence.length(); ) {
            if (sentence.charAt(i) == '$' && (i== 0 || sentence.charAt(i - 1) == ' ')) {
                // 说明找到了一个开端, 先判断$ 后面不是.
                if (i + 1 < sentence.length() && sentence.charAt(i + 1) == '.') {
                    i++;
                    continue;
                }
                i++;

                String price = "";
                Point point = new Point();
                point.startIndex = i;
                while (i < sentence.length() && isNumOrDot(sentence.charAt(i))) {
                    price = price + sentence.charAt(i);
                    i++;
                }

                // 找到了一个价格
                if (price.length() > 0 && (i == sentence.length() || sentence.charAt(i) == ' ')) {
                    point.endIndex = i - 1;
                    point.price = df.format(Double.parseDouble(price) - Double.parseDouble(price) * discount / 100);
                    prices.add(point);
                }
            } else {
                i++;
            }
        }

        // 找到了所有的价格
        System.out.println(prices);

        StringBuilder sb = new StringBuilder();

        int startIndex = 0;
        for (Point point : prices) {

            int start = point.startIndex;
            int end = point.endIndex + 1;

            sb.append(sentence, startIndex, start);

            sb.append(point.price);

            startIndex = end;
        }

        sb.append(sentence.substring(startIndex));


        return sb.toString();

    }

    private boolean isNumOrDot(char ch) {
        return ch >= '0' && ch <= '9' || ch == '.';
    }

    private static class Point {
        public String price;
        public int startIndex;
        public int endIndex;
    }

    public String dis(String sentence, int discount) {
        return Stream.of(sentence.split(" "))
                .map(t -> !t.matches("\\$\\d+") ? t
                        : String.format("$%.2f", Long.parseLong(t.substring(1)) * (1 - discount / 100.)))
                .collect(Collectors.joining(" "));

    }


    /**
     * 6080. 使数组按非递减顺序排列
     * 【超时了】
     */
    public int totalSteps(int[] nums) {
        int cnt = 0;
        boolean changed;
        do {
            changed = false;
            int lastIndex = 0;
            for (int i = nums.length - 1; i >= 1; i--) {
                if (nums[i] == -1) {
                    continue;
                }

                int j = i - 1;
                while (nums[j] == -1){
                    j--;
                }
                if (nums[i] < nums[j]) {
                    nums[i] = -1;
                    changed = true;
                }

                i = j + 1;

            }
            if (changed) {
                cnt++;
            }
        } while (changed);

        return cnt;
    }

    /**
     * 6081. 到达角落需要移除障碍物的最小数目
     * @param grid
     * @return
     * 【不会了】
     */
    public int minimumObstacles(int[][] grid) {

        // dp[i][j] 表示到大[i,j]至少需要移动多少个障碍物
        int[][] dp = new int[grid.length][grid[0].length];


        // 初始化左边的dp
        for (int i = 0; i < dp.length; i++) {
        }

        return 0;


        // 初始化top和left两边的dp只
    }
}
