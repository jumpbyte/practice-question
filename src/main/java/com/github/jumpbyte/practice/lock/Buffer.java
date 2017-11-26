package com.github.jumpbyte.practice.lock;

public class Buffer {

    private Object locker = new Object();

    public void write() {
        synchronized (locker) {

            long startTime = System.currentTimeMillis();
            System.out.println("开始写入数据");
            for (; ; ) {
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE) {
                    break;
                }
            }
            System.out.println("终于写完了");
        }
    }

    public void read() {
        synchronized (locker) {
            System.out.println("开始读取数据");
        }
    }
}
