<p>你准备参加一场远足活动。给你一个二维&nbsp;<code>rows x columns</code>&nbsp;的地图&nbsp;<code>heights</code>&nbsp;，其中&nbsp;<code>heights[row][col]</code>&nbsp;表示格子&nbsp;<code>(row, col)</code>&nbsp;的高度。一开始你在最左上角的格子&nbsp;<code>(0, 0)</code>&nbsp;，且你希望去最右下角的格子&nbsp;<code>(rows-1, columns-1)</code>&nbsp;（注意下标从 <strong>0</strong> 开始编号）。你每次可以往 <strong>上</strong>，<strong>下</strong>，<strong>左</strong>，<strong>右</strong>&nbsp;四个方向之一移动，你想要找到耗费 <strong>体力</strong> 最小的一条路径。</p>

<p>一条路径耗费的 <strong>体力值</strong>&nbsp;是路径上相邻格子之间 <strong>高度差绝对值</strong>&nbsp;的 <strong>最大值</strong>&nbsp;决定的。</p>

<p>请你返回从左上角走到右下角的最小<strong>&nbsp;体力消耗值</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/25/ex1.png" style="width: 300px; height: 300px;" /></p>

<pre>
<b>输入：</b>heights = [[1,2,2],[3,8,2],[5,3,5]]
<b>输出：</b>2
<b>解释：</b>路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/25/ex2.png" style="width: 300px; height: 300px;" /></p>

<pre>
<b>输入：</b>heights = [[1,2,3],[3,8,4],[5,3,5]]
<b>输出：</b>1
<b>解释：</b>路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
</pre>

<p><strong>示例 3：</strong></p> 
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/10/25/ex3.png" style="width: 300px; height: 300px;" /> 
<pre>
<b>输入：</b>heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
<b>输出：</b>0
<b>解释：</b>上图所示路径不需要消耗任何体力。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>rows == heights.length</code></li> 
 <li><code>columns == heights[i].length</code></li> 
 <li><code>1 &lt;= rows, columns &lt;= 100</code></li> 
 <li><code>1 &lt;= heights[i][j] &lt;= 10<sup>6</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 二分查找 | 矩阵 | 堆（优先队列）</details><br>

<div>👍 341, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=path-with-minimum-effort" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

如果你把二维数组中每个 `(x, y)` 坐标看做一个节点，它的上下左右坐标就是相邻节点，它对应的值和相邻坐标对应的值之差的绝对值就是题目说的「体力消耗」，你就可以理解为边的权重。

