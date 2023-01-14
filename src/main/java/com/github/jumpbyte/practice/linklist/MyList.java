package com.github.jumpbyte.practice.linklist;

/**
 * @author yuanjinan
 */
public class MyList<T> {

    T[] list;
    int last;
    int size;


    public MyList(int size) {
        this.size = size;
        this.last = -1;
    }

    /**
     * 查找目标元素位置，返回所在对象数组下标
     *
     * @param value
     * @return
     */
    public int find(T value) {
        int i = 0;
        while (i <= this.last && list[i] != value) {
            i++;
        }
        if (i > this.last) {
            //没有找到返回-1
            return -1;
        }
        //找到返回存储位置下标
        return i;
    }

    /**
     * 插入元素
     *
     * @param i     1<i<n
     * @param value
     * @return
     */
    public boolean insert(int i, T value) {
        if (this.last == size - 1) {
            System.out.println("列表已满");
            return false;
        }
        if (i < 1 || i > this.last + 2) {
            System.out.println("插入位置不合法");
            return false;
        }

        for (int j = this.last; j >= i - 1; j--) {
            this.list[j + 1] = this.list[j];
        }
        this.list[i - 1] = value;
        this.last++;
        return true;
    }

    /**
     * 删除指定位置元素
     *
     * @param i 1<i<n
     * @return
     */
    public boolean delete(int i) {
        if (i < 1 || i > this.last + 1) {
            System.out.println("删除位置不存在");
            return false;
        }
        int j = 0;
        for (j = i - 1; j <= this.last; j++) {
            this.list[j] = this.list[j + 1];
        }
        this.last--;
        return true;
    }

    public int getLast() {
        return last;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
