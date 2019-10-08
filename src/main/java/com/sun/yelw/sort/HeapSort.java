package com.sun.yelw.sort;

import java.util.Arrays;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.sort
 * 类名称:     HeapSort
 * 类描述:     堆排序
 * 创建人:     huangyang
 * 创建时间:   2019/10/4 16:01
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {8, 2, 9, 1, 4, 7, 6};

        HeapArray ha = new HeapArray(3);
        for (int a : arr) {
            ha.insert(a);
        }

        System.out.println(ha.capacity);
        System.out.println(ha.count);
        System.out.println(Arrays.toString(ha.arr));
    }

    static class HeapArray{

        final static int DEFAULT_CAPACITY = 1 << 4;

        // current number
        int count;
        // max number
        int capacity;
        // data array
        int[] arr;

        // init
        HeapArray(int capacity) {
            if (capacity <= 0) throw new IllegalArgumentException("capacity is negative");
            this.arr = new int[capacity + 1];
            this.count = 0;
            this.capacity = capacity;
        }

        HeapArray() {
            this(DEFAULT_CAPACITY);
        }

        void insert(int newInt) {

            /* 自动扩容 */

//            if (count == capacity) {
//                int[] tmp = new int[capacity << 1];
//                System.arraycopy(arr, 0, tmp, 0, capacity);
//                this.arr = tmp;
//                this.capacity = this.capacity << 1;
//            }

            /* 不可自动扩容 */

            if (count >= capacity) {
                if (newInt > arr[1]) {
                    try {
                        deleteTop();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            }

            arr[++count] = newInt;
            downHeapify(count, 1);
        }

        // 从下而上 堆化
        void downHeapify(int curr, int limit) {
            if (curr == 1) return;
            int parent;
            while ((parent = curr / 2) >= limit && arr[curr] < arr[parent]) {
                // swap
                swap(curr, parent);
                // continue
                curr = parent;
            }
        }

        // 从上而下 堆化
        void upHeapify(int curr, int limit) {
            int minPos, s1, s2;
            while (true) {
                // 记录俩子节点中更小的那个（如果是大顶堆，就是更大的那个）
                minPos = curr;
                if ((s1 = curr << 1) <= limit && arr[s1] < arr[curr]) {
                    minPos = s1;
                }
                if ((s2 = (curr << 1) + 1) <= limit && arr[s2] < arr[minPos]) {
                    minPos = s2;
                }
                if (curr == minPos) break;
                swap(minPos, curr);
                curr = minPos;
            }
        }

        void deleteTop() throws IllegalAccessException{

            if (0 == count) throw new IllegalAccessException("heap is empty");

            // 删除堆顶元素，使用最后一个元素替换堆顶
            arr[1] = arr[count];
            arr[count] = 0;

            upHeapify(1, --count);
        }

        void swap(int pos1, int pos2) {
            int tmp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = tmp;
        }

        // 每次将堆顶放到最后，然后由上至下堆化
        // 最后有序
        void sort() {
            int curr = count;
            while (curr > 1) {
                swap(curr, 1);
                curr--;
                upHeapify(1, curr);
            }
        }

        void sort1() {

            int curr = 1;
            while (curr < count) {
                curr++;
                upHeapify(curr, count);
            }
        }
    }

    static class Heap{
        int count;
        int capacity;
        int[] arr;

        Heap(int[] nums) {
            int i = nums.length / 2;
            for (; i >= 0; i--) {
                heapify(i, nums.length);
            }
        }

        // up to down
        void heapify(int x, int y) {
            int minPos, sL, sR;
            while(true) {
                minPos = x;
                if ((sL = x == 0 ? 1 : (x >> 1) + 1) < y && arr[sL] < arr[x]) minPos = sL;
                if ((sR = x == 0 ? 2 : (x >> 1) + 2) < y && arr[sR] < arr[minPos]) minPos = sL;
                if (minPos == x) break;
                swap (x, minPos);
                x = minPos;
            }
        }

        void swap(int x, int y) {
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }
    }
}
