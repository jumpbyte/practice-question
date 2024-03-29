 //给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// Related Topics树 | 二叉搜索树 | 二叉树 
//
// 👍 1086, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
  package com.github.jumpbyte.leetcode.editor.cn;

 import com.github.jumpbyte.practice.ds.TreeNode;

 public class DeleteNodeInABst{
      public static void main(String[] args) {
           Solution solution = new DeleteNodeInABst().new Solution();
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val == key){
            //当前节点最多只有一个节点情况处理，替换的节点 必须是左节点中最大的或者右节点中最小的
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            //左右子节点都有的情况，需要把root替换，有两种替换方式：找左子树最大的节点或者找右子树最小的节点
            //获得右子树最小的节点
            TreeNode minNode = getMin(root.right);
            // 删除右子树最小的节点
            root.right =  deleteNode(root.right, minNode.val);;
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        if(root.val > key){
           root.left = deleteNode(root.left,key);
        }
        return root;
    }

    /**
     * 获取root右子树中值最小的节点
     * @param root
     * @return
     */
    public TreeNode getMin(TreeNode root){
        // BST 最左边的就是最小的
        while (root.left != null){
            root = root.left;
        }
        return root;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }