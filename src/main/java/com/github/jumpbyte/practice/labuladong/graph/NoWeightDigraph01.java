package com.github.jumpbyte.practice.labuladong.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 有向无权图，邻接表实现
 *  与WeightedDigraph 类就行，把 addEdge 方法的权重参数默认设置为 1 就行了
 * @className: WeightedDigraph01
 * @author: yuanjinan
 * @create: 2025/08/13
 **/
public class NoWeightDigraph01 {

    // 邻接表,graph[v] 存储节点 v 的所有邻居节点及对应权重
    private List<Edge>[] graph;

    public NoWeightDigraph01(int vCount) {
        // 我们这里简单起见，建图时要传入节点总数，这其实可以优化
        // 比如把 graph 设置为 Map<Integer, List<Edge>>，就可以动态添加新节点了
        graph = new List[vCount];
        for (int i = 0; i < vCount; i++) {
            graph[i] = new ArrayList<>();
        }
    }


    public void addEdge(int from, int to) {
        graph[from].add(new Edge(to,1));
    }

    public void removeEdge(int from, int to) {
        graph[from].removeIf(edge -> edge.getTo()== to);
    }

    public boolean hasEdge(int from, int to) {
        return graph[from].stream().anyMatch(edge -> edge.getTo()== to);
    }


    public List<Edge> neighbors(int v) {
        return graph[v];
    }


    public int size() {
        return graph.length;
    }
}
