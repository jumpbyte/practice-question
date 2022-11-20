package com.github.jumpbyte.practice.tree;

/**
 * 二叉树的常用操作
 *
 * @author yuanjinan
 */
public class BinTreeUsage {


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

    /**
     * 查找二叉树最大值
     *
     * @param tree
     * @return
     */
    public static TreeNode<Integer> findMax(TreeNode<Integer> tree) {
        if (tree != null) {
            while (tree.getRight() != null) {
                tree = tree.getRight();
            }
        }
        return tree;
    }

    /**
     * 二叉树中插入节点
     *
     * @return
     */
    public static TreeNode<Integer> insert(Integer x, TreeNode<Integer> tree) {
        ///若该树为空，生成并返回一个结点为一的二叉树
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

    /**
     * 从二叉树删除某个值
     *
     * @param x
     * @param tree
     * @return
     */
    public static TreeNode<Integer> delete(Integer x, TreeNode<Integer> tree) {
        if (tree == null) {
            System.out.println("树为空");
            return null;
        }
        if (x < tree.getVal()) {
            //左子树递归删除
            tree.left = delete(x, tree.left);
        } else if (x > tree.getVal()) {
            //右子树递归删除
            tree.right = delete(x, tree.right);
        } else {
            //删除的节点存在左子树和右子树，两种方案①在左子树找到最大的节点替换删除的节点 ②在右子树中找到最小的节点替换删除的节点，从而转换为只有一个子树的情况
            if (tree.getLeft() != null && tree.getRight() != null) {
                TreeNode<Integer> tmp = findMin(tree.right);
                tree.setVal(tmp.getVal());
                //在删除节点的右子树中删除最小的节点
                tree.right = delete(tmp.val, tree.right);
            } else {
                if (tree.getLeft() == null) {
                    //只有右子树
                    tree = tree.getRight();
                } else if (tree.getRight() == null) {
                    //只有左子树
                    tree = tree.getLeft();
                }
            }
        }
        return tree;
    }

    /**
     * 从二叉树删除某个值,第二种实现
     *
     * @param x
     * @param tree
     * @return
     */
    public static TreeNode<Integer> deleteV1(Integer x, TreeNode<Integer> tree) {
        if (tree == null) {
            System.out.println("树为空");
            return null;
        }
        if (x < tree.getVal()) {
            //左子树递归删除
            tree.left = deleteV1(x, tree.left);
        } else if (x > tree.getVal()) {
            //右子树递归删除
            tree.right = deleteV1(x, tree.right);
        } else {
            //删除的节点存在左子树和右子树，两种方案①在左子树找到最大的节点替换删除的节点 ②在右子树中找到最小的节点替换删除的节点，从而转换为只有一个子树的情况
            if (tree.getLeft() != null && tree.getRight() != null) {
                TreeNode<Integer> tmp = findMax(tree.left);
                tree.setVal(tmp.getVal());
                //在删除节点的左子树中删除最大的节点
                tree.left = deleteV1(tmp.val, tree.left);
            } else {
                if (tree.getRight() == null) {
                    //只有左子树
                    tree = tree.getLeft();
                } else if (tree.getLeft() == null) {
                    //只有右子树
                    tree = tree.getRight();
                }
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
        System.out.println("最小节点" + findMin(treeNode));
        System.out.println("查找节点：" + iterFind(41, treeNode));
        System.out.println("删除节点: 41 " + deleteV1(41, treeNode));
        TreeOperation.show(treeNode);
    }


}
