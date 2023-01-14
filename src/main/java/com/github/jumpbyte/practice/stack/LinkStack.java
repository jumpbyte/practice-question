package com.github.jumpbyte.practice.stack;

import java.util.EmptyStackException;

/**
 * 采用链表实现堆栈: 链式存储结构实际上就是一个单链表，叫做链栈，插入和删除操作只能在链栈的栈顶进行
 *
 * @author yuanjinan
 */
public class LinkStack<T> {

    StackNode<T> head;

    public LinkStack() {
        //提前构建链表头节点无实际意义，实际出栈入栈都在head.next进行
        this.head = new StackNode<>();
    }

    public void push(T item) {
        StackNode<T> node = new StackNode<>();
        node.setData(item);
        node.next = head.next;
        head.next = node;
    }

    public StackNode<T> pop() {
        if (isEmpty()) {
            System.out.println("堆栈已空");
            throw new EmptyStackException();
        }
        StackNode<T> pop = head.next;
        head.next = pop.next;
        return pop;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public static class StackNode<T> {
        T data;
        StackNode<T> next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public StackNode<T> getNext() {
            return next;
        }

        public void setNext(StackNode<T> next) {
            this.next = next;
        }
    }

}
