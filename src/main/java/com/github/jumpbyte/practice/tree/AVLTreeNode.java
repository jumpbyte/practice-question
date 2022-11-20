package com.github.jumpbyte.practice.tree;

/**
 * @author yuanjinan
 */
public class AVLTreeNode<T extends Comparable<T>> {

    /**
     * 值
     */
    T value;
    /**
     * 高度
     */
    int height;
    /**
     * 左孩子
     */
    AVLTreeNode<T> left;
    /**
     * 右孩子
     */
    AVLTreeNode<T> right;

    public AVLTreeNode(T val, AVLTreeNode<T> left, AVLTreeNode<T> right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public AVLTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }

    public AVLTreeNode<T> getRight() {
        return right;
    }

    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }


    @Override
    public String toString() {
        return "AVLTreeNode{" +
                "val=" + value +
                ", height=" + height +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
