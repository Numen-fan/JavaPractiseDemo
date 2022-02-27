package com.jiajia.medium;

public class CanCompleteCircuit134 {


    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] coat = {3,4,5,1,2};

        System.out.println(method1(gas, coat));

    }

    /**
     * 贪心思想
     * 循环遍历一次gas，寻找解，时间复杂度O(N^2)
     */
    static int method1(int[] gas, int cost[]) {
        int ans = -1;
        for (int i = 0; i < gas.length;) {
            if (gas[i] < cost[i]) {
                i++;
                continue;
            }
            // 注意i只是控制起点
            int curIndex = i; // 遍历过程中的当前位置
            int totalGas = gas[i]; // 当前拥有的总油量
            int nextIndex = curIndex + 1 >= cost.length ? 0 : curIndex + 1; // 下一步
            while(true) {
                totalGas -= cost[curIndex]; // 到下一步消耗掉
                if(totalGas < 0) {
                    break;
                } else {
                    curIndex = nextIndex; // 到下一步
                    totalGas += gas[curIndex];
                    nextIndex = curIndex + 1 >= cost.length ? 0 : curIndex + 1;
                }
                if(curIndex == i) {
                    break;
                }
            }

            if (curIndex == i && totalGas >= 0) { // 回到最开始的地方
                ans = i;
                break;
            } else {
                i++;
            }
        }
        return ans;
    }

}
