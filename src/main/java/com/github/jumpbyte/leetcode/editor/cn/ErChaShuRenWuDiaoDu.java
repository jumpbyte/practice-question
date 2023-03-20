//任务调度优化是计算机性能优化的关键任务之一。在任务众多时，不同的调度策略可能会得到不同的总体执行时间，因此寻求一个最优的调度方案是非常有必要的。
//
// 通常任务之间是存在依赖关系的，即对于某个任务，你需要先完成他的前导任务（如果非空），才能开始执行该任务。我们保证任务的依赖关系是一棵二叉树，其中 
//root 为根任务，root.left 和 root.right 为他的两个前导任务（可能为空），root.val 为其自身的执行时间。 
//
// 在一个 CPU 核执行某个任务时，我们可以在任何时刻暂停当前任务的执行，并保留当前执行进度。在下次继续执行该任务时，会从之前停留的进度开始继续执行。暂停的
//时间可以不是整数。 
//
// 现在，系统有两个 CPU 核，即我们可以同时执行两个任务，但是同一个任务不能同时在两个核上执行。给定这颗任务树，请求出所有任务执行完毕的最小时间。 
//
// 示例 1： 
//
// 
// 
// 
//
// 输入：root = [47, 74, 31] 
//
// 输出：121 
//
// 解释：根节点的左右节点可以并行执行31分钟，剩下的43+47分钟只能串行执行，因此总体执行时间是121分钟。 
//
// 示例 2： 
//
// 
// 
// 
//
// 输入：root = [15, 21, null, 24, null, 27, 26] 
//
// 输出：87 
//
// 示例 3： 
//
// 
// 
// 
//
// 输入：root = [1,3,2,null,null,4,4] 
//
// 输出：7.5 
//
// 限制： 
//
// 
// 1 <= 节点数量 <= 1000 
// 1 <= 单节点执行时间 <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树 
//
// 👍 67, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import com.github.jumpbyte.practice.ds.TreeNode;

public class ErChaShuRenWuDiaoDu {
    public static void main(String[] args) {
        Solution solution = new ErChaShuRenWuDiaoDu().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * LCP 10. 二叉树任务调度
         *
         * @param root
         * @return
         */
        public double minimalExecTime(TreeNode root) {
            double[] res = execTime(root, 2);
            return res[0];
        }

        /**
         * 获取node最小执行时间
         *
         * @param node node
         * @param n    并行数
         * @return [0]执行完当前节点最小耗时，[1]当前node为根的时间串行之和
         */
        private double[] execTime(TreeNode node, int n) {
            if (node == null) {
                // [0]执行完当前节点最小耗时，[1]当前node为根的时间串行之和
                return new double[]{0.0D, 0.0D};
            }
            // 获取左右子树的值
            double[] leftTime = execTime(node.left, n);
            double[] rightTime = execTime(node.right, n);
            // 左右子树节点之和
            double sum = leftTime[1] + rightTime[1];
            // 当前节点执行完的最小消耗时间
            double minTime = Math.max(Math.max(leftTime[0], rightTime[0]), sum / n) + node.val;
            return new double[]{minTime, sum + node.val};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}