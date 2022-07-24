package com.jiajia.jingsai;

import java.util.*;

/**
 * Created by Numen_fan on 2022/7/24
 * Desc:
 */
public class Solution303 {

    public static void main(String[] args) {

        Solution303 solution303 = new Solution303();

        int[][] grid = new int[][]{{3,2,1},{1,7,6},{2,7,7}};

        System.out.println(solution303.equalPairs(grid));

        System.out.println(solution303.countExcellentPairs(new int[]{1,2,4,8,16,32,64,128,256}, 2));

    }

    /**
     * 6124. 第一个出现两次的字母
     * @param s
     * @return
     */
    public char repeatedCharacter(String s) {

        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            record[index] += 1;
            if (record[index] == 2) {
                return s.charAt(i);
            }
        }

        return 'a'; // 不会走到
    }

    /**
     * 6125. 相等行列对
     * @param grid
     * @return
     */
    public int equalPairs(int[][] grid) {

        int ans = 0;

        int n = grid.length;


        // 第i行
        for (int[] arr1 : grid) {
            int[] arr2 = new int[n];
            for (int j = 0; j < n; j++) { // 列
                for (int k = 0; k < n; k++) { // 控制j列的行
                    arr2[k] = grid[k][j];
                }

                if (Arrays.equals(arr1, arr2)) {
                    ans++;
                }
            }

        }

        return ans;

    }

    /**
     * 6127. 优质数对的数目
     * @param nums
     * @param k
     * @return
     */
    public long countExcellentPairs(int[] nums, int k) {

        int ans = 0;

        List<String> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (list.contains("" + nums[i] + "" + nums[j])) {
                    continue;
                }
                int a = nums[i] | nums[j];
                int b = nums[i] & nums[j];
                if (getCount(Integer.toBinaryString(a)) + getCount(Integer.toBinaryString(b)) >= k) {
                    ans++;
                    list.add("" + nums[i] + "" + nums[j]);
                }
            }
        }

        return ans;
    }

    private int getCount(String as) {
        int ans = 0;
        for (int i = 0; i < as.length(); i++) {
            if (as.charAt(i) == '1') {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 6126. 设计食物评分系统
     */
    static class FoodRatings {

        Map<String, Food> foodMap = new HashMap<>();

        Map<String, List<Food>> cuisineMap = new HashMap<>();

        Map<String, Food> heightRating = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++){
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                foodMap.put(food.name, food);
                List<Food> fs = cuisineMap.computeIfAbsent(food.cuisine, k -> new ArrayList<>());
                fs.add(food);

                Food oldFood = heightRating.get(food.cuisine);
                if (oldFood == null || oldFood.rate < food.rate
                        || (oldFood.rate == food.rate && oldFood.name.compareTo(food.name) > 0)) {
                    heightRating.put(food.cuisine, food);
                }
            }
        }


        public void changeRating(String food, int newRating) {

            Food f = foodMap.get(food);
            f.rate = newRating;

            Food oldFood = heightRating.get(f.cuisine);

            if(oldFood.rate > f.rate || oldFood.rate == f.rate && oldFood.name.compareTo(f.name) < 0) {
                return;
            }

            // 改变烹饪分数
            int rating = Integer.MIN_VALUE;
            heightRating.put(f.cuisine, null);

            String foodName = "";

            // 找出这个列表中评分最高的
            for (Food food1 : cuisineMap.get(f.cuisine)) {
                if (food1.rate > rating) {
                    heightRating.put(f.cuisine, food1);
                    foodName = food1.name;
                    rating = food1.rate;
                } else if (food1.rate == rating && foodName.compareTo(food1.name) > 0) {
                    heightRating.put(f.cuisine, food1);
                }
            }
        }

        public String highestRated(String cuisine) {
            return heightRating.get(cuisine).name;
        }

        static class Food {
            String name;
            String cuisine;
            int rate;

            public Food(String name, String cuisine, int rate) {
                this.name = name;
                this.cuisine = cuisine;
                this.rate = rate;
            }
        }
    }

}
