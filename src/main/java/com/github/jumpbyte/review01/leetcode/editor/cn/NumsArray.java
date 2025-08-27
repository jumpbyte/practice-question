package com.github.jumpbyte.review01.leetcode.editor.cn;


/**
 * 前缀和数组
 */
public class NumsArray {


    // preSums[i] 表示 nums[0..i-1] 的和(i>0)
    private  int[] preSums;

    public NumsArray(int[] nums) {
        // preSum[0] = 0，便于计算累加和
        preSums = new int[nums.length + 1];
        preSums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            preSums[i] = preSums[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return preSums[j + 1] - preSums[i];
    }

}
