<p>给定一组&nbsp;<code>n</code>&nbsp;人（编号为&nbsp;<code>1, 2, ..., n</code>），&nbsp;我们想把每个人分进<strong>任意</strong>大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。</p>

<p>给定整数 <code>n</code>&nbsp;和数组 <code>dislikes</code>&nbsp;，其中&nbsp;<code>dislikes[i] = [a<sub>i</sub>, b<sub>i</sub>]</code>&nbsp;，表示不允许将编号为 <code>a<sub>i</sub></code>&nbsp;和&nbsp;&nbsp;<code>b<sub>i</sub></code>的人归入同一组。当可以用这种方法将所有人分进两组时，返回 <code>true</code>；否则返回 <code>false</code>。</p>

<p>&nbsp;</p>

<ol> 
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 4, dislikes = [[1,2],[1,3],[2,4]]
<strong>输出：</strong>true
<strong>解释：</strong>group1 [1,4], group2 [2,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 3, dislikes = [[1,2],[1,3],[2,3]]
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 2000</code></li> 
 <li><code>0 &lt;= dislikes.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>dislikes[i].length == 2</code></li> 
 <li><code>1 &lt;= dislikes[i][j] &lt;= n</code></li> 
 <li><code>a<sub>i</sub>&nbsp;&lt; b<sub>i</sub></code></li> 
 <li><code>dislikes</code>&nbsp;中每一组都 <strong>不同</strong></li> 
</ul>

<p>&nbsp;</p>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 图</details><br>

<div>👍 365, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=possible-bipartition" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[二分图判定算法及应用](https://www.bilibili.com/video/BV18N4y1L7aa)

和 [785. 判断二分图](/problems/is-graph-bipartite) 一样，其实这题考察的就是二分图的判定：

如果你把每个人看做图中的节点，相互讨厌的关系看做图中的边，那么 `dislikes` 数组就可以构成一幅图；

又因为题目说互相讨厌的人不能放在同一组里，相当于图中的所有相邻节点都要放进两个不同的组；

那就回到了「双色问题」，如果能够用两种颜色着色所有节点，且相邻节点颜色都不同，那么你按照颜色把这些节点分成两组不就行了嘛。

所以解法就出来了，我们把 `dislikes` 构造成一幅图，然后执行二分图的判定算法即可。

**详细题解：[二分图判定算法](https://labuladong.github.io/article/fname.html?fname=二分图)**

**标签：二分图，[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)**

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
private:
    bool ok = true;
    vector<bool> color;
    vector<bool> visited;

public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        // 图节点编号从 1 开始
        color.resize(n + 1);
        visited.resize(n + 1);
        // 转化成邻接表表示图结构
        vector<vector<int>> graph = buildGraph(n, dislikes);

        for (int v = 1; v <= n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return ok;
    }

    // 建图函数
    vector<vector<int>> buildGraph(int n, vector<vector<int>>& dislikes) {
        // 图节点编号为 1...n
        vector<vector<int>> graph(n + 1);
        for (int i = 1; i <= n; i++) {
            graph[i] = vector<int>();
        }
        for (auto& edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].push_back(w);
            // w -> v
            graph[w].push_back(v);
        }
        return graph;
    }

    // 和之前判定二分图的 traverse 函数完全相同
    void traverse(vector<vector<int>>& graph, int v) {
        if (!ok) return;
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[w] == color[v]) {
                    ok = false;
                }
            }
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

