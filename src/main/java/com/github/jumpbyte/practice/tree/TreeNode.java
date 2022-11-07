package com.github.jumpbyte.practice.tree;

/**
 * @author yuanjinan
 */
public class TreeNode<T> {

    /**
     * 值
     */
    T val;
    /**
     * 左节点
     */
    TreeNode<T> left;
    /**
     * 右节点
     */
    TreeNode<T> right;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
