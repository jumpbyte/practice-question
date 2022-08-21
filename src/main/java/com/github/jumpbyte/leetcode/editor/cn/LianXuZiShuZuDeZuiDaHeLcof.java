//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 👍 590 👎 0


package com.github.jumpbyte.leetcode.editor.cn;

public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-1, -2, 1, 2, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray1(int[] nums) {
            if (nums == null) {
                return 0;
            }
            //记录最大和
            int maxSum = 0;
            //记录当前实时最大和
            int thisSum = 0;
            //数组中最大值
            int maxNum = nums[0];
            boolean flag = false;
            for (int i = 0; i < nums.length; i++) {
                thisSum += nums[i];
                maxNum = Math.max(maxNum, nums[i]);
                //如果当前最大和比之前记录的maxSum要大，则更新maxSum
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                    flag = true;
                } else if (thisSum < 0) {
                    //如果当前子数组和为负数，则不可能使后边的和更大，重新归0，抛弃此子数组
                    thisSum = 0;
                }
            }
            if (!flag) {
                return maxNum;
            }
            return maxSum;
        }


        /**
         * 动态规划 1 解法
         *
         * @param nums
         * @return
         */
        public int maxSubArrayByDp1(int[] nums) {
            int res = nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (dp[i - 1] <= 0) {
                    dp[i] = nums[i];
                    res = Math.max(res, dp[i]);
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                    res = Math.max(res, dp[i]);
                }
            }
            return res;
        }

        /**
         * 动态规划 2 优化，复用nums数组
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                nums[i] += Math.max(nums[i - 1], 0);
                res = Math.max(res, nums[i]);
            }
            return res;
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

}