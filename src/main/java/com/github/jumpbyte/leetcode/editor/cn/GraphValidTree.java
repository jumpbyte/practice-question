package com.github.jumpbyte.leetcode.editor.cn;

//给你输入编号从0到n - 1的n个结点，和一个无向边列表edges（每条边用节点二元组表示），请你判断输入的这些边组成的结构是否是一棵树。
//
//        函数签名如下：
//
//        boolean validTree(int n, int[][] edges);

/**
 * @author yuanjinan
 */
public class GraphValidTree {

    public static void main(String[] args) {

    }

    class  Solution{

        //判定生成树 总结的规律：对于添加的这条边，如果该边的两个节点本来就在同一连通分量里，那么添加这条边会产生环；反之，如果该边的两个节点不在同一连通分量里，则添加这条边不会产生环。

        boolean validTree(int n, int[][] edges){
            // 初始化 0...n-1 共 n 个节点
            UF uf = new UF(n);
            //遍历所有边，将组成边的两个节点进行连接
            for (int[] edge : edges) {
                //若两个节点已经在同一连通分量中，会产生环
                if(uf.connected(edge[0],edge[1])){
                    return false;
                }
                //这条边不会产生环，可以是树的一部分
                uf.union(edge[0],edge[1]);
            }
            return uf.getCount() ==1;
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
