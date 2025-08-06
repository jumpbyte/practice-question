package com.github.jumpbyte.practice.labuladong.tree;

import com.github.jumpbyte.leetcode.editor.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTest {


    public static void main(String[] args) {

        TreeNode root = TreeNode.createRoot(new Integer[]{3,9,20,23,18,15,7});
        TreeNode.show( root);
        System.out.println("前序遍历结果：");
        preVisit(root);
        System.out.println("中序遍历结果：");
        midVisit(root);
        System.out.println("后序序遍历结果：");
        backVisit(root);
        System.out.println("层序遍历结果：");
        levelOrderVisit(root);
    }


    public static void preVisit(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preVisit(root.left);
        preVisit(root.right);
    }

    private static void midVisit(TreeNode root){
        if(root == null){
            return;
        }
        midVisit(root.left);
        System.out.println(root.val);
        midVisit(root.right);
    }

    private static void backVisit(TreeNode root){
        if(root == null){
            return;
        }
        backVisit(root.left);
        backVisit(root.right);
        System.out.println(root.val);
    }

    /**
     * 层序遍历(BFS 广度优先遍历)
     * @param root
     */
    private static void levelOrderVisit(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer( root);
        while (!queue.isEmpty()){
            int sz = queue.size();
            while (sz-->0){
                TreeNode treeNode = queue.poll();
                System.out.println(treeNode.val);
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right !=null){
                    queue.offer(treeNode.right);
                }
            }
        }
    }

}
