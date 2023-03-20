//有 n 个网络节点，标记为 1 到 n。
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， 
//wi 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 最短路 | 堆（优先队列） 
//
// 👍 636, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int networkDelayTime(int[][] times, int n, int k) {
            List<int[]>[] graph = buildGraph(times, n);
            //启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
            int[] minTimes = dijkstra(k-1,graph);
            // 找到最长的那一条最短路径
            int res = 0;
            for (int i = 0; i < minTimes.length; i++) {
                if (minTimes[i] == Integer.MAX_VALUE) {
                    // 有节点不可达，返回 -1
                    return -1;
                }
                res = Math.max(res, minTimes[i]);
            }
            return res;

        }


        int[] dijkstra(int start,List<int[]>[] graph){
            //定义:传递到i节点最少需要的时间是 dp[i]
            int[] dp = new int[graph.length];
            Arrays.fill(dp,Integer.MAX_VALUE);
            // base case，start 到 start 的最短时间就是 0
            dp[start] =0;
            Queue<State> pq = new PriorityQueue<>(Comparator.comparing(State::getTimesTo));
            pq.add(new State(start,0));
            while (!pq.isEmpty()){
                State cur = pq.poll();
                int timesTo = cur.getTimesTo();
                if(timesTo > dp[cur.id]){
                    //已经有信号提前时间到达cur节点
                    continue;
                }
                for (int[] node : graph[cur.id]) {
                    int timesToNext = dp[cur.id] + node[1];
                    int to = node[0];
                    //对比，可以提前时间到达 更新dp table
                    if(dp[to] > timesToNext){
                        dp[to] = timesToNext;
                        pq.offer(new State(to,timesToNext));
                    }
                }
            }
            return dp;
        }

        List<int[]>[] buildGraph(int[][] times, int n) {
            List<int[]>[] graph = new ArrayList[n];
            //使用邻接表
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : times) {
                //编号是1..n  索引从0开始
                int from = edge[0] - 1, to = edge[1] - 1;
                int time = edge[2];
                // from -> List<(to, weight)>
                // 邻接表存储图结构，同时存储权重信息
                graph[from].add(new int[]{to, time});
            }
            return graph;
        }

        class State {
            //节点id
            int id;
            //到达此节点需要消耗的时间
            int timesTo;

            public State(int id, int timesTo) {
                this.id = id;
                this.timesTo = timesTo;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getTimesTo() {
                return timesTo;
            }

            public void setTimesTo(int timesTo) {
                this.timesTo = timesTo;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}