<p>有 <code>n</code> 个网络节点，标记为&nbsp;<code>1</code>&nbsp;到 <code>n</code>。</p>

<p>给你一个列表&nbsp;<code>times</code>，表示信号经过 <strong>有向</strong> 边的传递时间。&nbsp;<code>times[i] = (u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>)</code>，其中&nbsp;<code>u<sub>i</sub></code>&nbsp;是源节点，<code>v<sub>i</sub></code>&nbsp;是目标节点， <code>w<sub>i</sub></code>&nbsp;是一个信号从源节点传递到目标节点的时间。</p>

<p>现在，从某个节点&nbsp;<code>K</code>&nbsp;发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回&nbsp;<code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png" style="height: 220px; width: 200px;" /></p>

<pre>
<strong>输入：</strong>times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>times = [[1,2,1]], n = 2, k = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>times = [[1,2,1]], n = 2, k = 2
<strong>输出：</strong>-1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= n &lt;= 100</code></li> 
 <li><code>1 &lt;= times.length &lt;= 6000</code></li> 
 <li><code>times[i].length == 3</code></li> 
 <li><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n</code></li> 
 <li><code>u<sub>i</sub> != v<sub>i</sub></code></li> 
 <li><code>0 &lt;= w<sub>i</sub> &lt;= 100</code></li> 
 <li>所有 <code>(u<sub>i</sub>, v<sub>i</sub>)</code> 对都 <strong>互不相同</strong>（即，不含重复边）</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 最短路 | 堆（优先队列）</details><br>

<div>👍 636, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=network-delay-time" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

典型的 Dijkstra 算法应用场景，把延迟看做边的权重，最小延迟就是最小权重路径。

Dijkstra 算法模板的背景知识较多，请看详细题解。

**详细题解：[Dijkstra 算法模板及应用](https://labuladong.github.io/article/fname.html?fname=dijkstra算法)**

**标签：Dijkstra 算法，[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)，最短路径算法**

## 解法代码

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
        vector<vector<pair<int, int>>> graph(n + 1);
        for (int i = 1; i <= n; i++) {
            graph[i] = vector<pair<int, int>>();
        }
        // 构造图
        for (auto& edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            // from -> List<(to, weight)>
            // 邻接表存储图结构，同时存储权重信息
            graph[from].emplace_back(to, weight);
        }
        // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        vector<int> distTo = dijkstra(k, graph, n);

        // 找到最长的那一条最短路径
        int res = 0;
        for (int i = 1; i < distTo.size(); i++) {
            if (distTo[i] == INT_MAX) {
                // 有节点不可达，返回 -1
                return -1;
            }
            res = max(res, distTo[i]);
        }
        return res;
    }

private:
    // 输入一个起点 start，计算从 start 到其他节点的最短距离
    vector<int> dijkstra(int start, vector<vector<pair<int, int>>>& graph, int n) {
        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        vector<int> distTo(n + 1, INT_MAX);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        // 从起点 start 开始进行 BFS
        pq.emplace(0, start);

        while (!pq.empty()) {
            auto [curDistFromStart, curNodeID] = pq.top();
            pq.pop();

            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (auto& [nextNodeID, weight] : graph[curNodeID]) {
                int distToNextNode = distTo[curNodeID] + weight;
                // 更新 dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.emplace(distToNextNode, nextNodeID);
                }
            }
        }
        return distTo;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

import heapq
from typing import List

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        # 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
        graph = [[] for _ in range(n+1)]
        for edge in times:
            from_node, to_node, weight = edge[0], edge[1], edge[2]
            # from -> List<(to, weight)>
            # 邻接表存储图结构，同时存储权重信息
            graph[from_node].append((to_node, weight))
        # 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        dist_to = self.dijkstra(k, graph)

        # 找到最长的那一条最短路径
        res = 0
        for i in range(1, len(dist_to)):
            if dist_to[i] == float('inf'):
                # 有节点不可达，返回 -1
                return -1
            res = max(res, dist_to[i])
        return res

    class State:
        # 图节点的 id
        def __init__(self, id: int, dist_from_start: int):
            self.id = id
            # 从 start 节点到当前节点的距离
            self.dist_from_start = dist_from_start

        def __lt__(self, other):
            return self.dist_from_start < other.dist_from_start

    # 输入一个起点 start，计算从 start 到其他节点的最短距离
    def dijkstra(self, start: int, graph: List[List[int]]) -> List[int]:
        # 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        dist_to = [float('inf')] * len(graph)
        # base case，start 到 start 的最短距离就是 0
        dist_to[start] = 0

        # 优先级队列，distFromStart 较小的排在前面
        pq = [Solution.State(start, 0)]
        # 从起点 start 开始进行 BFS
        heapq.heapify(pq)

        while pq:
            cur_state = heapq.heappop(pq)
            cur_node_id = cur_state.id
            cur_dist_from_start = cur_state.dist_from_start

            if cur_dist_from_start > dist_to[cur_node_id]:
                continue

            # 将 cur_node 的相邻节点装入队列
            for neighbor in graph[cur_node_id]:
                next_node_id, dist_to_next_node = neighbor[0], dist_to[cur_node_id] + neighbor[1]
                # 更新 dp table
                if dist_to[next_node_id] > dist_to_next_node:
                    dist_to[next_node_id] = dist_to_next_node
                    heapq.heappush(pq, Solution.State(next_node_id, dist_to_next_node))
        return dist_to
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 构造图
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            // from -> List<(to, weight)>
            // 邻接表存储图结构，同时存储权重信息
            graph[from].add(new int[]{to, weight});
        }
        // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);

        // 找到最长的那一条最短路径
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                // 有节点不可达，返回 -1
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    class State {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        int distFromStart;

        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    // 输入一个起点 start，计算从 start 到其他节点的最短距离
    int[] dijkstra(int start, List<int[]>[] graph) {
        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int distToNextNode = distTo[curNodeID] + neighbor[1];
                // 更新 dp table
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

import (
	"container/heap"
	"math"
)

func networkDelayTime(times [][]int, n int, k int) int {
	// 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
	graph := make([][][]int, n+1)
	for i := 1; i <= n; i++ {
		graph[i] = make([][]int, 0)
	}

	// 构造图
	for _, edge := range times {
		from := edge[0]
		to := edge[1]
		weight := edge[2]
		// from -> [ [to, weight], ... ]
		// 邻接表存储图结构，同时存储权重信息
		graph[from] = append(graph[from], []int{to, weight})
	}

	// 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
	distTo := dijkstra(k, graph)

	// 找到最长的那一条最短路径
	res := 0
	for i := 1; i < len(distTo); i++ {
		if distTo[i] == math.MaxInt32 {
			// 有节点不可达，返回 -1
			return -1
		}
		res = max(res, distTo[i])
	}
	return res
}

type State struct {
	// 图节点的 id
	id int
	// 从 start 节点到当前节点的距离
	distFromStart int
}

type PriorityQueue []*State

func (pq PriorityQueue) Len() int { return len(pq) }
func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i].distFromStart < pq[j].distFromStart
}
func (pq PriorityQueue) Swap(i, j int) { pq[i], pq[j] = pq[j], pq[i] }

