package com.github.jumpbyte.practice.tree;

/**
 * @author yuanjinan
 */
public class Test1 {


    /**
     * 二叉树搜索查找（递归查找）
     *
     * @param value
     * @param treeNode
     * @return
     */
    public static TreeNode<Integer> find(Integer value, TreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (value > treeNode.getVal()) {
            return find(value, treeNode.getRight());
        } else if (value < treeNode.getVal()) {
            return find(value, treeNode.getLeft());
        } else {
            return treeNode;
        }
    }

    /**
     * 二叉树搜索查找 优化
     *
     * @param value
     * @param treeNode
     * @return
     */
    public static TreeNode<Integer> iterFind(Integer value, TreeNode<Integer> treeNode) {
        while (treeNode != null) {
            if (value > treeNode.getVal()) {
                treeNode = treeNode.getRight();
            } else if (value < treeNode.getVal()) {
                treeNode = treeNode.getLeft();
            }
            return treeNode;
        }
        return null;
    }

    /**
     * 查找二叉树中最小值
     *
     * @param tree
     * @return
     */
    public static TreeNode<Integer> findMin(TreeNode<Integer> tree) {
        if (tree == null) {
            return null;
        }
        if (tree.getLeft() == null) {
            return tree;
        } else {
            return findMin(tree.getLeft());
        }
    }

    public static TreeNode<Integer> findMax(TreeNode<Integer> tree) {
        if (tree != null) {
            while (tree.getRight() != null) {
                tree = tree.getRight();
            }
        }
        return tree;
    }

    public static TreeNode<Integer> insert(Integer x, TreeNode<Integer> tree) {
        if (tree == null) {
            TreeNode<Integer> newNode = new TreeNode<>();
            newNode.setVal(x);
            tree = newNode;
        } else {
            if (x < tree.getVal()) {
                TreeNode<Integer> leftNode = insert(x, tree.getLeft());
                tree.setLeft(leftNode);
            } else if (x > tree.getVal()) {
                TreeNode<Integer> rightNode = insert(x, tree.getRight());
                tree.setRight(rightNode);
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        int[] data = new int[]{30, 15, 41, 33, 50, 35};
        TreeNode<Integer> treeNode = null;
        for (int num : data) {
            treeNode = insert(num, treeNode);
        }
        TreeOperation.show(treeNode);
        System.out.println("最大节点" + findMax(treeNode));
    }


}
