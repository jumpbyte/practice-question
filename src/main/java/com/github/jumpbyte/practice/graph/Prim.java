package com.github.jumpbyte.practice.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Prim 最小生成树算法
 * @author yuanjinan
 */
public class Prim {
    // 核心数据结构，存储「横切边」的优先级队列
    private PriorityQueue<int[]> pq = new PriorityQueue<>();
    //类似 visited 数组的作用，记录哪些节点已经成为最小生成树的一部分
    private boolean[] inMST;
    //记录最小生成树的权重和
    private int weightSum = 0;

    // graph 是用邻接表表示的一幅图，
    // graph[s] 记录节点 s 所有相邻的边，
    // 三元组 int[]{from, to, weight} 表示一条边
    private List<int[]>[] graph;

    public  Prim(List<int[]>[] graph ){
        this.graph = graph;
        this.pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // 图中有 n 个节点
        int n = graph.length;
        inMST = new boolean[n];
        //切分，从下标第0个索引开始
        inMST[0] = true;
        cut(0);
        while (!pq.isEmpty()){
            int[] edge = pq.poll();
            int to = edge[1];
            if(inMST[to]){
                continue;
            }
            //将边 edge 加入最小生成树
            weightSum+= edge[2];
            inMST[to] = true;
            // 节点 to 加入后，进行新一轮切分，会产生更多横切边
            cut(to);
        }
    }

    public void cut(int v){
        // 遍历 v 的邻边
        for (int[] edge : graph[v]) {
            int to = edge[1];
             if(inMST[to]){
                 // 相邻接点 to 已经在最小生成树中，跳过
                 // 否则这条边会产生环
                 continue;
             }
             //加入横切边队列
             pq.offer(edge);
        }
    }

    public boolean isAllConnected(){
        for (int i = 0; i < inMST.length; i++) {
            if(!inMST[i]){
                return false;
            }
        }
        return true;
    }

    public int getWeightSum(){
        return weightSum;
    }


}
