//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics数组 | 二分查找 | 动态规划 | 排序 
//
// 👍 867, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import com.google.common.collect.Comparators;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int maxEnvelopes(int[][] envelopes) {
            //按照宽度w升序，相同宽度w时按照高度h降序
            Arrays.sort(envelopes,(a,b)->{
                if(a[0]==b[0]) {
                    //相同宽度w时按照高度h降序 可以保证 高度选择最高的一个
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            });
           int[] heights  = new int[envelopes.length];
            for (int i = 0; i < envelopes.length; i++) {
                heights[i] = envelopes[i][1];
            }
            //因为w已经升序，确保了 w 这个维度可以互相嵌套，问题转换为对其所以信封高度数组求最长递增子序列的长度
            return lengthOfLIS(heights);
        }


        public int lengthOfLIS(int[] heights) {
            //定义：dp[i] 表示以 heights[i] 这个数结尾的最长递增子序列的长度
            int[] dp = new int[heights.length];
            // base case：dp 数组全都初始化为 1 ,因为每个nums[i]结尾的最长子序列至少要包括自己
            Arrays.fill(dp, 1);
            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j < i; j++) {
                    //寻找 heights[0..j-1] 中比 heights[i] 小的元素
                    if (heights[i] > heights[j]) {
                        // 把 heights[i] 接在后面，即可形成长度为 dp[j] + 1，
                        // 且以 heights[i] 为结尾的递增子序列
                        dp[i] = Math.max(dp[i], 1 + dp[j]);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}