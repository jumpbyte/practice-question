package com.github.jumpbyte.practice.labuladong;


/**
 * 后缀最小值
 */
public class SuffixMin {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 2, 5, 9, 7, 6, 8};
        int[] suffixMin = new SuffixMin().getSuffixMin(nums);
        // 有了 suffixMin 数组，可以在 O(1) 时间内查询任意 nums[i...] 后缀的最小值
        System.out.println(suffixMin[7]);

    }

    public int[] getSuffixMin(int[] nums) {
        int[] suffixMin = new int[nums.length];
        //suffixMin[i] 表示 nums[i..] 中的最小值
        suffixMin[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i],suffixMin[i+1]);
        }
        return suffixMin;
    }
}
