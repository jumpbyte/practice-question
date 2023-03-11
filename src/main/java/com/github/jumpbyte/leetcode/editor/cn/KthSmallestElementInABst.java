 //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 711, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
  package com.github.jumpbyte.leetcode.editor.cn;

 import com.github.jumpbyte.practice.ds.TreeNode;

 public class KthSmallestElementInABst{
      public static void main(String[] args) {
           Solution solution = new KthSmallestElementInABst().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //记录结果
    int res = 0;
    //记录当前元素的排名
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }

    private void  traverse(TreeNode root, int k){
        if(root == null){
            return;
        }
        traverse(root.left,k);
        /*中序遍历 利用二叉搜索树的特性 中序遍历节点即是升序排列结果*/
        rank ++ ;
        if(rank == k){
            res = root.val;
            return;
        }
        traverse(root.right,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }