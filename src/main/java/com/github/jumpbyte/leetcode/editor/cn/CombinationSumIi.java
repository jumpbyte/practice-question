//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1241, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> tracks = new LinkedList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrack(candidates,0,0,target);
            return res;
        }

        void  backtrack(int[] nums,int start ,int sum,int target){
            if(sum == target){
                res.add(new ArrayList<>(tracks));
                return;
            }
            if(sum > target){
                return;
            }
            if(nums.length  == tracks.size()){
                return;
            }
            for (int i = start; i < nums.length; i++) {
                //剪枝逻辑，值相同的相邻树枝，只遍历第一条
                if(i> start && nums[i] == nums[i-1]){
                     continue;
                }
                tracks.addLast(nums[i]);
                backtrack(nums,i+1,sum+nums[i],target);
                tracks.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}