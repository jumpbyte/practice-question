//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序 
//
// 👍 746, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.*;

public class CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //BFS版本实现
        public int[] findOrder(int numCourses, int[][] prerequisites){
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            //记录每个节点的入度数
            int[] indegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                // 节点 to 的入度加一
                indegree[to]++;
            }
            //根据入度初始化队列中的节点
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<numCourses;i++){
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
            //记录遍历节点的顺序（索引）
            int count=0;
            //记录访问过的节点
            int[] res = new int[numCourses];
            while (!q.isEmpty()){
                // 弹出节点 cur，并将它指向的节点的入度减一
                int cur = q.poll();
                res[count] = cur;
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
            if(count != numCourses){
                return  new int[0];
            }
            return res;
        }



        private boolean[] onPath;
        private boolean[] visited;
        private boolean hasCycle;
        //后序遍历 记录课程
        private List<Integer> postorder = new ArrayList<>();
        //DFS版本实现
        public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];
            for (int i = 0; i < numCourses; i++) {
                traverse(graph, i);
            }
            //是否含有环
            if (hasCycle) {
                return new int[0];
            }
            //此处需要再进行逆序，因为后序遍历最后加入的课程是在集合末尾，但其实是最先要完成的课程
            Collections.reverse(postorder);
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = postorder.get(i);
            }
            return res;
        }

        private void traverse(List<Integer>[] graph, Integer s) {
            if (onPath[s]) {
                hasCycle = true;
            }
            if (visited[s] || hasCycle) {
                //访问过或者存在环
                return;
            }
            visited[s] = true;
            onPath[s] = true;
            for (Integer course : graph[s]) {
                traverse(graph, course);
            }
            postorder.add(s);
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