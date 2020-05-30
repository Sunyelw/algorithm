package com.sun.yelw.answer.array;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.array
 * 类名称:     GasStation134
 * 类描述:     leetcode 134
 * 创建人:     huangyang
 * 创建时间:   2020/5/28 15:32
 */
@SuppressWarnings("all")
public class GasStation134 {

    public static void main(String[] args){

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit1(gas, cost));
    }

    /* 方法2 一次遍历 */
    // 时间 O(N) 空间 O(1)
    // 1. 只要 gas[i] < cost[i], 则此站不能作为起点
    // 2. 只要 sum(gas) < sum(cost), 则没有站点满足条件
    // 3. 如果A站无法到达B站, 那么A与B之间的任何一个站都不能到达B站(B站是A站第一个无法达到的站)
    private static int canCompleteCircuit1(int[] gas, int[] cost) {
        // 当前油量
        int curr = 0;
        // 油量差值
        int total = 0;
        // 起始站点
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curr += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (curr < 0) {
                curr = 0;
                start = i + 1;
            }
        }
        return total >= 0 ? start : -1;
    }


    /* 方法1 暴力破解 */
    // 时间 O(N^2)
    // 空间 O(1)
    // 逐个站点判断是否可以作为起点
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int x = i;
            int next = i - 1;
            int curr = gas[x];
            do {
                if (curr < cost[x]) break;
                next = (x + 1) % len;
                curr = curr - cost[x] + gas[next];
                x = next;
            } while (next != i);

            if (next == i) return i;
        }
        return -1;
    }

}
