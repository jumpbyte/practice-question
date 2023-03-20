package com.github.jumpbyte.leetcode.editor.cn;

//地图上有N座城市地图上有N座城市想象一下你是个城市基建规划者，地图上有N座城市，它们按以1到N的 次序编号。
//给你一些可连接的选项conections,其中每个选项conections[i]
//[city1,city2,cost]表示将城市city1和城市city2连接所要的
//成本为cost。(连接是双向的，也就是说城市city1和城市
//city2相连 也同样意味着城市city2和城市city1相连)。
//计算连通所有城市最小成本。如果无法连通所有城市，则请你返回-1。

import com.github.jumpbyte.practice.graph.Prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuanjinan
 */
public class ConnectingCitiesWithMinimumCost {

    public static void main(String[] args) {

    }

    class  Solution{


        //解法一：kruskal 算法
        int minimumCost(int n, int[][] connections){
            //编号从1..n, 所以uf 初始化大小n+1
            UF uf = new UF(n+1);
            //对cost进行升序排序,保证每次选费用最小的边加入mst
            Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
            //最小权重和
            int mst = 0;
            for (int[] edge : connections) {
                int a = edge[0],b=edge[1];
                if(uf.connected(a,b)){
                    //构成环了，不能加入到mst
                    continue;
                }
                mst+= edge[2];
                uf.union(a,b);
            }
            //uf有一个0节点没有使用，也会额外算一个连通分量,所以此处需要判断==2
            return uf.getCount() == 2 ? mst : -1;
        }

        //解法二:Prim算法
        int minimumCost1(int n, int[][] connections){
            List<int[]>[] graph =  buildGraph(n,connections);
            Prim prim = new Prim(graph);
            if(!prim.isAllConnected()){
                return -1;
            }
            return prim.getWeightSum();
        }

        List<int[]>[] buildGraph(int n,int[][] connections){
            //图共n个节点
            List<int[]>[] graph = new ArrayList[n];
            for(int i =0; i<n ; i++){
                graph[i] = new ArrayList<>();
            }
            for(int[] edge : connections){
                //题目给的节点编号是从 1 开始的
                //Prim算法图索引从0开始
                int u = edge[0] -1 ,v = edge[1]-1;
                int weight = edge[2];
                //无向图」其实就是「双向图」
                graph[u].add(new int[]{u,v,weight});
                graph[v].add(new int[]{v,u,weight});
            }
            return graph;
        }

    }

    class UF {
        //连通分量个数
        int count;
        //x 的父节点是parents[x]
        int[] parents ;
        //表示每个连通分量的'权重'
        int[] sizes;

        public UF(int n){
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

        void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB){
                return;
            }
            if(sizes[rootA] > sizes[rootB]){
                parents[rootB] = rootA;
                sizes[rootA] += sizes[rootB];
            }else {
                parents[rootA] = rootB;
                sizes[rootB] += sizes[rootA];
            }
            this.count --;
        }

        /**
         * 查找x的父节点 路径压缩优化
         * @param x
         * @return
         */
        int find(int x){
            if(parents[x] != x){
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public  boolean connected(int a,int b){
            int rootA = find(a);
            int rootB = find(b);
            return  rootA == rootB;
        }

        public int getCount(){
            return this.getCount();
        }

    }

}


