package com.github.jumpbyte.practice.linklist;

/**
 * 自定义链表
 *
 * @author yuanjinan
 */
public class MyLinkedNode<T> {

    private T data;

    MyLinkedNode<T> next;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(MyLinkedNode<T> next) {
        this.next = next;
    }

    /**
     * 求链表长度
     *
     * @return
     */
    public int length() {
        MyLinkedNode<T> node = this;
        int j = 0;
        while (node != null) {
            j++;
            node = node.next;
        }
        return j;
    }

    /**
     * 查找第k个元素
     *
     * @param k
     * @return
     */
    public MyLinkedNode<T> findKth(int k) {
        MyLinkedNode<T> p = this;
        int i = 1;
        while (i < k && p != null) {
            i++;
            p = p.next;
        }
        if (i == k) {
            return p;
        }
        return null;
    }

    /**
     * 按照值查找
     *
     * @param targetVal
     * @return
     */
    public MyLinkedNode<T> find(T targetVal) {
        MyLinkedNode<T> p = this;
        while (p != null && p.data != targetVal) {
            p = p.next;
        }
        return p;
    }

    /**
     * 在第i个位置插入元素
     *
     * @param value
     * @param i
     * @param link
     * @return
     */
    public static <T> MyLinkedNode<T> insert(T value, int i, MyLinkedNode<T> link) {
        MyLinkedNode<T> p;
        MyLinkedNode<T> newNode;
        if (i == 1) {
            newNode = new MyLinkedNode<>();
            newNode.setData(value);
            newNode.setNext(link);
            return newNode;
        }
        p = link.findKth(i - 1);
        if (p == null) {
            System.out.println("插入位置i不存在");
            return null;
        }
        newNode = new MyLinkedNode<>();
        newNode.setData(value);
        newNode.setNext(p.next);
        p.setNext(newNode);
        return newNode;
    }

    /**
     * 删除第i个位置节点
     *
     * @param i
     * @param link
     * @param <T>
     * @return
     */
    public static <T> MyLinkedNode<T> delete(int i, MyLinkedNode<T> link) {
        MyLinkedNode<T> p;
        if (i == 1) {
            p = link.next;
            link.next = null;
            return p;
        }
        p = link.findKth(i - 1);
        if (p == null) {
            System.out.println("删除位置错误");
            return null;
        } else {
            MyLinkedNode<T> s = p.next;
            p.setNext(s.next);
            s.next = null;
            return link;
        }
    }


}
