package com.sun.yelw.leetcode.topk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.leetcode.topk
 * 类名称:     HeapSolution
 * 类描述:     使用小顶堆实现top K
 * 创建人:     huangyang
 * 创建时间:   2019/10/5 8:43
 */
public class TopSolution {

    /**
     *
     * lc==347. 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     */

    public static void main(String[] args){

        int[] arr = {1};
        int k = 1;
        // map
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            int cnt = map.getOrDefault(a, 0);
            map.put(a, ++cnt);
        }
//
//        // 1
//        System.out.println(heapSolution(map, 2));

        // 2

        int[] nums = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            nums[i++] = key;
        }

        List<Integer> list = new ArrayList<>();
        if (i == k) {
            for (int a = 0; a < i; a++) list.add(nums[a]);
        }

        partition(map, nums, 0, nums.length - 1, k);

        for (int x = 0; x < k; x++) list.add(nums[x]);

        System.out.println(list);

    }

    /**
     * solution 2 Quick Select Partition
     *
     * @param arr arr
     * @param x x
     * @param y y
     * @param k k
     * @return
     */
    private static void partition(Map <Integer, Integer> map, int[] arr, int x, int y, int k) {
        int pivot = map.get(arr[y]);

        int z = x - 1, i = x;
        for (; i <= y; i++) {
            if (map.get(arr[i]) >= pivot) {
                z++;
                if (z != i) swap(arr, z, i);
            }
        }
        if (z + 1 != y) swap(arr, z + 1, y);
        // retrieve
        if (z < k && z + 2 <= arr.length) partition(map, arr, z + 2, y, k);
        if (z > k && z >= 0) partition(map, arr, x, z, k);
    }

    // solution 1  min root heap
    // O(NlgK)
    // O(N)
    private static List<Integer> heapSolution(Map <Integer, Integer> map, int k) {

        Heap heap = new Heap(k, map);
        for (int key : map.keySet()) {
            heap.insert(key);
        }

        int[] arr = heap.getArr();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i ++) list.add(arr[i]);
        return list;
    }


    // 交换
    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
