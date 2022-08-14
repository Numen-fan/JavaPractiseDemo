package com.jiajia.daily;

import com.jiajia.kit.ArrayUtils;

import java.util.*;

/**
 * Created by Numen_fan on 2022/8/7
 * Desc:
 */
public class Solution20220807 {

    public static void main(String[] args) {

        Solution20220807 solution20220807 = new Solution20220807();
        List<String> list = new ArrayList<>();
//        "0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"
//        "0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"
        list.add("0:start:0");
        list.add("0:start:2");
        list.add("0:end:5");
        list.add("1:start:6");
        list.add("1:end:6");
        list.add("0:end:7");

        ArrayUtils.print(solution20220807.exclusiveTime(2, list));


    }

    public int[] exclusiveTime(int n, List<String> logs) {

        Map<String, Integer> map = new HashMap<>();

        String[] lastInfos = null;

        Stack<String[]> stack = new Stack<>();

        for (String log : logs) {

            String[] infos = log.split(":");

            if (infos[1].equals("start")) {
                // 当前是开始
                if (!stack.isEmpty() && lastInfos != null) {
                    // 前一个是end
                    // 判断是否衔接
                    int diff = Integer.parseInt(infos[2]) - Integer.parseInt(lastInfos[2]) - 1;
                    if (diff != 0) {
                        // 时间差，应该加到前一个start上面
                        String[] tempInfos = stack.peek();
                        int time = map.get(tempInfos[0]) == null ? 0 : map.get(tempInfos[0]); // 已经占用的时间
                        map.put(tempInfos[0], time + diff);
                    }
                } else if (!stack.isEmpty()) { // 前一个需要暂停处理
                    String[] tempInfos = stack.peek();
                    int time = map.get(tempInfos[0]) == null ? 0 : map.get(tempInfos[0]); // 已经占用的时间
                    map.put(tempInfos[0], time + Integer.parseInt(infos[2]) - Integer.parseInt(tempInfos[2]));
                }
                stack.add(infos);
                lastInfos = null;
            } else {
                // 当前是结束
                // 拿到他的start信息

                if (lastInfos != null) {
                    // 结束之前的
                    int time = map.get(infos[0]) == null ? 0 : map.get(infos[0]); // 已经占用的时间
                    map.put(infos[0], time + Integer.parseInt(infos[2]) - Integer.parseInt(lastInfos[2]));
                } else {
                    String[] startInfos = stack.pop();
                    int time = map.get(startInfos[0]) == null ? 0 : map.get(startInfos[0]); // 已经占用的时间
                    map.put(startInfos[0], time + Integer.parseInt(infos[2]) - Integer.parseInt(startInfos[2]) + 1);
                }
                lastInfos = infos;
            }
        }

        int[] ans = new int[n];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(String.valueOf(i));
        }

        return ans;

    }
}