这样就可以使用 Dijkstra 算法求解了，只不过这道题中评判一条路径是长还是短的标准不再是路径经过的权重总和，而是路径经过的权重最大值。

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
    // Dijkstra 算法，计算 (0, 0) 到 (m - 1, n - 1) 的最小体力消耗
    int minimumEffortPath(vector<vector<int>>& heights) {
        int m = heights.size(), n = heights[0].size();
        // 定义：从 (0, 0) 到 (i, j) 的最小体力消耗是 effortTo[i][j]
        vector<vector<int>> effortTo(m,vector<int>(n, INT_MAX)); // dp table 初始化为正无穷
        // base case，起点到起点的最小消耗就是 0
        effortTo[0][0] = 0;

        // 优先级队列，effortFromStart 较小的排在前面
        priority_queue<State,vector<State>,Comp> pq; // 第二个参数就是自定义语法格式，详见下方
        // 从起点 (0, 0) 开始进行 BFS
        pq.push(State(0, 0, 0));

        while (!pq.empty()) {
            State curState = pq.top();
            pq.pop();
            int curX = curState.x;
            int curY = curState.y;
            int curEffortFromStart = curState.effortFromStart;

            // 到达终点提前结束
            if (curX == m - 1 && curY == n - 1) {
                return curEffortFromStart;
            }

            if (curEffortFromStart > effortTo[curX][curY]) {
                continue;
            }
            // 将 (curX, curY) 的相邻坐标装入队列
            for (auto& neighbor : adj(heights, curX, curY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                // 计算从 (curX, curY) 达到 (nextX, nextY) 的消耗
                int effortToNextNode = max(
                    effortTo[curX][curY],
                    abs(heights[curX][curY] - heights[nextX][nextY])
                );
                // 更新 dp table
                if (effortTo[nextX][nextY] > effortToNextNode) {
                    effortTo[nextX][nextY] = effortToNextNode;
                    pq.push(State(nextX, nextY, effortToNextNode));
                }
            }
        }
        // 正常情况不会达到这个 return
        return -1;
    }

    // 方向数组，上下左右的坐标偏移量
    vector<vector<int>> dirs {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // 返回坐标 (x, y) 的上下左右相邻坐标
    vector<vector<int>> adj(vector<vector<int>>& matrix, int x, int y) {
        int m = matrix.size(), n = matrix[0].size();
        // 存储相邻节点
        vector<vector<int>> neighbors;
        for (auto& dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                // 索引越界
                continue;
            }
            neighbors.push_back({nx, ny});
        }
        return neighbors;
    }

    struct State {
        // 矩阵中的一个位置
        int x, y;
        // 从起点 (0, 0) 到当前位置的最小体力消耗（距离）
        int effortFromStart;

        State(int x, int y, int effortFromStart) {
            this->x = x;
            this->y = y;
            this->effortFromStart = effortFromStart;
        }
    };

    struct Comp {
        bool operator() (State& a, State& b) {
            return a.effortFromStart > b.effortFromStart;
        }
    };
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

import heapq

class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m, n = len(heights), len(heights[0])
        # 定义：从 (0, 0) 到 (i, j) 的最小体力消耗是 effortTo[i][j]
        effortTo = [[float('inf')] * n for _ in range(m)]
        # base case，起点到起点的最小消耗就是 0
        effortTo[0][0] = 0
        
        # 优先级队列，effortFromStart 较小的排在前面
        pq = []
        
        # 从起点 (0, 0) 开始进行 BFS
        heapq.heappush(pq, [0, 0, 0])

        while pq:
            curEffortFromStart, curX, curY = heapq.heappop(pq)
            
            # 到达终点提前结束
            if curX == m - 1 and curY == n - 1:
                return curEffortFromStart
            
            if curEffortFromStart > effortTo[curX][curY]:
                continue
                
            # 将 (curX, curY) 的相邻坐标装入队列
            for nextX, nextY in self.adj(heights, curX, curY):
                # 计算从 (curX, curY) 达到 (nextX, nextY) 的消耗
                effortToNextNode = max(
                    effortTo[curX][curY],
                    abs(heights[curX][curY] - heights[nextX][nextY])
                )
                # 更新 dp table
                if effortTo[nextX][nextY] > effortToNextNode:
                    effortTo[nextX][nextY] = effortToNextNode
                    heapq.heappush(pq, [effortToNextNode, nextX, nextY])
                    
        # 正常情况不会达到这个 return
        return -1
    
    # 方向数组，上下左右的坐标偏移量
    dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]

    # 返回坐标 (x, y) 的上下左右相邻坐标
    def adj(self, matrix, x, y):
        m, n = len(matrix), len(matrix[0])
        # 存储相邻节点
        neighbors = []
        for dir in self.dirs:
            nx = x + dir[0]
            ny = y + dir[1]
            if nx >= m or nx < 0 or ny >= n or ny < 0:
                # 索引越界
                continue
            neighbors.append([nx, ny])
        return neighbors
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // Dijkstra 算法，计算 (0, 0) 到 (m - 1, n - 1) 的最小体力消耗
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        // 定义：从 (0, 0) 到 (i, j) 的最小体力消耗是 effortTo[i][j]
        int[][] effortTo = new int[m][n];
        // dp table 初始化为正无穷
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        // base case，起点到起点的最小消耗就是 0
        effortTo[0][0] = 0;

        // 优先级队列，effortFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.effortFromStart - b.effortFromStart;
        });

        // 从起点 (0, 0) 开始进行 BFS
        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffortFromStart = curState.effortFromStart;

            // 到达终点提前结束
            if (curX == m - 1 && curY == n - 1) {
                return curEffortFromStart;
            }

            if (curEffortFromStart > effortTo[curX][curY]) {
                continue;
            }
            // 将 (curX, curY) 的相邻坐标装入队列
            for (int[] neighbor : adj(heights, curX, curY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                // 计算从 (curX, curY) 达到 (nextX, nextY) 的消耗
                int effortToNextNode = Math.max(
                        effortTo[curX][curY],
                        Math.abs(heights[curX][curY] - heights[nextX][nextY])
                );
                // 更新 dp table
                if (effortTo[nextX][nextY] > effortToNextNode) {
                    effortTo[nextX][nextY] = effortToNextNode;
                    pq.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }
        // 正常情况不会达到这个 return
        return -1;
    }

    // 方向数组，上下左右的坐标偏移量
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // 返回坐标 (x, y) 的上下左右相邻坐标
    List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        // 存储相邻节点
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                // 索引越界
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }

    class State {
        // 矩阵中的一个位置
        int x, y;
        // 从起点 (0, 0) 到当前位置的最小体力消耗（距离）
        int effortFromStart;

        State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

func minimumEffortPath(heights [][]int) int {
    m := len(heights)
    n := len(heights[0])
    // 定义：从 (0, 0) 到 (i, j) 的最小体力消耗是 effortTo[i][j]
    effortTo := make([][]int, m)
    for i := range effortTo {
        effortTo[i] = make([]int, n)
        // dp table 初始化为正无穷
        for j := range effortTo[i] {
            effortTo[i][j] = math.MaxInt32
        }
    }
    // base case，起点到起点的最小消耗就是 0
    effortTo[0][0] = 0

    // 方向数组，上下左右的坐标偏移量
    var dirs = [][2]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}

    // 返回坐标 (x, y) 的上下左右相邻坐标
    var adj = func(x, y int) [][]int {
        // 存储相邻节点
        neighbors := make([][]int, 0)
        for _, dir := range dirs {
            nx, ny := x+dir[0], y+dir[1]
            if nx >= m || nx < 0 || ny >= n || ny < 0 {
                // 索引越界
                continue
            }
            neighbors = append(neighbors, []int{nx, ny})
        }
        return neighbors
    }

    // 优先级队列的类型定义
    type PriorityQueue []*State

    func (pq PriorityQueue) Len() int            { return len(pq) }
    func (pq PriorityQueue) Less(i, j int) bool  { return pq[i].effortFromStart < pq[j].effortFromStart }
    func (pq PriorityQueue) Swap(i, j int)       { pq[i], pq[j] = pq[j], pq[i] }
    func (pq *PriorityQueue) Push(x interface{}) { *pq = append(*pq, x.(*State)) }
    func (pq *PriorityQueue) Pop() interface{} {
        old := *pq
        n := len(old)
        item := old[n-1]
        *pq = old[0 : n-1]
        return item
    }

    // 从起点 (0, 0) 开始进行 BFS
    pq := make(PriorityQueue, 0)
    heap.Init(&pq)
    pq.Push(&State{0, 0, 0})
    for pq.Len() > 0 {
        curState := heap.Pop(&pq).(*State)
        curX, curY, curEffortFromStart := curState.x, curState.y, curState.effortFromStart

        // 到达终点提前结束
        if curX == m-1 && curY == n-1 {
            return curEffortFromStart
        }

        if curEffortFromStart > effortTo[curX][curY] {
            continue
        }
        // 将 (curX, curY) 的相邻坐标装入队列
        for _, neighbor := range adj(curX, curY) {
            nextX, nextY := neighbor[0], neighbor[1]
            // 计算从 (curX, curY) 达到 (nextX, nextY) 的消耗
            effortToNextNode := max(
                effortTo[curX][curY],
                abs(heights[curX][curY]-heights[nextX][nextY]),
            )
            // 更新 dp table
            if effortTo[nextX][nextY] > effortToNextNode {
                effortTo[nextX][nextY] = effortToNextNode
                heap.Push(&pq, &State{nextX, nextY, effortToNextNode})
            }
        }
    }
    // 正常情况不会达到这个 return
    return -1
}

