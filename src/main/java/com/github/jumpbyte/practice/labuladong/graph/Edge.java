package com.github.jumpbyte.practice.labuladong.graph;

/**
 * 图的边
 * @className: Edge
 * @author: yuanjinan
 * @create: 2025/08/13
 **/
public class Edge {

    public int to;
    public int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
