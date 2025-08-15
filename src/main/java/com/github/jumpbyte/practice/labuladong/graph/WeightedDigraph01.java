package com.github.jumpbyte.practice.labuladong.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 有向加权图，邻接表实现
 *
 * @className: WeightedDigraph01
 * @author: yuanjinan
 * @create: 2025/08/13
 **/
public class WeightedDigraph01  implements Graph{

    // 邻接表,graph[v] 存储节点 v 的所有邻居节点及对应权重
    private List<Edge>[] graph;

    public WeightedDigraph01(int vCount) {
        // 我们这里简单起见，建图时要传入节点总数，这其实可以优化
        // 比如把 graph 设置为 Map<Integer, List<Edge>>，就可以动态添加新节点了
        graph = new List[vCount];
        for (int i = 0; i < vCount; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        graph[from].add(new Edge(to,weight));
    }

    @Override
    public void removeEdge(int from, int to) {
        graph[from].removeIf(edge -> edge.getTo()== to);
    }

    @Override
    public boolean hasEdge(int from, int to) {
        return graph[from].stream().anyMatch(edge -> edge.getTo()== to);
    }

    @Override
    public int weight(int from, int to) {
        Edge edg = graph[from].stream().filter(edge -> edge.getTo() == to).findFirst().orElse(null);
        if(edg == null){
            throw new IllegalArgumentException("No such edge");
        }
        return edg.getWeight();
    }

    @Override
    public List<Edge> neighbors(int v) {
        return graph[v];
    }

    @Override
    public int size() {
        return graph.length;
    }

    public static void main(String[] args) {
        WeightedDigraph01 graph = new WeightedDigraph01(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // false

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.getTo() + ", wight: " + edge.getWeight());
        });
        // 2 -> 0, wight: 3
        // 2 -> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
    }


}
