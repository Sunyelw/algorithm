package com.sun.yelw.answer.other;

import java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * 项目名称:   pinkstone
 * 包:        com.sun.yelw.answer.other
 * 类名称:     HyLock
 * 类描述:     允许多线程重入的 ReentrantLock
 * 创建人:     huangyang
 * 创建时间:   2020/5/14 19:45
 */
public class HyLock implements Serializable {

    private Sync sync;

    HyLock(int permits) {
        sync = new Sync(permits);
    }

    public void lock() { sync.lock(); }

    public void unlock() { sync.unlock(); }

    public Condition newCondition() { return sync.newCondition(); }

    static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -5179523762034025860L;

        Sync(int state) {
            setState(state);
        }

        final void lock() {
            acquireShared(1);
        }

        final void unlock() {
            releaseShared(1);
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }

        protected final int tryAcquireShared(int acquires) {
            for (;;) {
                int available = getState();
                int remaining = available - acquires;
                if (remaining < 0 ||
                        compareAndSetState(available, remaining))
                    return remaining;
            }
        }

        protected final boolean tryReleaseShared(int releases) {
            for (;;) {
                int current = getState();
                int next = current + releases;
                if (next < current)
                    throw new Error("Maximum permit count exceeded");
                if (compareAndSetState(current, next))
                    return true;
            }
        }

        protected boolean tryRelease(int arg) {
            return tryReleaseShared(arg);
        }

        protected boolean tryAcquire(int arg) {
            return tryAcquireShared(arg) >= 0;
        }

        protected boolean isHeldExclusively() {
            return true;
        }
    }
}