class Solution:
    def __init__(self):
        self.ok = True
        self.color = None
        self.visited = None

    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        # 图节点编号从 1 开始
        self.color = [False] * (n + 1)
        self.visited = [False] * (n + 1)
        # 转化成邻接表表示图结构
        graph = self.buildGraph(n, dislikes)

        for v in range(1, n+1):
            if not self.visited[v]:
                self.traverse(graph, v)
        return self.ok

    # 建图函数
    def buildGraph(self, n: int, dislikes: List[List[int]]) -> List[List[int]]:
        # 图节点编号为 1...n
        graph = [[] for _ in range(n + 1)]
        for edge in dislikes:
            v = edge[1]
            w = edge[0]
            # 「无向图」相当于「双向图」
            # v -> w
            graph[v].append(w)
            # w -> v
            graph[w].append(v)
        return graph

    # 和之前判定二分图的 traverse 函数完全相同
    def traverse(self, graph: List[List[int]], v: int) -> None:
        if not self.ok:
            return
        self.visited[v] = True
        for w in graph[v]:
            if not self.visited[w]:
                self.color[w] = not self.color[v]
                self.traverse(graph, w)
            else:
                if self.color[w] == self.color[v]:
                    self.ok = False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    private boolean ok = true;
    private boolean[] color;
    private boolean[] visited;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 图节点编号从 1 开始
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        // 转化成邻接表表示图结构
        List<Integer>[] graph = buildGraph(n, dislikes);

        for (int v = 1; v <= n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }
        return ok;
    }

    // 建图函数
    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // 图节点编号为 1...n
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].add(w);
            // w -> v
            graph[w].add(v);
        }
        return graph;
    }

    // 和之前判定二分图的 traverse 函数完全相同
    private void traverse(List<Integer>[] graph, int v) {
        if (!ok) return;
        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[w] == color[v]) {
                    ok = false;
                }
            }
        }
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

import "fmt"

func possibleBipartition(n int, dislikes [][]int) bool {
	color := make([]bool, n+1)
	visited := make([]bool, n+1)
	ok := true

	// 转化成邻接表表示图结构
	graph := buildGraph(n, dislikes)

	var traverse func(int)
	traverse = func(v int) {
		if !ok {
			return
		}
		visited[v] = true
		for _, w := range graph[v] {
			if !visited[w] {
				color[w] = !color[v]
				traverse(w)
			} else {
				if color[w] == color[v] {
					ok = false
				}
			}
		}
	}

	// 全图遍历，防止非连通图出现
	for v := 1; v <= n; v++ {
		if !visited[v] {
			traverse(v)
		}
	}

	return ok
}

// 建图函数
func buildGraph(n int, dislikes [][]int) []([]int) {
	graph := make([]([]int), n+1)
	for i := range graph {
		graph[i] = make([]int, 0)
	}
	for _, edge := range dislikes {
		v := edge[1]
		w := edge[0]
		// 「无向图」相当于「双向图」
		// v -> w
		graph[v] = append(graph[v], w)
		// w -> v
		graph[w] = append(graph[w], v)
	}
	return graph
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的全部测试用例，可直接粘贴提交。

/**
 * @param {number} n
 * @param {number[][]} dislikes
 * @return {boolean}
 */
var possibleBipartition = function(n, dislikes) {
    let ok = true;
    let color = new Array(n + 1);
    let visited = new Array(n + 1);
    let graph = buildGraph(n, dislikes);
    // 建图函数
    function buildGraph(n, dislikes) {
        // 图节点编号为 1...n
        let graph = new Array(n + 1);
        for (let i = 1; i <= n; i++) {
            graph[i] = new Array();
        }
        for (let i = 0; i < dislikes.length; i++) {
            let v = dislikes[i][0];
            let w = dislikes[i][1];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].push(w);
            // w -> v
            graph[w].push(v);
        }
        return graph;
    }
    // 和之前判定二分图的 traverse 函数完全相同
    function traverse(graph, v) {
        if (!ok) return;
        visited[v] = true;
        for (let i = 0; i < graph[v].length; i++) {
            let w = graph[v][i];
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[w] == color[v]) {
                    ok = false;
                }
            }
        }
    }
    for (let v = 1; v <= n; v++) {
        if (!visited[v]) {
            traverse(graph, v);
        }
    }
    return ok;
};
```

</div></div>
</div></div>

**类似题目**：
  - [785. 判断二分图 🟠](/problems/is-graph-bipartite)
  - [剑指 Offer II 106. 二分图 🟠](/problems/vEAB3K)

</details>
</div>



