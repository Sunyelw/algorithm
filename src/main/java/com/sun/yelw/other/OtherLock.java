//package com.sun.yelw.other;
//
//import java.util.concurrent.locks.AbstractQueuedSynchronizer;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
///**
// * 项目名称:   pinkstone
// * 包:        com.sun.yelw.other
// * 类名称:     OtherLock
// * 类描述:     2
// * 创建人:     huangyang
// * 创建时间:   2020/5/16 11:05
// */
//public class OtherLock extends ReentrantReadWriteLock.ReadLock {
//
//    /**
//     * Constructor for use by subclasses
//     *
//     * @param lock the outer lock object
//     * @throws NullPointerException if the lock is null
//     */
//    protected OtherLock(ReentrantReadWriteLock lock){
//        super(lock);
//    }
//
//    public Condition newCondition() {
//        return new AbstractQueuedSynchronizer.ConditionObject();
//    }
//}
