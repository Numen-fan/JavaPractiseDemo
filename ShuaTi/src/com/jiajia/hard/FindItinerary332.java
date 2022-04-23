package com.jiajia.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程  2022-04-15
 */
public class FindItinerary332 {

    private List<String> result = new ArrayList<>(); // 记录结果
    private List<String> path = new ArrayList<>(); // 记录临时的路径
    private boolean[] used; // 记录机票的使用情况，会出现闭环，导致机票重复使用问题

    public static void main(String[] args) {

        FindItinerary332 findItinerary332 = new FindItinerary332();

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));

        List<String> path = findItinerary332.findItinerary(tickets);

        System.out.println(path);



    }



    public List<String> findItinerary(List<List<String>> tickets) {

        used = new boolean[tickets.size()];
        // 开始递归查找的入口，应该是JFK开始的机票，
        // 所以有几张JFK开始的机票，就应该有几次查找
        path.add("JFK"); // 起点，接下来不断添加下一个地点即可
        backTracking(tickets, "JFK", 0);
        return result;

    }

    /**
     * 每次进入表示需要确定下一个位置
     * passed 表示使用了多少张机票
     */
    private void backTracking(List<List<String>> tickets, String curPlace, int passed) {

        // 退出递归的条件
        // 所有的机票都用完了
        if(passed == tickets.size()) {
            // 走完了所有的机票，此时path和result比较，取最小的
            if (result.isEmpty()) {
                result = new ArrayList<>(path);
                return;
            }
            for (int i = 0; i < path.size(); i++) {
                if (path.get(i).equals(result.get(i))) {
                    continue;
                }
                // 出现不等的地名，按照不等地名的大小赋值result
                if (path.get(i).compareTo(result.get(i)) < 0) { // 说明path更小
                    result = new ArrayList<>(path);
                }
                return;
            }
            return;
        }

        // 开始查找当前起点的机票
        for(int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            if(used[i] || !curPlace.equals(ticket.get(0))) {
                continue;
            }

            // 将当前地点加入到【这地方有点问题，不能加机票起点，应该加终点，那么问题来了，起点应该在那加入呢】
            path.add(ticket.get(1));
            passed += 1;
            used[i] = true; // 当前机票已经使用
            backTracking(tickets, ticket.get(1), passed);
            // 开始回溯
            passed -= 1;
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
