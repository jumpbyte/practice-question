package com.github.jumpbyte.practice.labuladong.graph;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 图的通用操作 DFS | BFS
 * @className: GraphHelper
 * @author: yuanjinan
 * @create: 2025/08/14
 **/
public class GraphHelper {

    public static void traverse_dfs(Graph graph, int s , boolean[] visited){
        if(s <0 || s >= graph.size()){
            return;
        }
        if (visited[s]) {
            // 防止死循环
            return;
        }
        visited[s] = true;
        //前序位置
        System.out.println("visit "+s);
        for (Edge edge : graph.neighbors(s)){
            int to = edge.getTo();
            traverse_dfs(graph,to,visited);
        }
        //后序位置
    }

    //遍历图的边
    // 需要一个二维 visited 数组记录被遍历过的边，visited[u][v] 表示边 u->v 已经被遍历过
    public static void traverseEdges(Graph graph, int src, boolean[][] visited) {
        if(graph == null){
            return;
        }
        for (Edge edge : graph.neighbors(src)){
            if(visited[src][edge.getTo()]){
                continue;
            }
            //标记并访问
            visited[src][edge.getTo()] = true;
            System.out.println("访问边 "+ src + "->" + edge.getTo());
            traverseEdges(graph,edge.getTo(),visited);
        }
    }

    private static boolean[] onPath;
    private static List<Integer> path = new LinkedList<>();

    //获取指定to到dest的所有图的路径
    public static void getAllPaths(Graph graph, int src, int dest,AllPathResult result) {
        if(src<0 || src >= graph.size() || result==null){
            return ;
        }
        if(result.onPath[src]){
            //防止死循环
            return ;
        }
        if(src == dest){
            // 找到目标节点
            String path = Joiner.on("->").join(result.path) + "->" + dest;
            result.pathStr.add(path);
            System.out.println("find path: " + path);
            return ;
        }
        //前序位置
        result.onPath[src] = true;
        result.path.add(src);
        for (Edge edge : graph.neighbors(src)){
            getAllPaths(graph,edge.getTo(),dest,result);
        }
        //后序位置
        result.onPath[src] = false;
        result.path.remove(result.path.size()-1);
    }

    //BFS遍历 写法1 : 不记录了遍历的步数
    public static void bfs1(Graph graph, int s) {
        boolean[] visited = new boolean[graph.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.println("visit " + cur);
            for(Edge edge : graph.neighbors(cur)){
                if(visited[edge.to]){
                    continue;
                }
                queue.add(edge.to);
                visited[edge.to] = true;
            }
        }
    }

    //BFS遍历 写法2 : 记录了遍历的步数
    public void bfs2(Graph graph, int s) {
        boolean[] visited = new boolean[graph.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        // 记录从 s 开始走到当前节点的步数
        int step = 0;
        while (!queue.isEmpty()){
            //size 获取当前层的节点数，注意:size必须在for循环外获取，不能在for循环内获取，因为for循环内部会追加cur的邻居节点,改变了队列长度
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                System.out.println("visit " + cur + " at step "+ step);
                for (Edge edge : graph.neighbors(cur)) {
                    if (visited[edge.to]) {
                        continue;
                    }
                    queue.add(edge.to);
                    visited[edge.to] = true;
                }
            }
            step ++ ;
        }
    }


    //BFS遍历 写法3 :  每个节点自行维护 State 类，记录从 s 走来的遍历步数
    public void  bfs3(Graph graph, int s) {
        boolean[] visited = new boolean[graph.size()];
        LinkedList<State> queue = new LinkedList<>();
        queue.add(new State(s, 0));
        while (!queue.isEmpty()){
            State state = queue.poll();
            int step = state.step;
            int cur = state.node;
            System.out.println("visit " + cur + " with step " + step);
            for (Edge edge : graph.neighbors(cur)) {
                if (visited[edge.to]) {
                    continue;
                }
                queue.add(new State(edge.to, step + 1));
                visited[edge.to] = true;
            }
        }
    }

    public static class AllPathResult{

        public  boolean[] onPath;
        public  List<Integer> path = new LinkedList<>();

        public List<String> pathStr = new ArrayList<>();

        public AllPathResult(int n){
            onPath = new boolean[n];
        }
    }

    // 图结构的 BFS 遍历，从节点 s 开始进行 BFS，且记录遍历步数（从起点 s 到当前节点的边的条数）
    // 每个节点自行维护 State 类，记录从 s 走来的遍历步数
   public static class State {
        // 当前节点 ID
        int node;
        // 从起点 s 到当前节点的遍历步数
        int step;

        public State(int node, int step) {
            this.node = node;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        WeightedDigraph01 graph = new WeightedDigraph01(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        GraphHelper.traverse_dfs(graph,0,new boolean[graph.size()]);
        GraphHelper.traverseEdges(graph,0,new boolean[graph.size()][graph.size()]);

        WeightedDigraph01 graph1 = new WeightedDigraph01(5);
        graph1.addEdge(0, 1, 1);
        graph1.addEdge(0, 4, 1);
        graph1.addEdge(1, 2, 1);
        graph1.addEdge(1, 3, 1);
        graph1.addEdge(2, 4, 1);
        graph1.addEdge(2, 3, 1);
        graph1.addEdge(3, 2, 1);
        graph1.addEdge(3, 4, 1);
        AllPathResult result = new AllPathResult(graph1.size());
        GraphHelper.getAllPaths(graph1,0,4,result);
        System.out.println("找到所有路径："+result.pathStr);
    }

}
