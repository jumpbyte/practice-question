package com.github.jumpbyte.practice.labuladong;


/**
 * 最小优先队列
 * 注：此队列元素下标从 0 开始
 */
public class SimpleMinPQ {
    // 底层使用数组实现二叉堆
    private final int[] heap;

    // 堆中元素的数量
    private int size;

    public SimpleMinPQ(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return heap.length;
    }

    // 父节点的索引
    private int parent(int node) {
        return (node - 1) / 2;
    }

    // 左子节点的索引  0 1 2    2*i + 1 = left   i = (node_index -1)/2
    private int left(int node) {
        return node * 2 + 1;
    }

    // 右子节点的索引
    private int right(int node) {
        return node * 2 + 2;
    }

    // 交换数组的两个元素
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 查，返回堆顶元素，时间复杂度 O(1)
    public int peek() {
        return heap[0];
    }

    // 增，向堆中插入一个元素，时间复杂度 O(logN)
    public void push(int x) {
        // 把新元素追加到最后
        heap[size] = x;
        // 然后上浮到正确位置
        swim(size);
        size++;
    }

    // 删，删除堆顶元素，时间复杂度 O(logN)
    public int pop() {
        int res = heap[0];
        // 把堆底元素放到堆顶
        heap[0] = heap[size - 1];
        size--;
        // 然后下沉到正确位置
        sink(0);
        return res;
    }

    // 上浮操作，时间复杂度是树高 O(logN)
    private void swim(int node) {
        while (node > 0 && heap[parent(node)] > heap[node]) {
            swap(parent(node), node);
            node = parent(node);
        }
    }

    // 下沉操作，时间复杂度是树高 O(logN)
    private void sink(int node) {
        while (left(node) < size || right(node) < size) {
            // 比较自己和左右子节点，看看谁最小
            int min = node;
            if (left(node) < size && heap[left(node)] < heap[min]) {
                min = left(node);
            }
            if (right(node) < size && heap[right(node)] < heap[min]) {
                min = right(node);
            }
            if (min == node) {
                break;
            }
            // 如果左右子节点中有比自己小的，就交换
            swap(node, min);
            node = min;
        }
    }




    public static void main(String[] args) {
        SimpleMinPQ pq = new SimpleMinPQ(5);
        pq.push(3);
        pq.push(2);
        pq.push(1);
        pq.push(5);
        pq.push(4);

        System.out.println(pq.pop()); // 1
        System.out.println(pq.pop()); // 2
        System.out.println(pq.pop()); // 3
        System.out.println(pq.pop()); // 4
        System.out.println(pq.pop()); // 5
    }
}