package com.github.jumpbyte.practice.array;

/**
 * 前缀后数组
 * @author yuanjinan
 */
public class PreSumArray {

    private int[]  preSum ;

    /**
     * 输入一个数组，构造前缀和
     * @param nums
     */
    public PreSumArray(int[] nums){
        //preSum[0]=0 便于计算累加和
        preSum = new int[nums.length+1];
        //构建前缀和 i>=1：preSum[i] 记录的是nums[0,i-1]累加和
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    /**
     * 计算区间[left,right]之间的累加和
     * @param left
     * @param right
     */
    public int  sumRange(int left ,int right){
        //注意：这里是left，right是原nums数组的下标,求[left,right]的累加和，也就是nums[0,right]累加和 - nums[0,left-1]累加和
        //因为preSum[i]记录的是nums[0,i-1]累加和，所以nums[0,right]累加和对应preSum[right+1], nums[0,left-1]累加和对应preSum[left]
        return preSum[right + 1] - preSum[left];
    }
}
