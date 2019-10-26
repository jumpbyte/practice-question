package com.github.jumpbyte.practice.algorithm;

/**
 * 数据结构与算法之美 11节 排序:冒泡，插入，选择
 * <p>
 * 练习题目
 *
 * @className: BeautyOfALG
 * @author: yuanjinan
 * @create: 2019/10/24
 **/
public class BeautyOfALG11 {

    public void bubbleSort(int[] nums, int n) {

        if (n <= 1) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 提前退出循环的标志
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    //交换
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    //标识有数据发生交换
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

    }

    // 插入排序，a表示数组，n表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return ;
        }
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            //插入数据
            a[j+1] = value;
        }
    }
}
