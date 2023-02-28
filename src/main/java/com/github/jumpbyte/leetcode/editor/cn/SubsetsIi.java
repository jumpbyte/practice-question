//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 1031, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            //先排序保证重复的元素挨在一起
            Arrays.sort(nums);
            backtrack(nums,0);
            return res;
        }

        void backtrack(int[] nums , int start){
            // 前序位置，每个节点的值都是一个子集
            res.add(new ArrayList<>(track));
            for (int i = start; i < nums.length; i++) {
                // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
                if(i> start && nums[i] == nums[i-1]){
                    continue;
                }
                track.addLast(nums[i]);
                backtrack(nums,i+1);
                track.removeLast();
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}