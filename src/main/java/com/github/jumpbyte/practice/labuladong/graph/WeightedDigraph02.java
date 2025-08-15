package com.github.jumpbyte.practice.labuladong.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 有向加权图，矩阵实现
 *
 * @className: WeightedDigraph02
 * @author: yuanjinan
 * @create: 2025/08/13
 **/
public class WeightedDigraph02 implements Graph{

    // 邻接矩阵，matrix[i][j]表示i到j的边的权重,为0表示无边
    private int[][] matrix;

    @Override
    public void addEdge(int from, int to, int weight) {
        matrix[from][to] = weight;
    }

    @Override
    public void removeEdge(int from, int to) {
        matrix[from][to] = 0;
    }

    @Override
    public boolean hasEdge(int from, int to) {
        return matrix[from][to] != 0;
    }

    @Override
    public int weight(int from, int to) {
        return matrix[from][to];
    }

    @Override
    public List<Edge> neighbors(int v) {
        List<Edge> neighbors = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[v][i] != 0) {
                neighbors.add(new Edge(i,matrix[v][i]));
            }
        }
        return neighbors;
    }

    @Override
    public int size() {
        return matrix.length;
    }
}
