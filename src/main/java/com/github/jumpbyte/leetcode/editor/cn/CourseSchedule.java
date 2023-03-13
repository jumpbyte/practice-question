//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序 
//
// 👍 1528, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //记录一次 traverse 递归经过的节点
        boolean[] visited;
        //记录遍历过的节点，防止走回头路
        boolean[] onPath;
        //记录图中是否有环
        boolean hasCycle = false;

        //BFS解法
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            //记录每个节点的入度数
            int[] indegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                // 节点 to 的入度加一
                indegree[to]++;
            }
            //根据入度初始化队列中的节点
            Queue<Integer>  q = new LinkedList<>();
            for(int i=0;i<numCourses;i++){
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
            //记录节点遍历的个数
            int count=0;
            while (!q.isEmpty()){
                // 弹出节点 cur，并将它指向的节点的入度减一
                int cur = q.poll();
                count++;
                for (int next : graph[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        // 如果入度变为 0，说明 next 依赖的节点都已被遍历
                        q.offer(next);
                    }
                }
            }
            // 如果所有节点都被遍历过，说明不成环
            return count == numCourses;
        }

        //DFS版本递归遍历
        public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                // 遍历图中的所有节点
                traverse(graph, i);
            }
            return !hasCycle;
        }

        private void traverse(List<Integer>[] graph, Integer s) {
            if (onPath[s]) {
                // 出现环
                hasCycle = true;
            }
            if (visited[s] || hasCycle) {
                // 如果已经找到了环，也不用再遍历了
                return;
            }
            // 前序遍历代码位置
            visited[s] = true;
            onPath[s] = true;
            for (Integer course : graph[s]) {
                traverse(graph, course);
            }
            // 后序遍历代码位置
            onPath[s] = false;
        }

        //构建图，采用邻接表结构表示图
        private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                //构建边表示课程的依赖关系:先修完课程from才能继续修课程to
                int from = edge[1];
                int to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}