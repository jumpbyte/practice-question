//给你一个整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics数组 | 动态规划 | 回溯 
//
// 👍 1544, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.HashMap;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        HashMap<String, Integer> memo = new HashMap<>();

        public int findTargetSumWays(int[] nums, int target) {
            if(nums.length ==0) return 0;
            return backtrack(nums, 0, target);
        }

        /**
         *  如何凑出目标和 转化为 如何把target减到0
         *  返回遍历到树末尾是否满足remain=0，满足返回1，不满足返回0
         *  注：递归到达树的末尾时判断，剩余值为0，当前的走过路径就是一组满足要求的表达式
         *  这个版本是加入备忘录，优化递归的解法
         */
        public int backtrack(int[] nums, int i, int remain) {
            if (nums.length == i) {
                if (remain == 0) {
                    return 1;
                }
                //这里巧妙的返回0，就不用借助在外层声明result变量了，而且可以合并{+1,-1}选择的结果
                return 0;
            }
            String key = i + "," + remain;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            int result = backtrack(nums, i + 1, remain - nums[i]) + backtrack(nums, i + 1, remain + nums[i]);
            memo.put(key, result);
            return result;
        }

        int result=0;
        //回溯解法初始版本
        public void  backtrack0(int[] nums, int i, int remain){
            //回溯满足要求终止条件
            if(nums.length == i){
                if(remain == 0){
                    result ++ ;
                }
            }
            //遍历所有选择 {+1,-1}
            //做+1的选择，这里因为是剩余值，所以减去nums[i]
            remain-= nums[i];
            backtrack0(nums,i+1,remain);
            //撤销选择
            remain+=nums[i];
            //做-1的选择
            remain+=nums[i];
            backtrack0(nums,i+1,remain);
            //撤销
            remain-=nums[i];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}