package com.github.jumpbyte.practice.stack;

import java.util.EmptyStackException;

/**
 * 采用对象数组实现的堆栈
 * 栈的顺序存储结构通常是由一个一维数组和一个记录栈顶元素位置的变量组成
 *
 * @author yuanjinan
 */
public class ArrayStack<T> {
    //元素列表
    Object[] data;
    //指向当前栈顶元素下标位置
    int top;
    //堆栈元素容量
    int size;

    public ArrayStack(int size) {
        this.size = size;
        data = new Object[size];
        this.top = -1;
    }

    public boolean push(T item) {
        if (isFull()) {
            System.out.println("堆栈已满");
            return false;
        }
        this.data[++this.top] = item;
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("堆栈已空");
            throw new EmptyStackException();
        }
        return (T) this.data[this.top--];
    }

    public boolean isFull() {
        return this.size - 1 == this.top;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }


    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(3);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}
