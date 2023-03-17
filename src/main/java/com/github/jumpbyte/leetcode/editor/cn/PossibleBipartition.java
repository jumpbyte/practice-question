//给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
//
// 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和 bi的人归入同一组。当可以用
//这种方法将所有人分进两组时，返回 true；否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
//输出：true
//解释：group1 [1,4], group2 [2,3]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2000 
// 0 <= dislikes.length <= 10⁴ 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= n 
// ai < bi 
// dislikes 中每一组都 不同 
// 
//
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 图 
//
// 👍 365, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition {
    public static void main(String[] args) {
        Solution solution = new PossibleBipartition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 记录图是否符合二分图性质
        boolean[] visited;
        // 记录图中节点的颜色，false 和 true 代表两种不同颜色
        boolean[] colors;
        // 记录图中节点是否被访问过
        boolean ok = true;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            List<Integer>[] graph = buildGraph(dislikes, n);
            colors = new boolean[n];
            visited = new boolean[n];
            // 因为图不一定是联通的，可能存在多个子图
            // 所以要把每个节点都作为起点进行一次遍历
            // 如果发现任何一个子图不是二分图，整幅图都不算二分图
            for (int v = 0; v < n; v++) {
                 if(!visited[v]){
                     traverse(graph,v);
                 }
            }
            return ok;
        }

        private void traverse(List<Integer>[] graph,Integer v){
            if(!ok){
                return ;
            }
            visited[v] = true;
            for (Integer w : graph[v]) {
                if(!visited[w]){
                    visited[w] = true;
                    colors[w] = !colors[v];
                    traverse(graph,w);
                }else {
                    if (colors[w] == colors[v]) {
                        ok = false;
                        return;
                    }
                }
            }
        }

        public List<Integer>[] buildGraph(int[][] dislikes, int n){
            List<Integer>[] graph = new ArrayList[n];
            //编号从1开始，graph[i] 存储编号i-1的顶点
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] edge : dislikes) {
                 int from  = edge[0]-1,to = edge[1]-1;
                 //双向图
                graph[from].add(to);
                graph[to].add(from);
            }
            return graph;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}