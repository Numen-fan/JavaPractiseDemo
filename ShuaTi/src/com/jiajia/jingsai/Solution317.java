package com.jiajia.jingsai;

import com.jiajia.common.TreeNode;
import com.jiajia.kit.ArrayUtils;

import java.util.*;

/**
 * Created by Numen_fan on 2022/10/30
 * Desc:
 */
public class Solution317 {

    public static void main(String[] args) {
        Solution317 solution317 = new Solution317();

        System.out.println(
                solution317.mostPopularCreator(new String[]{"alice", "bob", "alice", "chris"},
                        new String[]{"one", "two", "three", "four"},
                        ArrayUtils.string2IntArray("[5,10,5,4]")));
    }

    /**
     * 6220. 可被三整除的偶数的平均值
     *
     * @param nums
     * @return
     */
    public int averageValue(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int a : nums) {
            if (a % 2 == 0 && a % 3 == 0) {
                list.add(a);
            }
        }

        if (list.isEmpty()) {
            return 0;
        }

        int cnt = 0;
        for (int b : list) {
            cnt += b;
        }

        return cnt / list.size();

    }


    /**
     * 6221. 最流行的视频创作者
     *
     * @param creators
     * @param ids
     * @param views
     * @return
     */
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        Map<String, Point> points = new HashMap<>();
        long maxViews = -1;
        for (int i = 0; i < n; i++) {
            String name = creators[i];
            Point point = points.get(name);
            if (point == null) {
                point = new Point();
            }
            point.views += views[i];
            point.map.put(ids[i], views[i]);
            maxViews = Math.max(maxViews, point.views);
            points.put(name, point);
        }

//        Collections.sort(pointList);

        // 找到所有播放量最大的成员
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, Point> pointEntry : points.entrySet()) {
            if (pointEntry.getValue().views == maxViews) {
                // 这是一个最大播放量的成员
                List<String> res = new ArrayList<>();
                res.add(pointEntry.getKey());
                res.add(pointEntry.getValue().getView());
                ans.add(res);
            }
        }


        return ans;

    }

    static class Point {

        public String name;

        // 总的播放量
        public long views;

        public Map<String, Integer> map = new HashMap<>();


        public String getView() {
            int views = -1;
            String ids = "";
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > views) {
                    views = entry.getValue();
                    ids = entry.getKey();
                } else if (entry.getValue() == views && entry.getKey().compareTo(ids) < 0) {
                    ids = entry.getKey();
                }
            }
            return ids;
        }
    }

    /**
     * 6222. 美丽整数的最小增量
     * @param n
     * @param target
     * @return
     */
    public long makeIntegerBeautiful(long n, int target) {
        if (getC(n) <= target) {
            return 0;
        }

        long origin = n;

        long i = 10; // 控制进位，先是10位置

        while (getC(n) > target) {
            n  = n / i; // 去掉了个位
            n++; // 十位加1了
            n *= i; // 个位变为了0，十位加1
            i *= 10; // 下一次是百位
        }

        return n - origin;
    }

    private int getC(long n) {
        int c = 0;
        while (n > 0) {
            c += n % 10;
            n = n / 10;
        }
        return c;
    }

    /**
     * 6223. 移除子树后的二叉树高度
     * @param root
     * @param queries
     * @return
     */
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = getHeight(root, queries[i]) - 1;
        }

        return ans;
    }

    private int getHeight(TreeNode root, int query) {
        if (root == null || root.val == query) {
            return 0;
        }
        int left = getHeight(root.left, query);
        int right = getHeight(root.right, query);
        return Math.max(left, right) + 1;
    }

}
