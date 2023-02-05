package com.github.jumpbyte.practice.tree;

import com.google.common.math.IntMath;

import java.math.RoundingMode;

/**
 * 根据一组数字例如：1 2 3 4 5 6 7 8 9 0，构建一个完全二叉搜索树
 *
 * @author yuanjinan
 */
public class TreeQuestion2 {


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        int[] b = new int[6];
        solve(a, 0, a.length - 1, b, 0);
        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    /**
     * 从排序好数组a的一段区间(left-right)找到一个正确的根节点数字填充到b数组的root下标
     *
     * @param a     排序好的数组
     * @param left  left
     * @param right right
     * @param b     要填充二叉搜索数组
     * @param root  要填充的的子树根节点下标
     */
    public static void solve(int[] a, int left, int right, int[] b, int root) {
        int n = right - left + 1;
        if (n == 0) {
            return;
        }
        //计算拥有n个节点树其左子树有多少个节点
        int count = getLeftTreeNodeCount(n);
        b[root] = a[left + count];
        //此处因为根节点索引从下标0开始 所以要 +1
        int leftRoot = 2 * root + 1;
        int rightRoot = leftRoot + 1;
        //递归解决左子树
        solve(a, left, left + count - 1, b, leftRoot);
        //递归解决右子树
        solve(a, left + count + 1, right, b, rightRoot);

    }

    /**
     * 计算拥有n个节点树其左子树有多少个节点
     *
     * @param n
     * @return
     */
    private static int getLeftTreeNodeCount(int n) {
        //完全二叉树层数
        int h = IntMath.log2(n + 1, RoundingMode.DOWN);
        //下一层的节点个数
        int x = n - IntMath.pow(2, h) + 1;
        int m = IntMath.pow(2, h - 1);
        x = Math.min(x, m);
        return IntMath.pow(2, h - 1) - 1 + x;
    }


}
