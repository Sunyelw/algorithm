package com.sun.yelw.answer.stack;

import lombok.Data;

import java.util.Arrays;

/**
 * 项目名称:   algorithm
 * 包:        com.sun.yelw.answer.stack
 * 类名称:     StackDemo
 * 类描述:     stack demo
 * 创建人:     huangyang
 * 创建时间:   2019/8/3 17:33
 */
@Data
public class MyArrayStack<T> {

    private final static int ZERO_SIZE = 0;

    // 数据数组
    private Object[] dArr;
    // 当前数组大小
    private int size;
    // 当前栈顶元素的下一个地址
    private int count;

    public MyArrayStack() {
        this(0);
    }

    public  MyArrayStack(int num) {
        dArr = new Object[num];
        size = dArr.length;
        count = ZERO_SIZE;
    }

    // 入栈
    public void push(T data) {
        if (count == size) {
            // 扩容 double
            dArr = Arrays.copyOf(dArr, dArr.length << 1);
            size = dArr.length;
        }

        dArr[count] = data;
        count++;
    }

    // 出栈
    public T pop() {

        if (size == 0) return null;

        @SuppressWarnings("unchecked")
        T tmp = (T) dArr[--count];
        dArr[count] = null;
        return tmp;
    }

    // 四则运算

    // 括号匹配


    public static void main(String[] args){

    }
}
