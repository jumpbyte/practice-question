package com.github.jumpbyte.practice.linklist;

/**
 * 链表节点
 *
 * @author yuanjinan
 */
public class Node<T> {

    private T data;

    private Node<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
