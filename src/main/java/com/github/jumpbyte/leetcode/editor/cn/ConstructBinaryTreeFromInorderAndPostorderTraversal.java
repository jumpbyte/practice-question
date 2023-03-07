 //给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 953, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
  package com.github.jumpbyte.leetcode.editor.cn;

 import com.github.jumpbyte.practice.ds.TreeNode;

 import java.util.HashMap;
 import java.util.Map;

 public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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

    //存储中序序列节点值和索引的对应关系
    Map<Integer,Integer>  map= new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }


    public TreeNode build(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd){
        if(postStart > postEnd){
            return null;
        }
        //当前的根节点值
        int rootVal = postorder[postEnd];
        //根节点在中序序列的索引下标
        int rootIndex = map.get(rootVal);

        int leftSize = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder,rootIndex - leftSize,rootIndex-1,postorder,postStart,postStart+leftSize-1);
        root.right = build(inorder,rootIndex+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }