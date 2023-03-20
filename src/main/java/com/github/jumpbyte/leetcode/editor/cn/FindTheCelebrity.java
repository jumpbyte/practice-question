package com.github.jumpbyte.leetcode.editor.cn;


//给你输入一个大小为 n x n 的二维数组（邻接矩阵） graph 表示一幅有 n 个节点的图，每个人都是图中的一个节点，编号为 0 到 n - 1。
//
//如果 graph[i][j] == 1 代表第 i 个人认识第 j 个人，如果 graph[i][j] == 0 代表第 i 个人不认识第 j 个人。
//
//有了这幅图表示人与人之间的关系，请你计算，这 n 个人中，是否存在「名人」？
//
//如果存在，算法返回这个名人的编号，如果不存在，算法返回 -1。

import java.util.LinkedList;

/**
 * 名流问题
 * @author yuanjinan
 */
public class FindTheCelebrity {

    class Solution{

        int[][] graph;

        // 可以直接调用，能够返回 i 是否认识 j
        boolean knows(int i, int j){
            return graph[i][j] == 1;
        }

        int findCelebrity(int n){
            if (n == 1) return 0;
            // 将所有候选人装进队列
            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                q.addLast(i);
            }
            // 一直排除，直到只剩下一个候选人停止循环
            while (q.size() >= 2) {
                // 每次取出两个候选人，排除一个
                int cand = q.removeFirst();
                int other = q.removeFirst();
                if (knows(cand, other) || !knows(other, cand)) {
                    // cand 不可能是名人，排除，让 other 归队
                    q.addFirst(other);
                } else {
                    // other 不可能是名人，排除，让 cand 归队
                    q.addFirst(cand);
                }
            }

            // 现在排除得只剩一个候选人，判断他是否真的是名人
            int cand = q.removeFirst();
            for (int other = 0; other < n; other++) {
                if (other == cand) {
                    continue;
                }
                // 保证其他人都认识 cand，且 cand 不认识任何其他人
                if (!knows(other, cand) || knows(cand, other)) {
                    return -1;
                }
            }
            // cand 是名人
            return cand;
        }

    }
}
