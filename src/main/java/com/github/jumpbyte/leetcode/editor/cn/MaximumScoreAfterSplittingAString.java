//给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）
// 所能获得的最大得分。
//
//
// 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。 
//
// 
//
// 示例 1： 
//
// 输入：s = "011101"
//输出：5 
//解释：
//将字符串 s 划分为两个非空子字符串的可行方案有：
//左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5 
//左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4 
//左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3 
//左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2 
//左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
// 
//
// 示例 2： 
//
// 输入：s = "00111"
//输出：5
//解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 500 
// 字符串 s 仅由字符 '0' 和 '1' 组成。 
// 
// Related Topics 字符串 👍 65 👎 0


package com.github.jumpbyte.leetcode.editor.cn;

public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        Solution solution = new MaximumScoreAfterSplittingAString().new Solution();
        System.out.println(solution.maxScore("011101"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 常规解法
         *
         * @param s
         * @return
         */
        public int maxScore1(String s) {
            char[] chars = s.toCharArray();
            int maxScore = 0;
            for (int i = 0; i < chars.length; i++) {
                int score = 0;
                if (i == 0) {
                    continue;
                }
                for (int l = 0; l < i; l++) {
                    if (chars[l] == '0') {
                        score = score + 1;
                    }
                }
                for (int r = i; r < chars.length; r++) {
                    if (chars[r] == '1') {
                        score = score + 1;
                    }
                }
                maxScore = Math.max(maxScore, score);
            }
            return maxScore;
        }

        /**
         * 优化：使用dp避免重复计算
         *
         * @param s
         * @return
         */
        public int maxScore(String s) {
            char[] chars = s.toCharArray();
            int maxScore = 0;
            int[] dpLeft = new int[chars.length];
            int[] dpRight = new int[chars.length];
            dpLeft[0] = chars[0] == '0' ? 1 : 0;
            int maxIndex = chars.length - 1;
            dpRight[maxIndex] = chars[maxIndex] == '1' ? 1 : 0;
            for (int i = 1; i < maxIndex; i++) {
                dpLeft[i] = chars[i] == '0' ? dpLeft[i - 1] + 1 : dpLeft[i - 1];
            }
            for (int j = maxIndex - 1; j > 0; j--) {
                dpRight[j] = chars[j] == '1' ? dpRight[j + 1] + 1 : dpRight[j + 1];
            }
            for (int i = 0; i < maxIndex; i++) {
                maxScore = Math.max(maxScore, dpLeft[i] + dpRight[i + 1]);
            }
            return maxScore;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}