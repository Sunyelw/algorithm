package com.sun.yelw.answer.sort;

import java.util.Arrays;

/**
 * 项目名称:   MyDemo
 * 包:        com.example.demo.sort
 * 类名称:     InsertSort
 * 类描述:     插入排序
 * 创建人:     huangyang
 * 创建时间:   2018/12/26 20:15
 */
public class InsertSort {

	public static void main(String[] args) {

		int[] A = {2, 4, 6, 1, 7, 5};
		doSort(A);
	}

    /**
     * 时间: 最好 O(N) 最坏 O(N^2) 平均 O(N^2)
     * 空间: O(1) 没用到额外空间, 是原地排序
     * 稳定性: A[j] > tmp: 稳定排序; A[j] >= tmp: 非稳定排序
     *
     */
	private static void doSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int tmp = A[i];
			int j = i - 1;
			// Two Arrays
			// 这里不能写 A[j] >= tmp 否则会变成不稳定排序算法
			while (j > -1 && A[j] > tmp) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = tmp;
		}

		System.out.println(Arrays.toString(A));
	}

}
