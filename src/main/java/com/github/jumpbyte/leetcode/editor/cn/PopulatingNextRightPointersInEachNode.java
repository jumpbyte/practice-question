 //给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
// 
//
// 示例 2: 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在
// [0, 2¹² - 1] 范围内 
// -1000 <= node.val <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 链表 | 二叉树 
//
// 👍 958, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
  package com.github.jumpbyte.leetcode.editor.cn;


 import com.github.jumpbyte.practice.ds.Node;

 import java.util.LinkedList;

 public class PopulatingNextRightPointersInEachNode{
      public static void main(String[] args) {
           Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {


    /**
     * 层序遍历
     * @param root
     * @return
     */
    public Node connect01(Node root) {
        if(root == null) return null;
        LinkedList<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            Node last =null;
            int sz=q.size();
            while (sz-->0){
                 if(last == null){
                     last = q.poll();
                 }else {
                     last.next = q.poll();
                     last = last.next;
                 }
                 if(last !=null){
                     q.offer(last.left);
                     q.offer(last.right);
                 }
            }
        }
        return root;
    }


    /**
     * 前序遍历解法，这里将二叉树抽象成3叉树
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null) return null;
        //遍历
        traverse(root.left,root.right);
        return root;
    }

    public void traverse(Node left,Node right){
        if(left == null  || right == null){
            return;
        }
        //前序位置，将传入的两个节点连起来
        left.next = right;
        //连接相同父节点的左右节点
        traverse(left.left,left.right);
        traverse(right.left,right.right);
        //连接跨越父节点的相邻左右节点
        traverse(left.right,right.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }