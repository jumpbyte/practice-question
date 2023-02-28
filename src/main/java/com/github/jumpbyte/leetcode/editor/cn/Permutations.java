//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 2416, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> tracks = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
            backtrack(nums);
            return res;
        }
        void backtrack(int[] nums){
            if(tracks.size() == nums.length){
                res.add(new ArrayList<>(tracks));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                 //已经走过路径不能在选择
                 if(tracks.contains(nums[i])){
                     continue;
                 }
                 //选择
                 tracks.addLast(nums[i]);
                 //递归到下一层
                 backtrack(nums);
                 //取消选择
                 tracks.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}