func (pq *PriorityQueue) Push(x interface{}) {
	item := x.(*State)
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil       // avoid memory leak
	*pq = old[0 : n-1]
	return item
}

// 输入一个起点 start，计算从 start 到其他节点的最短距离
func dijkstra(start int, graph [][][]int) []int {
	// 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
	distTo := make([]int, len(graph))
	for i := 1; i < len(graph); i++ {
		distTo[i] = math.MaxInt32
	}
	// base case，start 到 start 的最短距离就是 0
	distTo[start] = 0

	// 优先级队列，distFromStart 较小的排在前面
	pq := make(PriorityQueue, 0)
	heap.Init(&pq)
	// 从起点 start 开始进行 BFS
	heap.Push(&pq, &State{id: start, distFromStart: 0})

	for pq.Len() > 0 {
		curState := heap.Pop(&pq).(*State)
		curNodeID := curState.id
		curDistFromStart := curState.distFromStart

		if curDistFromStart > distTo[curNodeID] {
			continue
		}

		// 将 curNode 的相邻节点装入队列
		for _, neighbor := range graph[curNodeID] {
			nextNodeID := neighbor[0]
			distToNextNode := distTo[curNodeID] + neighbor[1]
			// 更新 dp table
			if distTo[nextNodeID] > distToNextNode {
				distTo[nextNodeID] = distToNextNode
				heap.Push(&pq, &State{id: nextNodeID, distFromStart: distToNextNode})
			}
		}
	}
	return distTo
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

var networkDelayTime = function(times, n, k) {
    // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
    let graph = new Array(n + 1);
    for (let i = 1; i <= n; i++) {
        graph[i] = [];
    }
    // 构造图
    for (let edge of times) {
        let from = edge[0];
        let to = edge[1];
        let weight = edge[2];
        // from -> List<(to, weight)>
        // 邻接表存储图结构，同时存储权重信息
        graph[from].push([to, weight]);
    }
    // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
    let distTo = dijkstra(k, graph);

    // 找到最长的那一条最短路径
    let res = 0;
    for (let i = 1; i < distTo.length; i++) {
        if (distTo[i] === Infinity) {
            // 有节点不可达，返回 -1
            return -1;
        }
        res = Math.max(res, distTo[i]);
    }
    return res;
};

class State {
    // 图节点的 id
    constructor(id, distFromStart) {
        this.id = id;
        // 从 start 节点到当前节点的距离
        this.distFromStart = distFromStart;
    }
}

// 输入一个起点 start，计算从 start 到其他节点的最短距离
function dijkstra(start, graph) {
    // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
    let distTo = new Array(graph.length).fill(Infinity);
    // base case，start 到 start 的最短距离就是 0
    distTo[start] = 0;

    // 优先级队列，distFromStart 较小的排在前面
    let pq = [];
    // 从起点 start 开始进行 BFS
    pq.push(new State(start, 0));
    pq.sort((a, b) => {
        return a.distFromStart - b.distFromStart;
    });

    while (pq.length > 0) {
        let curState = pq.shift();
        let curNodeID = curState.id;
        let curDistFromStart = curState.distFromStart;

        if (curDistFromStart > distTo[curNodeID]) {
            continue;
        }

        // 将 curNode 的相邻节点装入队列
        for (let neighbor of graph[curNodeID]) {
            let nextNodeID = neighbor[0];
            let distToNextNode = distTo[curNodeID] + neighbor[1];
            // 更新 dp table
            if (distTo[nextNodeID] > distToNextNode) {
                distTo[nextNodeID] = distToNextNode;
                pq.push(new State(nextNodeID, distToNextNode));
                pq.sort((a, b) => {
                    return a.distFromStart - b.distFromStart;
                });
            }
        }
    }
    return distTo;
}
```

</div></div>
</div></div>

**类似题目**：
  - [1514. 概率最大的路径 🟠](/problems/path-with-maximum-probability)
  - [1631. 最小体力消耗路径 🟠](/problems/path-with-minimum-effort)

</details>
</div>



