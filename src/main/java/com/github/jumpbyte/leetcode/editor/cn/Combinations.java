//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics回溯 
//
// 👍 1286, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> tracks = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtrack(1, n, k);
            return res;
        }

        void backtrack(int start,int n, int k) {
            if(tracks.size() == k){
                //路径长度=k，说明满足k个元素的组合
                res.add(new ArrayList<>(tracks));
                return;
            }
            for (int i = start; i <= n; i++) {
                 tracks.addLast(i);
                 backtrack(i+1,n,k);
                 tracks.removeLast();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}