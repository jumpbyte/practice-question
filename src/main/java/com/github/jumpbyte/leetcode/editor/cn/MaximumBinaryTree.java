//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
// 
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics栈 | 树 | 数组 | 分治 | 二叉树 | 单调栈 
//
// 👍 639, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import com.github.jumpbyte.practice.ds.TreeNode;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree().new Solution();
        TreeNode treeNode = solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode.toString());
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return build(nums, 0, nums.length - 1);
        }

        /**
         * 定义： 构建一棵树，以nums数组start和end之间最大的数为根，将其左右部分分别作为左右子树，返回根节点
         * @param nums
         * @param start
         * @param end
         * @return
         */
        public TreeNode build(int[] nums, int start, int end) {
            if (start > end ) {
                return null;
            }
            int maxIndex = max(nums, start, end);
            TreeNode root = new TreeNode(nums[maxIndex]);
            //递归构建左子树、右子树
            root.left = build(nums, start, maxIndex - 1);
            root.right = build(nums, maxIndex + 1, end);
            return root;
        }

        /**
         * 返回nums[start - end]区间最大值的下标索引
         * @param nums
         * @param start
         * @param end
         * @return
         */
        private int max(int[] nums, int start, int end) {
            int maxI = start;
            int maxNum = nums[start];
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] > maxNum) {
                    maxNum = nums[i];
                    maxI = i;
                }
            }
            return maxI;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}