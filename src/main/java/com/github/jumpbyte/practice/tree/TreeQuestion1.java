package com.github.jumpbyte.practice.tree;

/**
 * 假设一个树的前序遍历顺序数组是preArr，中序遍历数组是inArr,要求计算这棵树的后序遍历数组，例如某棵树的前序遍历preArr=[1,2,3,4,5,5,6], 中序遍历数组inArr=[3,2,4,1,6,5]，求此树的后序遍历数组
 *
 * @author yuanjinan
 */
public class TreeQuestion1 {


    public static void main(String[] args) {

        int[] preArr = new int[]{1, 2, 3, 4, 5, 6};
        int[] inArr = new int[]{3, 2, 4, 1, 6, 5};
        int[] postArr = new int[6];
        solve(0, 0, 0, 6, preArr, inArr, postArr);
        for (int i : postArr) {
            System.out.print(i + " ");
        }
    }


    /**
     * 根据前序中序求后序数组
     *
     * @param preL    前序数组指针，每次递归都指向当前子树根节点
     * @param inL     中序数组指针
     * @param postL   后序数组指针
     * @param n       当前子树个节点个数
     * @param preArr  前序数组
     * @param inArr   中序数组
     * @param postArr 后序数组
     */
    public static void solve(int preL, int inL, int postL, int n, int[] preArr, int[] inArr, int[] postArr) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            postArr[postL] = preArr[preL];
            return;
        }
        int root = preArr[preL];
        postArr[postL + n - 1] = root;
        int i;
        for (i = 0; i < n; i++) {
            if (inArr[inL + i] == root) {
                break;
            }
        }
        int ln = i;
        int rn = n - ln - 1;
        solve(preL + 1, inL, postL, ln, preArr, inArr, postArr);
        solve(preL + ln + 1, inL + ln + 1, postL + ln, rn, preArr, inArr, postArr);
    }
}
