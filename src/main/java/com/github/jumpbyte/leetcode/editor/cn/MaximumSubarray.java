//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics数组 | 分治 | 动态规划 
//
// 👍 5747, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 动态规划，空间压缩，dp只用到了 i 和i-1两个值
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int dp_0 = nums[0],dp_1;
            for (int i = 1; i < nums.length; i++) {
                //要么自成一派，要么和前面的子数组合并
                dp_1 = Math.max(nums[i], nums[i]+dp_0);//状态转移方程
                dp_0 = dp_1;
                res = Math.max(res,dp_1);
            }
            return res;
        }

        /**
         * 原始动态规划 自底向上
         * @param nums
         * @return
         */
        public int maxSubArray0(int[] nums) {
            //dp[i]为以nums[i]结尾的最大连续子数组的和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            }
            int res = dp[0];
            for (int i = 1; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}