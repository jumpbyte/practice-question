package com.github.jumpbyte.practice.nsum;


//如果假设输入一个数组nums和一个目标和target，请你返回nums中能够凑出target的两个元素的值，比如输入nums = [5,3,1,6], target = 9，
//那么算法返回两个元素[3,6]。可以假设只有且仅有一对儿元素可以凑出target。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuanjinan
 */
public class TwoSum {

    /**
     * nums数组只有一对目标元素和为target数组
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum0(int[] nums,int target){
        // 先对数组排序
        Arrays.sort(nums);
        //左右指针
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // 根据 sum 和 target 的比较，移动左右指针
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else if (sum == target) {
                return new int[]{nums[lo], nums[hi]};
            }
        }
        return new int[]{};
    }

    /**
     * nums数组可能有多对目标元素和为target数组,nums可能有重复元素
     * @param nums
     * @param target
     * @return
     */
    public int[][] twoSum1(int[] nums,int target){
        // 先对数组排序
        Arrays.sort(nums);
        //左右指针
        int lo = 0, hi = nums.length - 1;
        List<int[]> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                //重复的元素跳过，反正和也不会满足target
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                //重复的元素跳过，反正和也不会满足target
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                res.add(new int[]{left, right});
                //重复的元素跳过，避免出现结果重复的二元组
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res.toArray(new int[0][0]);
    }


}
