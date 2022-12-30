package com.jiajia.daily;

import java.util.TreeSet;

public class Solution20221230 {

    TreeSet<Integer> students;
    int N;

    public static void main(String[] args) {

    }

    public Solution20221230(int n) {
        students = new TreeSet<>();
        N = n;
    }

    public int seat() {
        // 优先处理第一个和第二个同学插入的情况
        int student = 0;

        if (students.size() > 0) {
            int dist = students.first(); // 为什么初始化的距离是第一个呢，0距离这个位置有多远呗
            Integer prev = null; // 前一个
            // 计算i，j之间的距离
            for (Integer s : students) {
                if (prev != null) {
                    int d = (s - prev) / 2; // prev和s之间的距离
                    if (d > dist) {
                        dist = d;
                        student = prev + d; // 插入的位置
                    }
                }
                prev = s; // 前一个
            }

            // 考虑最后最右侧的情况, 放在最后一个位置的情况
            if (N - 1 - students.last() > dist) {
                student = N - 1;
            }
        }
        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }

}
