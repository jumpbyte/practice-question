<p>给你一个有&nbsp;<code>n</code>&nbsp;个节点的 <strong>有向无环图（DAG）</strong>，请你找出所有从节点 <code>0</code>&nbsp;到节点 <code>n-1</code>&nbsp;的路径并输出（<strong>不要求按特定顺序</strong>）</p>

<p>
 <meta charset="UTF-8" />&nbsp;<code>graph[i]</code>&nbsp;是一个从节点 <code>i</code> 可以访问的所有节点的列表（即从节点 <code>i</code> 到节点&nbsp;<code>graph[i][j]</code>存在一条有向边）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_1.jpg" /></p>

<pre>
<strong>输入：</strong>graph = [[1,2],[3],[3],[]]
<strong>输出：</strong>[[0,1,3],[0,2,3]]
<strong>解释：</strong>有两条路径 0 -&gt; 1 -&gt; 3 和 0 -&gt; 2 -&gt; 3
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_2.jpg" /></p>

<pre>
<strong>输入：</strong>graph = [[4,3,1],[3,2,4],[3],[4],[]]
<strong>输出：</strong>[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == graph.length</code></li> 
 <li><code>2 &lt;= n &lt;= 15</code></li> 
 <li><code>0 &lt;= graph[i][j] &lt; n</code></li> 
 <li><code>graph[i][j] != i</code>（即不存在自环）</li> 
 <li><code>graph[i]</code> 中的所有元素 <strong>互不相同</strong></li> 
 <li>保证输入为 <strong>有向无环图（DAG）</strong></li> 
</ul>

<p>&nbsp;</p>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 回溯</details><br>

<div>👍 386, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。[第 18 期每日打卡](https://aep.xet.tech/s/2PLO1n) 开始报名。**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=all-paths-from-source-to-target" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[图论基础及遍历算法](https://www.bilibili.com/video/BV19G41187cL)

解法很简单，以 `0` 为起点遍历图，同时记录遍历过的路径，当遍历到终点时将路径记录下来即可。

既然输入的图是无环的，我们就不需要 `visited` 数组辅助了，可以直接套用 [图的遍历框架](https://labuladong.github.io/article/fname.html?fname=图)。

**详细题解：[图论基础及遍历算法](https://labuladong.github.io/article/fname.html?fname=图)**

**标签：[图论算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122000448684457990)，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

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
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
    // 记录所有路径
    vector<vector<int>> res;

public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        deque<int> path;
        traverse(graph, 0, path);
        return res;
    }

    /* 图的遍历框架 */
    void traverse(vector<vector<int>>& graph, int s, deque<int>& path) {

        // 添加节点 s 到路径
        path.push_back(s);

        int n = graph.size();
        if (s == n - 1) {
            // 到达终点
            res.push_back(vector<int>(path.begin(), path.end()));
            path.pop_back();
            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 s
        path.pop_back();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

from typing import List

class Solution:
    def __init__(self):
        # 记录所有路径
        self.res = []

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        path = []
        self.traverse(graph, 0, path)
        return self.res

    """ 图的遍历框架 """
    def traverse(self, graph: List[List[int]], s: int, path: List[int]) -> None:
        # 添加节点 s 到路径
        path.append(s)

        n = len(graph)
        if s == n - 1:
            # 到达终点
            self.res.append(path[:])
            path.pop()
            return

        # 递归每个相邻节点
        for v in graph[s]:
            self.traverse(graph, v, path)

        # 从路径移出节点 s
        path.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录所有路径
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    /* 图的遍历框架 */
    void traverse(int[][] graph, int s, LinkedList<Integer> path) {

        // 添加节点 s 到路径
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 s
        path.removeLast();
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

package main

// 记录所有路径
var res [][]int

func allPathsSourceTarget(graph [][]int) [][]int {
    path := []int{}
    traverse(graph, 0, path)
    return res
}

/* 图的遍历框架 */
func traverse(graph [][]int, s int, path []int) {

    // 添加节点 s 到路径
    path = append(path, s)

    n := len(graph)
    if s == n-1 {
        // 到达终点
        tmp := make([]int, len(path))
        copy(tmp, path)
        res = append(res, tmp)
        path = path[:len(path)-1]
        return
    }

    // 递归每个相邻节点
    for _, v := range graph[s] {
        traverse(graph, v, path)
    }

    // 从路径移出节点 s
    path = path[:len(path)-1]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

var allPathsSourceTarget = function(graph) {
    // 记录所有路径
    var res = [];

    var traverse = function(graph, s, path) {
        // 添加节点 s 到路径
        path.push(s);

        var n = graph.length;
        if (s === n - 1) {
            // 到达终点
            res.push(path.slice());
            path.pop();
            return;
        }

        // 递归每个相邻节点
        for (var i = 0; i < graph[s].length; i++) {
            traverse(graph, graph[s][i], path);
        }

        // 从路径移出节点 s
        path.pop();
    };

    var path = [];
    traverse(graph, 0, path);

    return res;
};
```

</div></div>
</div></div>

**类似题目**：
  - [剑指 Offer II 110. 所有路径 🟠](/problems/bP4bmD)

</details>
</div>





