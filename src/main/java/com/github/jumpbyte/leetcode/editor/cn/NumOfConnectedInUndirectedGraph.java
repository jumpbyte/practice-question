package com.github.jumpbyte.leetcode.editor.cn;


//给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。请你计算这幅图的连通分量个数。

/**
 * @author yuanjinan
 */
public class NumOfConnectedInUndirectedGraph {

    public static void main(String[] args) {

    }

    class Solution {

        int countComponents(int n, int[][] edges) {
            UF uf = new UF(n);
            for (int[] edge : edges) {
                uf.union(edge[0],edge[1]);
            }
            return uf.getCount();
        }

    }

    class UF {
        private int count;
        private int[] parents;

        public UF(int n) {
            count = n;
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB){
                return;
            }
            parents[rootA] = rootB;
            //两个连通分量合并成一个连通分量
            count--;
        }

        public int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public boolean connected(int a,int b) {
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }

        public int getCount() {
            return count;
        }
    }

}
