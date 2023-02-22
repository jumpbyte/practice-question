//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 3091, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if (n <= 0) {
                return null;
            }
            dfs("", 0, 0, n);
            return res;
        }

        /**
         * @param paths 当前字符串
         * @param left 当前左括号数量
         * @param right 当前有括号数量
         * @param n
         */
        public void dfs(String paths, int left, int right, int n) {
            if (left > n || right > left) {
                return;
            }
            if (paths.length() == 2 * n) {
                res.add(paths);
                return;
            }
            dfs(paths + "(", left + 1, right, n);
            dfs(paths + ")", left, right+1, n);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}