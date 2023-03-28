package com.github.jumpbyte.practice.nsum;

//在 LeetCode 上，4Sum 就到头了，但是回想刚才写 3Sum 和 4Sum 的过程，实际上是遵循相同的模式的。我相信你只要稍微修改一下 4Sum 的函数就可以复用并解决 5Sum 问题，然后解决 6Sum 问题……
//那么，如果我让你求 100Sum 问题，怎么办呢？其实我们可以观察上面这些解法，统一出一个 nSum 函数：

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuanjinan
 */
public class NSum {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 2, 2, 2 - 1, 10, 5, 6, -5};
        Arrays.sort(nums);
        List<List<Integer>> res = new NSum().nSumTarget(nums, 4, 0, 10);
        System.out.println(res);

    }

/**
 * 从数组start索引之后，找出n个数和为target的多个子数组
 * 注意：调用这个函数之前一定要先给 nums 排序
 * @param nums 排序好的数组
 * @param n n
 * @param start 索引
 * @param target 目标和
 * @return
 */
private  List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
    int sz = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    // 至少是 2Sum，且数组大小不应该小于 n
    if (n < 2 || sz < n) return res;
    // 2Sum 是 base case
    if (n == 2) {
        // 双指针那一套操作
        int lo = start, hi = sz - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                List<Integer> twoList = new ArrayList<>();
                twoList.add(left);
                twoList.add(right);
                res.add(twoList);
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
    } else {
        // n > 2 时，递归计算 (n-1)Sum 的结果
        for (int i = start; i < sz; i++) {
            List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
            for (List<Integer> itemList : sub) {
                // (n-1)Sum 加上 nums[i] 就是 nSum
                itemList.add(nums[i]);
                res.add(itemList);
            }
            while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
    return res;
}

}
