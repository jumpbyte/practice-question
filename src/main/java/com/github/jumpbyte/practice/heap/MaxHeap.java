package com.github.jumpbyte.practice.heap;

/**
 * 最大堆
 *
 * @author yuanjinan
 */
public class MaxHeap {

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
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        //最大堆 0 位置预留，从1开始存储元素
        this.elements = new int[capacity + 1];
        this.elements[0] = Integer.MAX_VALUE;
    }

    /**
     * 插入一个元素 复杂度 O(logN)
     *
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
        for (; elements[i / 2] < item; i = i / 2) {
            //如果插入位置i的父节点比插入元素值item小，则将父节点插入到i
            this.elements[i] = elements[i / 2];
        }
        //找到位置i插入
        this.elements[i] = item;
    }

    /**
     * 取出根结点（最大值）元素，同时删除堆的一个结点
     *
     * @return
     */
    public int deleteMax() {
        int parentIndex, childIndex;
        int maxItem, tmp;
        if (isEmpty()) {
            System.out.println("堆已空");
            return -1;
        }
        maxItem = this.elements[1];
        //用最大堆中最后一个元素从根结点开始向上过滤下层结点
        tmp = this.elements[this.size--];
        for (parentIndex = 1; parentIndex * 2 <= this.size; parentIndex = childIndex) {
            //左儿子节点
            childIndex = 2 * parentIndex;
            if (childIndex != this.size && this.elements[childIndex] < this.elements[parentIndex + 1]) {
                //childIndex指问左右子结点的较大者
                childIndex++;
            }
            if (tmp >= this.elements[childIndex]) {
                break;
            } else {
                this.elements[parentIndex] = this.elements[childIndex];
            }
        }
        this.elements[parentIndex] = tmp;
        return maxItem;

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
