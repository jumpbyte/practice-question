package com.github.jumpbyte.practice.array;

/**
 * 归并排序
 * @author yuanjinan
 */
public class MergeSort {

    //辅助数组
    int[] temp;

    public  void sort(int[] nums) {
        temp = new int[nums.length];
        sort(nums,0,nums.length-1);
    }

    private void  sort(int[] nums,int start,int end){
        if(start == end){
            return;
        }
        int mid = start+(end-start)/2;
        //先对左半部分nums[start,mid]排序
        sort(nums,start,mid);
        //再对右半部分nums[mid+1,end]排序
        sort(nums,mid+1,end);
        //合并左右排序好的两个数组
        merge(nums,start,mid,end);
    }

    // 将 nums[start,mid] [mid+1,end] 这两个有序数组合并成一个有序数组
    private void merge(int[] nums,int start,int mid,int end){
        //对两个有序数组nums[start,mid] [mid+1,end]进行合并,先放到临时数组
        // 以便合并后的结果能够直接存入 nums
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }
        // 数组双指针技巧，合并两个有序数组
        int i = start,j = mid+1;
        for (int p = start; p<=end;p++) {
            if (i == mid + 1) {
                // 左半边数组已全部被合并
                nums[p] = temp[j++];
            } else if (j == end + 1) {
                // 右半边数组已全部被合并
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }

}
