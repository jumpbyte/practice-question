package com.github.jumpbyte.practice.algorithm;

import java.util.Collections;
import java.util.List;

/**
 * 数据结构与算法之美 12节 排序:归并，快排
 * <p>
 * 练习题目
 *
 * @className: BeautyOfALG
 * @author: yuanjinan
 * @create: 2019/10/24
 **/
public class BeautyOfALG12 {


    public static void main(String[] args) {

        int[] arr = new int[]{4,3,2,5,1,8,14,13,18};

        MergeSort.mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    /**
     * 归并排序 二分治
     */
    public static class MergeSort {

        /**
         * 归并排序
         *
         * @param arr
         */
        public static   void mergeSort(int[] arr) {
            sort(arr, 0, arr.length - 1);
        }

        public static void sort(int[] arr, int l, int r) {
            if (l == r) {
                return;
            }
            int mid = l + (r - l) / 2;

            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }

        /**
         * 合并有序数组
         */
        public  static void merge(int[] arr, int l, int mid, int r) {
            int i = 0;
            int p1 = l;
            int p2 = mid + 1;

            int[] temp = new int[r - l + 1];
            // 比较左右两部分的元素，哪个小，把那个元素填入temp中
            while (p1 <= mid && p2 <= r) {
                temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            }

            //上面循环之后，看左右那边元素有剩余，就将剩余元素全部移到temp数组末尾
            while (p1 <= mid) {
                temp[i++] = arr[p1++];
            }
            while (p2 <= r) {
                temp[i++] = arr[p2++];
            }

            //合并之后将其重新复制原数组
            for (i = 0; i < temp.length; i++) {
                arr[l + i] = temp[i];
            }

        }

    }


}