type State struct {
    // 矩阵中的一个位置
    x, y int
    // 从起点 (0, 0) 到当前位置的最小体力消耗（距离）
    effortFromStart int
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}

func abs(x int) int {
    if x < 0 {
        return -x
    }
    return x
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var minimumEffortPath = function(heights) {
    let m = heights.length, n = heights[0].length;
    // 定义：从 (0, 0) 到 (i, j) 的最小体力消耗是 effortTo[i][j]
    let effortTo = new Array(m).fill().map(() => new Array(n).fill(Number.MAX_VALUE));
    // dp table 初始化为正无穷
    for(let i = 0; i < m; i++) {
        effortTo[i].fill(Number.MAX_VALUE);
    }
    // base case，起点到起点的最小消耗就是 0
    effortTo[0][0] = 0;
    // 从起点 (0, 0) 开始进行 BFS
    let pq = new PriorityQueue((a, b) => {
        return a.effortFromStart - b.effortFromStart;
    });
    // 优先级队列，effortFromStart 较小的排在前面
    pq.offer(new State(0, 0, 0));
    while(!pq.isEmpty()) {
        let curState = pq.poll();
        let curX = curState.x;
        let curY = curState.y;
        let curEffortFromStart = curState.effortFromStart;

        // 到达终点提前结束
        if(curX === m - 1 && curY === n - 1) {
            return curEffortFromStart;
        }

        if(curEffortFromStart > effortTo[curX][curY]) {
            continue;
        }
        // 将 (curX, curY) 的相邻坐标装入队列
        let neighbors = adj(heights, curX, curY);
        for(let i = 0; i < neighbors.length; i++){
            let neighbor = neighbors[i];
            let nextX = neighbor[0];
            let nextY = neighbor[1];
            // 计算从 (curX, curY) 达到 (nextX, nextY) 的消耗
            let effortToNextNode = Math.max(
                effortTo[curX][curY],
                Math.abs(heights[curX][curY] - heights[nextX][nextY])
            );
            // 更新 dp table
            if(effortTo[nextX][nextY] > effortToNextNode) {
                effortTo[nextX][nextY] = effortToNextNode;
                pq.offer(new State(nextX, nextY, effortToNextNode));
            }
        }
    }
    // 正常情况不会达到这个 return
    return -1;
}

// 方向数组，上下左右的坐标偏移量
let dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];

