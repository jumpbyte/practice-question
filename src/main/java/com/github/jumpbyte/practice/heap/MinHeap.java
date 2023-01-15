package com.github.jumpbyte.practice.heap;

/**
 * 最小堆
 *
 * @author yuanjinan
 */
public class MinHeap {

    private int[] elements;

    /**
     * 当前堆元素数量
     */
    private int size;

    /**
     * 堆的容量
     */
    private int capacity;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 最大堆
     *
     * @param capacity
     */
    public MinHeap(int capacity) {
        this.capacity = capacity;
        //最小堆 0 位置预留，从下标1开始存储元素
        this.elements = new int[capacity + 1];
        this.elements[0] = Integer.MIN_VALUE;
    }

    /**
     * 插入一个元素 复杂度 O(logN)
     * 说明：由于堆是一棵完全二叉树，存在n个元素，那么他的高度为:log2(n+1)，这就说明代码中的for循环会执行O(log2(n))次。因此插入函数的时间复杂度为：O(log2(n))
     * @param item
     */
    public void insert(int item) {
        //将元素item插入最大堆，其中elements[0]已被定义为哨兵
        int i;
        if (isFull()) {
            System.out.println("堆已满");
            return;
        }
        //i指向插入堆的最后一个元素位置下标
        i = ++this.size;
        for (; elements[i / 2] > item; i = i / 2) {
            //如果插入位置i的父节点比插入元素值item大，则i位置的父节点下去，移动到i位置
            this.elements[i] = elements[i / 2];
        }
        //找到位置i插入
        this.elements[i] = item;
    }

    /**
     * 取出根结点（最小值）元素，同时删除堆的一个结点
     * 说明：同最小堆的插入操作类似，同样包含n个元素的最小堆，其高度为:log2(n+1)，其时间复杂度为：O(log2(n))
     * @return
     */
    public int deleteMin() {
        int parentIndex, childIndex;
        int minItem, tmp;
        if (isEmpty()) {
            System.out.println("堆已空");
            return -1;
        }
        minItem = this.elements[1];
        //用最小堆中最后一个元素从根结点开始向上过滤下层结点
        tmp = this.elements[this.size--];
        for (parentIndex = 1; parentIndex * 2 <= this.size; parentIndex = childIndex) {
            //左儿子节点
            childIndex = 2 * parentIndex;
            if (childIndex != this.size && this.elements[childIndex] > this.elements[childIndex + 1]) {
                //childIndex指问左右子结点的较小者
                childIndex++;
            }
            if (tmp >= this.elements[childIndex]) {
                break;
            } else {
                this.elements[parentIndex] = this.elements[childIndex];
            }
        }
        this.elements[parentIndex] = tmp;
        return minItem;

    }

    /**
     * 判断堆是否已满
     *
     * @return
     */
    public boolean isFull() {
        return this.size == capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


}
