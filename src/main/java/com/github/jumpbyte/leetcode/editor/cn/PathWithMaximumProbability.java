//给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b
//的一条无向边，且该边遍历成功的概率为 succProb[i] 。 
//
// 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。 
//
// 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, 
//end = 2
//输出：0.25000
//解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, 
//end = 2
//输出：0.30000
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
//输出：0.00000
//解释：节点 0 和 节点 2 之间不存在路径
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10^4 
// 0 <= start, end < n 
// start != end 
// 0 <= a, b < n 
// a != b 
// 0 <= succProb.length == edges.length <= 2*10^4 
// 0 <= succProb[i] <= 1 
// 每两个节点之间最多有一条边 
// 
//
// Related Topics图 | 数组 | 最短路 | 堆（优先队列） 
//
// 👍 118, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.*;

public class PathWithMaximumProbability {
    public static void main(String[] args) {
        Solution solution = new PathWithMaximumProbability().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            List<double[]>[] graph = buildGraph(n,edges,succProb);
            // 定义：probTo[i] 的值就是节点 start 到达节点 i 的最大概率
            double[]  probTo = new double[n];
            //初始一个取不到的值
            Arrays.fill(probTo,-1);
            //按照概率从大到小 构造最大堆
            PriorityQueue<State> pq = new PriorityQueue<>((a,b)-> Double.compare(b.probFromStart, a.probFromStart));
            //base case: start 到start 的概率为 1
            probTo[start] = 1;
            pq.offer(new State(start,1));
            while (!pq.isEmpty()){
                State curState = pq.poll();
                int curNodeID = curState.id;
                double curProbFromStart = curState.probFromStart;
                // 遇到终点提前返回
                if (curNodeID == end) {
                    return curProbFromStart;
                }

                if (curProbFromStart < probTo[curNodeID]) {
                    // 已经有一条概率更大的路径到达 curNode 节点了
                    continue;
                }
                // 将 curNode 的相邻节点装入队列
                for (double[] neighbor : graph[curNodeID]) {
                    double propToNext = probTo[curNodeID] * neighbor[1];
                    int to = (int) neighbor[0];
                    if(probTo[to] < propToNext){
                        probTo[to] = propToNext;
                        pq.offer(new State(to,propToNext));
                    }
                }
            }
            // 如果到达这里，说明从 start 开始无法到达 end，返回 0
            return -1;
        }


        List<double[]>[] buildGraph(int n,int[][] edges,double[] succProb){
            List<double[]>[] graph  = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i< edges.length;i++){
                int from = edges[i][0],to = edges[i][1];
                graph[from].add(new double[]{to,succProb[i]});
                graph[to].add(new double[]{from,succProb[i]});
            }
            return graph;
        }

        class State{
            //节点ID
            int id;
            //遍历到节点id最大成功概率
            double probFromStart;

            public State(int id, double succProbTo) {
                this.id = id;
                this.probFromStart = succProbTo;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public double getProbFromStart() {
                return probFromStart;
            }

            public void setProbFromStart(double probFromStart) {
                this.probFromStart = probFromStart;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}