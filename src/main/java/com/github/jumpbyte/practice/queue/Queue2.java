package com.github.jumpbyte.practice.queue;

import com.github.jumpbyte.practice.linklist.Node;

/**
 * 队列采用链表结构实现
 *
 * @author yuanjinan
 */
public class Queue2<T> {

    /**
     * 指向链表的头节点
     */
    private Node<T> front;
    /**
     * 指向链表的尾节点
     */
    private Node<T> rear;

    public boolean isEmpty() {
        return this.front == null;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }
        Node<T> delNode = this.front;
        if (this.front == this.rear) {
            //说明移除后，队列位置为空
            this.front = this.rear = null;
        } else {
            this.front = this.front.getNext();
        }
        T data = delNode.getData();
        delNode = null;
        return data;
    }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>();
        newNode.setData(item);
        if (this.front == null && this.rear == null) {
            this.front = newNode;
        } else {
            this.rear.setNext(newNode);
        }
        this.rear = newNode;
    }

}
