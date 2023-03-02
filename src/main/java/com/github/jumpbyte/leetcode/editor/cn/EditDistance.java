//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 2801, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * dp 解法 自底向上求解
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance(String word1, String word2) {
            int m  = word1.length() ,n = word2.length();
            //定义：s1[0..i] 和 s2[0..j] 的最小编辑距离是 dp[i+1][j+1]
            int[][] dp = new int[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
            // 自底向上求解
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        //做选择 取插入 删除 替换操作步数最小的
                        dp[i][j] = min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + 1
                        );
                    }
                }
            }
            // 储存着整个 s1 和 s2 的最小编辑距离
            return dp[m][n];
        }

        //备忘录
        int[][] memo;
        /**
         * 递归 dp 解法 ，自顶向下求解
         * @param word1
         * @param word2
         * @return
         */
        public int minDistanceRecursion(String word1, String word2) {
            int m  = word1.length() ,n = word2.length();
            memo = new int[m][n];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dp(word1,m-1,word2,n-1);
        }

        /**
         *  定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
         * @param s1
         * @param i
         * @param s2
         * @param j
         * @return
         */
        public int dp(String s1,int i,String s2,int j){
            if(i== -1) {
                 //说明s1走完了 可把剩下的s2字符一个个插入到s1中即可 所以需要j+1步插入操作
                return j+1;
            }
            if(j==-1){
                //说明s2走完了 可把剩下的s1字符一个个删除即可，所以需要i+1步删除操作
                return i+1;
            }
            if(memo[i][j] != -1){
                //已经计算过的 直接返回
                return memo[i][j];
            }
            //如果i,j位置字符相等 什么也不做，所以 dp[i][j] 就是dp[i-1][j-1]
            if(s1.charAt(i) == s2.charAt(j)){
                memo[i][j] = dp(s1,i-1,s2,j-1);
            }else {
                //做选择 取插入 删除 替换操作步数最小的
                memo[i][j] =  min(
                        dp(s1,i,s2,j-1)+1,
                        dp(s1,i-1,s2,j)+1,
                        dp(s1,i-1,s2,j-1)+1);
            }
            return memo[i][j];
        }

        private int min(int x,int y,int z){
            return Math.min(x,Math.min(y,z));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}