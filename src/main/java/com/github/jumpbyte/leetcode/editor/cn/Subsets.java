//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
//
// Related Topics位运算 | 数组 | 回溯 
//
// 👍 1935, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

    private List<List<Integer>> res =  new LinkedList<>();
    //记录回溯算法的递归路径 树枝
    private LinkedList<Integer> track =  new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    public void  backtrack(int[] nums,int start){
        //每次递归树枝路径 就是一个子集 加入到结果集
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
             track.addLast(nums[i]);
             backtrack(nums,i+1);
             track.removeLast();
        }
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}