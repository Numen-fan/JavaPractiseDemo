package com.jiajia.jingsai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution257 {

    public static void main(String[] args) {
//        System.out.println(countQuadruplets(new int[]{35, 15, 38, 1, 10, 26}));
        int[][] properties = new int[][]{{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}};
        System.out.println(numberOfWeakCharacters2(properties));
    }

    /**
     * 5863. 统计特殊四元组
     */
    public static int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i = 3; i < nums.length; i++) {
            for (int j = 0; j <= i - 3; j++) {
                for (int k = j + 1; k <= i - 2; k++) {
                    for (int n = k + 1; n <= i - 1; n++) {
                        if (nums[i] == nums[j] + nums[k] + nums[n]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 5864. 游戏中弱角色的数量
     */
    public static int numberOfWeakCharacters(int[][] properties) {
        int count = 0;
        int n = properties.length;
//        Arrays.sort(properties);
        List<Integer> done = new ArrayList<>(); // 已经确定为弱鸡的编号
        for (int i = 0; i < n; i++) {
            if (done.contains(i)) {
                continue;
            }
            int attack = properties[i][0]; // 拿第i个去打一圈
            int defense = properties[i][1];
            for (int j = 0; j < n; j++) {
                if (done.contains(j) || i == j) {
                    continue;
                }
                if (attack < properties[j][0] && defense < properties[j][1]) { // 打不过第j个
                    count++;
                    done.add(i);
                    break; // 第i个为辣鸡，定了
                } else if (properties[j][0] < attack && properties[j][1] < defense) {
                    // 打过了第j个，说明第j个为弱鸡
                    count++;
                    done.add(j);
                }
            }
            // 走到这里说明他不是个弱鸡

        }
        return count;
    }

    public static int numberOfWeakCharacters2(int[][] properties) {
        int n = properties.length;
        List<Point> points = new ArrayList<>(n);
        for (int[] property : properties) {
            points.add(new Point(property[0], property[1]));
        }
        Collections.sort(points);
        int maxA = points.get(0).a;
        int maxB = points.get(0).b;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (points.get(i).a > maxA && points.get(i).b > maxB) {
                count = i;
                maxA = points.get(i).a;
                maxB = points.get(i).b;
            }
        }
        return count;
    }

    static class Point implements Comparable<Point> {

        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Point o) {
            if (o == this || (o.a == a && o.b == b)) {
                return 0;
            }

            if (a < o.a && b < o.b) {
                return -1;
            }

            if (a < o.a) {
                return -1;
            }

            if (a == o.a && b < o.b) {
                return -1;
            }

            return 1;
        }
    }


}
