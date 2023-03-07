package com.github.jumpbyte.practice.array;

/**
 * 快排
 * @author yuanjinan
 */
public class QuickSort {

    // 排序数组nums
    void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        /****** 前序位置 ******/
        // 对nums[start...end]进行切分
        // 使得nums[start...p-1] <= nums[p] < nums[p+1..end]
        int p = partition(nums, start, end);
        /*********************/
        //剩下p元素的左右部分元素在进行排序
        sort(nums, start, p - 1);
        sort(nums, p + 1, end);
    }

    // 对nums[start...end]进行切分
    int partition(int[] nums, int start, int end) {
        // 取第一个位置的元素作为基准元素
        int pivot = nums[start];
        // 这里把left, right定义为开区间
        // 同时定义 [start, left) <= pivot; (right, end] > pivot
        // 之后都要正确维护这个边界区间的定义
        int left = start + 1;
        int right = end;

        // 当left > right时结束循环 以保证区间[start, end]都被覆盖
        while(left <= right) {
            //找到一个比pivot大的一个索引left停止
            while(left < end && nums[left] <= pivot) {
                left++;
                // 此while循环结束时 恰好 nums[left] > pivot
            }
            //找到一个比pivot小的索引right停止
            while(right > start && nums[right] > pivot) {
                right--;
                // 此while循环结束时 恰好 nums[right] <= pivot
            }
            // 此时[start, left) <= pivot && (right, end] > pivot
            if (left >= right) {
                break;
            }
            //将找到的left和right索引位置的元素进行互换，保证[start, left)都是比pivot小的，(right, end]元素都是比pivot大的
            swap(nums, left, right);
        }
        // 将pivot放到合适的位置 即pivot左边元素较小 右边元素较大
        swap(nums, start, right);
        return right;
    }


    void  swap(int[] nums , int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    
}
