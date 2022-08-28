package com.jiajia.jingsai;

import com.jiajia.kit.ArrayUtils;

import java.util.*;

/**
 * Created by Numen_fan on 2022/8/28
 * Desc: AC
 */
public class Solution308 {

    public static void main(String[] args) {

        Solution308 solution308 = new Solution308();

        System.out.println(solution308.getSubSumLength(new int[]{1, 2, 4, 5}, 10));

        int[][] row = ArrayUtils.string2IntArray2("[[1,2],[7,3],[4,3],[5,8],[7,8],[8,2],[5,8],[3,2],[1,3],[7,6],[4,3],[7,4],[4,8],[7,3],[7,5]]");

        int[][] col = ArrayUtils.string2IntArray2("[[5,7],[2,7],[4,3],[6,7],[4,3],[2,3],[6,2]]");

        ArrayUtils.print(solution308.buildMatrix(8, row, col));
    }

    /**
     * 6160. 和有限的最长子序列
     *
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);

        for (int i = 0; i < queries.length; i++) {
            queries[i] = getSubSumLength(nums, queries[i]);
        }

        return queries;


    }

    private int getSubSumLength(int[] nums, int target) {
        if (target <= 0) {
            return 0;
        }

        int sum = 0;
        int i = 0;

        for (; i < nums.length; i++) {
            sum += nums[i];
            if (sum <= target) {
                continue;
            }
            break;
        }
        return i;
    }

    /**
     * 6161. 从字符串中移除星号
     *
     * @param s
     * @return
     */
    public String removeStars(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                sb.append(s.charAt(i));
            } else if (sb.length() > 0) {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
        }

        return sb.toString();

    }

    public int garbageCollection(String[] garbage, int[] travel) {

        int ans = 0;
        ans += getCollectionTime(garbage, travel, 'M');
        ans += getCollectionTime(garbage, travel, 'P');
        ans += getCollectionTime(garbage, travel, 'G');
        return ans;

    }

    private int getCollectionTime(String[] garbage, int[] travel, char target) {
        int sum = 0;
        int cost = 0; // 到打某一个站点的花销
        for (int i = 0; i < garbage.length; i++) {
            // 到达i站点
            if (i > 0) {
                cost += travel[i - 1]; // 到达这个站点的路上时间
            }
            if (garbage[i].contains(String.valueOf(target))) {
                // 这个房子有这个类型的垃圾
                for (char ch : garbage[i].toCharArray()) {
                    if (ch == target) {
                        sum++;
                    }
                }
                sum += cost;
                cost = 0; // 用完了
            }
        }
        return sum;
    }

    /**
     * 6163. 给定条件下构造矩阵
     * @param k
     * @param rowConditions
     * @param colConditions
     * @return
     */
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        int[][] ans = new int[k][k];

        int[] rowIndex = getOrder(k, rowConditions);
        if (rowIndex == null) {
            return new int[][]{};
        }

        int[] colIndex = getOrder(k, colConditions);
        if (colIndex == null) {
            return new int[][]{};
        }

        // 先放行
        for (int i = 0; i < rowIndex.length; i++) { // 行
            // 数字
            int num = rowIndex[i];

            // 找到num所在列
            for (int j = 0; j < colIndex.length; j++) {
                if (colIndex[j] == num) {
                    ans[i][j] = num;
                }
            }
        }

        return  ans;

    }

    private int[] getOrder(int k, int[][] rowConditions) {

        int[] ans = new int[k];

        Map<Integer, List<Point>> rowMap = new HashMap<>();

        int[] rowCount = new int[k + 1];

        for (int i = 0; i < rowConditions.length; i++) {
            rowMap.computeIfAbsent(rowConditions[i][0], key -> new ArrayList<>());
            Point point = new Point(rowConditions[i][0], rowConditions[i][1]);
            if (!rowMap.get(rowConditions[i][0]).contains(point)) {
                rowMap.get(rowConditions[i][0]).add(point);
                rowCount[rowConditions[i][1]]++; // 记录该节点的入边数量
            }
        }

        // 先放行
        int rowIndex = 0;

        for (int i = 1; i < rowCount.length; i++) {
            if (rowCount[i] == 0) {
                // 没有人在他上面
                ans[rowIndex] = i; // 放i
                rowIndex++;
                rowCount[i]--; // 使得他为-1
                // 那么将这个节点出边节点拿到，并且减去1
                List<Point> list = rowMap.get(i);
                if (list == null) {
                    continue;
                }

                for (Point point : list) { // 找到这个节点的所有出点, 将其入度-1
                    if (rowCount[point.y] <= 0) {
                        continue;
                    }
                    rowCount[point.y]--;
                }
                i = 0; // 从头再来
            }
        }

        // 没办法放
        for (int a : rowCount) {
            if (a > 0) {
                return null;
            }
        }
        return ans;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return y - o.y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
