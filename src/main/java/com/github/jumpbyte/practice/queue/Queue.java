package com.github.jumpbyte.practice.queue;

import java.util.Arrays;

/**
 * 循环队列
 *
 * @author yuanjinan
 */
public class Queue<T> {

    Object[] data;
    //队列尾
    int rear;
    //队列头
    int front;
    //
    int size;

    public Queue(int size) {
        data = new Object[size];
        this.size = size;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(T item) {
        if (isFull()) {
            System.out.println("队列已满");
            return false;
        }
        this.rear = (this.rear + 1) % size;
        this.data[rear] = item;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }
        this.front = (this.front + 1) % size;
        T item = (T) this.data[front];
        this.data[front] = null;
        return item;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "data=" + Arrays.toString(data) +
                ", rear=" + rear +
                ", front=" + front +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<>(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        System.out.println(myQueue);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue);
        System.out.println(myQueue.dequeue());
    }


}