// 返回坐标 (x, y) 的上下左右相邻坐标
let adj = (matrix, x, y) => {
    let m = matrix.length, n = matrix[0].length;
    // 存储相邻节点
    let neighbors = [];
    for(let i = 0; i < dirs.length; i++) {
        let dir = dirs[i];
        let nx = x + dir[0];
        let ny = y + dir[1];
        if(nx >= m || nx < 0 || ny >= n || ny < 0) {
            // 索引越界
            continue;
        }
        neighbors.push([nx, ny]);
    }
    return neighbors;
}

class PriorityQueue {
    constructor(fn) {
        this.heap = [];
        this.cmp = fn || ((a, b) => {
            return a - b;
        });
    }
    size() {
        return this.heap.length;
    }
    isEmpty() {
        return this.size() === 0;
    }
    offer(...values) {
        values.forEach((value) => {
            this.heap.push(value);
            this.up(this.size() - 1);
        });
    }
    poll() {
        if(this.isEmpty()) {
            return null;
        }
        const top = this.heap[0];
        this.swap(0, this.size() - 1);
        this.heap.pop();
        this.down(0);
        return top;
    }
    up(index) {
        let parent = (index - 1) >>> 1;
        while(index > 0 && this.cmp(this.heap[index], this.heap[parent]) < 0) {
            this.swap(index, parent);
            index = parent;
            parent = (index - 1) >>> 1;
        }
    }
    down(index) {
        let left = (index << 1) + 1;
        let right = (index << 1) + 2;
        let minComparator = index;
        if(left < this.size() && this.cmp(this.heap[left], this.heap[minComparator]) < 0) {
            minComparator = left;
        }
        if(right < this.size() && this.cmp(this.heap[right], this.heap[minComparator]) < 0) {
            minComparator = right;
        }
        if(minComparator !== index) {
            this.swap(index, minComparator);
            this.down(minComparator);
        }
    }
    peek() {
        return this.isEmpty() ? null : this.heap[0];
    }
    swap(i, j) {
        const temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }
}

class State {
    // 矩阵中的一个位置
    constructor(x, y, effortFromStart) {
        this.x = x;
        this.y = y;
        this.effortFromStart = effortFromStart;
    }
}
```

</div></div>
</div></div>

**类似题目**：
  - [1514. 概率最大的路径 🟠](/problems/path-with-maximum-probability)
  - [743. 网络延迟时间 🟠](/problems/network-delay-time)

</details>
</div>



