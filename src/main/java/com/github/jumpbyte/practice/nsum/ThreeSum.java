package com.github.jumpbyte.practice.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuanjinan
 */
public class ThreeSum {


    /* 计算数组 nums 中所有和为 target 的三元组 */
    List<int[]> threeSumTarget(int[] nums, int target) {
        // 数组得排个序
        Arrays.sort(nums);
        int n = nums.length;
        List<int[]> res = new ArrayList<>();
        // 穷举 threeSum 的第一个数
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算 twoSum
            List<int[]> twoList = twoSum(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for (int[] two : twoList) {
                 int[] three = new int[]{two[0],two[1],nums[i]};
                 res.add(three);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    public List<int[]> twoSum(int[] nums,int start,int target){
        //左右指针
        int lo = start, hi = nums.length - 1;
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
        return res;
    }

}
