package com.github.jumpbyte.practice.graph;

/**
 * @author yuanjinan
 */
public class MGraph {

    /**
     * 顶点数
     */
    private int vCount;
    /**
     * 边数
     */
    private int eCount;

    /**
     * 边集合，值就是边的权重，权重>0则认为有边
     */
    private int[][] edges;


    /**
     * 存放每个顶点的数据(如有)
     */
    private Object[] data;


    public MGraph(int vCount, int eCount) {
        this.vCount = vCount;
        this.eCount = eCount;
        edges = new int[vCount][vCount];
        data = new Object[vCount];
    }

    /**
     * 插入边
     *
     * @param eNode
     */
    public void insertEdge(ENode eNode) {
        edges[eNode.v1][eNode.v2] = eNode.weight;
        //若为无向图还需插入一个v2-v1的边
        edges[eNode.v2][eNode.v1] = eNode.weight;
    }


    public static class ENode {

        private int v1, v2;//有向边 v1->v2
        private int weight;//权重值

        public ENode(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public int getV1() {
            return v1;
        }

        public void setV1(int v1) {
            this.v1 = v1;
        }

        public int getV2() {
            return v2;
        }

        public void setV2(int v2) {
            this.v2 = v2;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
