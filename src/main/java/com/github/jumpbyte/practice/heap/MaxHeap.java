package com.github.jumpbyte.practice.heap;

import java.util.Arrays;

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

    public MaxHeap() {
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
        for (; i>0 && elements[i / 2] < item; i = i / 2) {
            //如果插入位置i的父节点比插入元素值item小，则将父节点插入到i
            this.elements[i] = elements[i / 2];
        }
        //找到位置i插入
        this.elements[i] = item;
    }

    /**
     * 取出根结点（最大值）元素，同时删除堆的一个结点 复杂度：O(log2(n))
     * 说明：同最大堆的插入操作类似，同样包含n个元素的最大堆，其高度为:log2(n+1)，其时间复杂度为：O(log2(n))
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
            if (childIndex != this.size && this.elements[childIndex] < this.elements[childIndex + 1]) {
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

    /**
     * 创建一个大顶堆
     * @param items
     * @return
     */
    public MaxHeap creatMaxHeap(int[] items){
        this.elements = new int[items.length+1];
        this.capacity = items.length * 2;
        for (int i = 0; i < items.length; i++) {
            this.elements[i+1] = items[i];
             this.size++;
        }
        for (int parent = this.size/2; parent >=1; parent--) {
            shiftDown(parent,this.size);
        }
        return this;
    }

    /**
     * 下沉调整
     * @param parent 父节点位置
     * @param size 元素总个数
     */
    public  void  shiftDown(int parent,int size){
        int child = parent * 2;
        while (child <= size){
            if(child + 1 <= size && elements[child] < elements[child+1]){
                child ++;
            }
            if(elements[parent] < elements[child]){
                int tmp = elements[child];
                elements[child] = elements[parent];
                elements[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = parent * 2;
        }
    }

    private  void  heepSort(){
        int end = size;
        while (end>1){
            int tmp = elements[1];
            elements[1] = elements[end];
            elements[end] = tmp;
            end -- ;
            shiftDown(1,end);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.creatMaxHeap(new int[]{4,6,7,10,20,15,34,42,24,35,78});
        System.out.println(Arrays.toString(maxHeap.elements));
        maxHeap.heepSort();
        System.out.println(Arrays.toString(maxHeap.elements));
    }



}
