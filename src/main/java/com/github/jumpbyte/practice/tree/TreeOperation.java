package com.github.jumpbyte.practice.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yuanjinan
 */
public class TreeOperation {

     /*
        树的结构示例：
              1
            /   \
          2       3
         / \     / \
        4   5   6   7
    */


    // 用于获得树的层数
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    public static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb);
        }
    }


    /**
     * 先序遍历
     */
    public static void preVisit(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getVal());
        preVisit(root.left);
        preVisit(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void midVisit(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        midVisit(root.left);
        System.out.println(root.getVal());
        midVisit(root.right);
    }


    /**
     * 后序遍历
     *
     * @param root
     */
    public static void backVisit(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        backVisit(root.left);
        backVisit(root.right);
        System.out.println(root.getVal());
    }


    /**
     * 先序遍历(非递归)，堆栈思想
     *
     * @param root
     */
    public static void preVisitNoRecursive(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> tmpTreeNode = root;
        while (tmpTreeNode != null || !stack.isEmpty()) {
            while (tmpTreeNode != null) {
                //一直向左，并将沿途的节点压入堆栈
                System.out.println(tmpTreeNode.getVal());
                stack.push(tmpTreeNode);
                tmpTreeNode = tmpTreeNode.left;
            }
            if (!stack.isEmpty()) {
                tmpTreeNode = stack.pop();
                tmpTreeNode = tmpTreeNode.right;
            }
        }
    }

    /**
     * 中序遍历(非递归)，堆栈思想
     *
     * @param root
     */
    public static void midVisitNoRecursive(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> tmpTreeNode = root;
        while (tmpTreeNode != null || !stack.isEmpty()) {
            while (tmpTreeNode != null) {
                //一直向左，并将沿途的节点压入堆栈
                stack.push(tmpTreeNode);
                tmpTreeNode = tmpTreeNode.left;
            }
            if (!stack.isEmpty()) {
                tmpTreeNode = stack.pop();
                System.out.println(tmpTreeNode.getVal());
                //转向该节点右子树
                tmpTreeNode = tmpTreeNode.right;
            }
        }
    }

    /**
     * 后序遍历(非递归)，堆栈思想
     *
     * @param root
     */
    public static void backVisitNoRecursive(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> currentNode = root;
        //记录最近一次被访问的节点
        TreeNode<Integer> visitedNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                //一直向左，并将沿途的节点压入堆栈
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            //先拿出栈顶节点(不出栈)
            currentNode = stack.peek();
            //如果栈顶节点有右子树，且未被访问过，继续入栈右子树
            if (currentNode.right != null && currentNode.right != visitedNode) {
                currentNode = currentNode.right;
            } else {
                //子树为空或未被访问过
                //访问节点
                System.out.println(currentNode.getVal());
                //记录最近一次访问的的节点
                visitedNode = currentNode;
                //当前节点置Null防止下个循环重复入栈
                currentNode = null;
                stack.pop();
            }
        }
    }

    /**
     * 层序遍历(BFS 广度优先遍历)
     *
     * @param root
     */
    public static void levelOrderVisit(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> treeNode = queue.poll();
            System.out.println(treeNode.getVal());
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    /**
     * 二叉树的高度
     *
     * @param root
     * @return
     */
    public static Integer getHeight(TreeNode<Integer> root) {
        int lH, rH, maxH;
        if (root != null) {
            //递归求左子树的高度
            lH = getHeight(root.left);
            //递归求右子树的高度
            rH = getHeight(root.right);
            maxH = Math.max(lH, rH);
            return maxH + 1;
        }
        return 0;
    }


}
