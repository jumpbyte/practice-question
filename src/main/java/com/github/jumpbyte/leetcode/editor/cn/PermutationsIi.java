//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1295, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> tracks = new LinkedList<>();
        boolean[] used;
        public List<List<Integer>> permuteUnique(int[] nums) {
            //先排序，让相同的元素靠在一起
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        void backtrack1(int[] nums) {
            if (tracks.size() == nums.length) {
                res.add(new ArrayList<>(tracks));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                //已经走过路径不能在选择
                if (used[i]){
                    continue;
                }
                //新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
                if(i> 0 && nums[i] == nums[i-1] && !used[i-1]){
                    //如果前面的相邻相等元素没有用过,其实从num[i-1]->nums[i]，固定走num[i-1]的树枝，则跳过
                    continue;
                }
                //记录走过的路径
                used[i] = true;
                //选择
                tracks.addLast(nums[i]);
                //递归到下一层
                backtrack(nums);
                //取消选择
                tracks.removeLast();
                used[i] = false;
            }
        }
        void backtrack(int[] nums) {
            if (tracks.size() == nums.length) {
                res.add(new ArrayList<>(tracks));
                return;
            }
            int preNum = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                //已经走过路径不能在选择
                if (used[i]){
                    continue;
                }
                //一个节点出现相同的树枝，意味着 其子树也会长得一模一样，出现重复排列 剪掉即可
                if(preNum == nums[i]){
                    continue;
                }
                //记录走过的路径
                used[i] = true;
                //
                preNum = nums[i];
                //选择
                tracks.addLast(nums[i]);
                //递归到下一层
                backtrack(nums);
                //取消选择
                tracks.removeLast();
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}