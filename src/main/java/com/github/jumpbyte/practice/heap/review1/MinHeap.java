package com.github.jumpbyte.practice.heap.review1;

/**
 * 最小堆复习 ( 下标从0开始)
 *
 * @className: MinHeap
 * @author: yuanjinan
 * @create: 2025/08/08
 **/
public class MinHeap {

    private int[] heap;
    private int size;

    public MinHeap(int cap) {
        heap = new int[cap];
        size = 0;
    }


    /**
     * 往堆中插入元素
     * @param val
     */
    public void push(int val){
        if(isFull()){
            System.out.println("堆已满");
            return;
        }
        heap[size++] = val;
        swim(size-1);
    }

    /**
     * 弹出堆中最小元素,并从堆中删除
     * @return
     */
    public int pop(){
        if(size == 0){
            System.out.println("堆已空");
            return -1;
        }
        int minVal = heap[0];
        heap[0] = heap[--size];
        sink(0);
        return minVal;
    }

    /**
     * 获取堆中元素个数
     * @return
     */
    public int size(){
        return size;
    }

    private void sink(int nodeIdx){
        while (leftChild(nodeIdx) < size || rightChild(nodeIdx) < size){
            // 比较自己和左右子节点，看看谁最小
            int minIdx = nodeIdx;
            if(leftChild(nodeIdx)  < size && heap[leftChild(nodeIdx)] < heap[minIdx]){
                minIdx = leftChild(nodeIdx);
            }
            if(rightChild(nodeIdx)  < size && heap[rightChild(nodeIdx)] < heap[minIdx]){
                minIdx = rightChild(nodeIdx);
            }
            if(minIdx == nodeIdx){
                break;
            }
            // 如果左右子节点中有比自己小的，就交换
            swap(nodeIdx,minIdx);
            nodeIdx = minIdx;
        }
    }

    private void swim(int nodeIdx){
        while (nodeIdx > 0){
            int parentIdx = parent(nodeIdx);
            if(heap[parentIdx] < heap[nodeIdx]){
                break;
            }
            swap(nodeIdx,parentIdx);
            nodeIdx = parentIdx;
        }
    }

    /**
     * 堆是否已满
     * @return
     */
    private boolean isFull(){
        return size == heap.length;
    }

    private int parent(int child){
        return (child - 1) / 2;
    }
    private int leftChild(int parent){
        return parent * 2 + 1;
    }

    private int rightChild(int parent){
        return parent * 2 + 2;
    }

    /**
     * 交换两个下标对应的元素值
     * @param i
     * @param j
     */
    private void  swap(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.push(1);
        minHeap.push(2);
        minHeap.push(30);
        minHeap.push(6);
        minHeap.push(8);
        minHeap.push(10);
        while (!minHeap.isEmpty()){
            System.out.println(minHeap.pop());
        }
    }



}
