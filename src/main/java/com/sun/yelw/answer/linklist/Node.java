package com.sun.yelw.answer.linklist;

import lombok.Data;

/**
 * 项目名称:   MyDemo
 * 包:        com.example.demo.algorithm.linklist
 * 类名称:     Node
 * 类描述:     链表节点
 * 创建人:     huangyang
 * 创建时间:   2019/8/1 15:30
 */
@Data
class Node {

    Node prev;
    Node next;
    Integer data;

    Node(){}

    Node(int data) {
        this.data = data;
    }

    Node(Node prev, Integer data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    // 不重写toString()方法会导致 链表代码栈溢出
    @Override
    public String toString(){
        return "Node{" +
                "data=" + data +
                '}';
    }

//    @Override
//    public String toString(){
//        return "Node{" +
//                "prev=" + prev +
//                ", next=" + next +
//                ", data=" + data +
//                '}';
//    }
}
