package com.jiajia.hard;

import java.util.*;

/**
 * Created by Numen_fan on 2022/4/16
 * Desc: [332] hard 重新安排行程
 */
public class FindItinerary332 {

    private List<String> result = new ArrayList<>(); // 记录结果
    private final List<String> path = new ArrayList<>(); // 记录临时的路径
    private final Map<String, SortedMap<String, Integer>> ticketMap = new HashMap<>(); //

    public static void main(String[] args) {

        List<List<String>> tickets = new ArrayList<>();

        // 例子1
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));

        // 例子2
//        tickets.add(Arrays.asList("JFK","KUL"));
//        tickets.add(Arrays.asList("JFK","NRT"));
//        tickets.add(Arrays.asList("NRT","JFK"));



        FindItinerary332 findItinerary332 = new FindItinerary332();

        findItinerary332.findItinerary(tickets);

        System.out.println(findItinerary332.result);

    }


    public List<String> findItinerary(List<List<String>> tickets) {

        // 建立好机票出发地和到达地之间的映射关系，并对到达地进行排序。
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            SortedMap<String, Integer> toMap = ticketMap.get(from);
            if (toMap == null) {
                toMap = new TreeMap<>();
            }
            int curCnt = toMap.get(to) == null ? 0 : toMap.get(to);
            toMap.put(to, curCnt + 1);

            // 需要将toMap进行排序

            ticketMap.put(from, toMap);
        }

        // 开始递归查找的入口，应该是JFK开始的机票，
        // 所以有几张JFK开始的机票，就应该有几次查找
        path.add("JFK"); // 起点，接下来不断添加下一个地点即可
        backTracking(tickets, "JFK");
        return result;

    }

    /**
     * 每次进入表示需要确定下一个位置
     * passed 表示使用了多少张机票
     */
    private boolean backTracking(List<List<String>> tickets, String curPlace) {

        // 退出递归的条件
        // 所有的机票都用完了
        if(path.size() == tickets.size() + 1) {
            // 走完了所有的机票，此时path和result比较，取最小的
            if (result.isEmpty()) {
                result = new ArrayList<>(path);
                return true;
            }
        }

        SortedMap<String, Integer> toMap = ticketMap.get(curPlace);
        if (toMap == null) {
            return false;
        }

        for(Map.Entry<String, Integer> entry : toMap.entrySet()) {

            if (entry.getValue() <= 0) {
                continue;
            }

            String to = entry.getKey();

            // 这个地方的to需要考虑去重

            // 将当前地点加入到
            path.add(to);

            int cnt = entry.getValue();
            entry.setValue(cnt - 1);

            if (backTracking(tickets, to)) {
                return true;
            }

            path.remove(path.size() - 1);

            entry.setValue(cnt); // 恢复

        }

        return false;
    }

}
