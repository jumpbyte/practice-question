//给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。 
//
// 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 
//val 的绝对值。 
//
// 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//输出：20
//解释：
//
//我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
//注意到任意两个点之间只有唯一一条路径互相到达。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,12],[-2,5],[-4,1]]
//输出：18
// 
//
// 示例 3： 
//
// 
//输入：points = [[0,0],[1,1],[1,0],[-1,1]]
//输出：4
// 
//
// 示例 4： 
//
// 
//输入：points = [[-1000000,-1000000],[1000000,1000000]]
//输出：4000000
// 
//
// 示例 5： 
//
// 
//输入：points = [[0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 1000 
// -10⁶ <= xi, yi <= 10⁶ 
// 所有点 (xi, yi) 两两不同。 
// 
//
// Related Topics 并查集 图 数组 最小生成树 👍 260 👎 0


package com.github.jumpbyte.leetcode.editor.cn;

import com.github.jumpbyte.practice.graph.Prim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        Solution solution = new MinCostToConnectAllPoints().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            UF uf = new UF(n);
            int minConst = 0;
            //生成所有边及权重，三元组 int[]{from, to, cost} 表示一条边
            List<int[]> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x1 = points[i][0], y1 = points[i][1];
                for (int j = i + 1; j < n; j++) {
                    int x2 = points[j][0], y2 = points[j][1];
                    int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    graph.add(new int[]{i, j, cost});
                }
            }
            //将边按照权重从小到大排序
            graph.sort(Comparator.comparing(c -> c[2]));
            for (int[] edge : graph) {
                int a = edge[0], b = edge[1];
                if (uf.connected(a, b)) {
                    //产生环 不符合树的定义
                    continue;
                }
                //若这条边不会产生环，则属于最小生成树
                minConst += edge[2];
                uf.union(a, b);
            }
            return minConst;
        }

        //解法：prim
        public int minCostConnectPoints1(int[][] points) {
            int n = points.length;
            List<int[]>[] graph = buildGraph(n, points);
            return new Prim(graph).getWeightSum();
        }

        // 构造无向图
        List<int[]>[] buildGraph(int n, int[][] points) {
            List<int[]>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }
            // 生成所有边及权重
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int xi = points[i][0], yi = points[i][1];
                    int xj = points[j][0], yj = points[j][1];
                    int weight = Math.abs(xi - xj) + Math.abs(yi - yj);
                    // 用 points 中的索引表示坐标点
                    graph[i].add(new int[]{i, j, weight});
                    graph[j].add(new int[]{j, i, weight});
                }
            }
            return graph;
        }


    }

    class UF {
        //连通分量个数
        int count;
        //x 的父节点是parents[x]
        int[] parents;
        //表示每个连通分量的'权重'
        int[] sizes;

        public UF(int n) {
            //初始化，每个节点就是一个连通集
            this.count = n;
            this.parents = new int[n];
            this.sizes = new int[n];
            for (int i = 0; i < n; i++) {
                //每个节点的父节点就是自己
                this.parents[i] = i;
                this.sizes[i] = 1;
            }
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            if (sizes[rootA] > sizes[rootB]) {
                parents[rootB] = rootA;
                sizes[rootA] += sizes[rootB];
            } else {
                parents[rootA] = rootB;
                sizes[rootB] += sizes[rootA];
            }
            this.count--;
        }

        /**
         * 查找x的父节点 路径压缩优化
         *
         * @param x
         * @return
         */
        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public boolean connected(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }

        public int getCount() {
            return this.getCount();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}