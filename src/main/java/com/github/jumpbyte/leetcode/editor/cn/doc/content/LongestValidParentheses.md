<p>给你一个只包含 <code>'('</code>&nbsp;和 <code>')'</code>&nbsp;的字符串，找出最长有效（格式正确且连续）括号<span data-keyword="substring">子串</span>的长度。</p>

<p>&nbsp;</p>

<div class="original__bRMd"> 
 <div> 
  <p><strong>示例 1：</strong></p> 
 </div>
</div>

<pre>
<strong>输入：</strong>s = "(()"
<strong>输出：</strong>2
<strong>解释：</strong>最长有效括号子串是 "()"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = ")()())"
<strong>输出：</strong>4
<strong>解释：</strong>最长有效括号子串是 "()()"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = ""
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>s[i]</code> 为 <code>'('</code> 或 <code>')'</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 字符串 | 动态规划</details><br>

<div>👍 2744, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

如果你看过前文 [手把手解决三道括号相关的算法题](https://labuladong.online/algo/problem-set/parentheses/)，就知道一般判断括号串是否合法的算法如下：

```java
Stack<Integer> stk = new Stack<>();
for (int i = 0; i < s.length(); i++) {
    if (s.charAt(i) == '(') {
        // 遇到左括号，记录索引
        stk.push(i);
    } else {
        // 遇到右括号
        if (!stk.isEmpty()) {
            // 配对的左括号对应索引，[leftIndex, i] 是一个合法括号子串
            int leftIndex = stk.pop();
            // 这个合法括号子串的长度
            int len = 1 + i - leftIndex;
        } else {
            // 没有配对的左括号
        }
    }
}
```

但如果多个合法括号子串连在一起，会形成一个更长的合法括号子串，而上述算法无法适配这种情况。

所以需要一个 `dp` 数组，记录 `leftIndex` 相邻合法括号子串的长度，才能得出题目想要的正确结果。

</div>





<div id="solution">

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
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

#include <stack>
#include <vector>
#include <string>
#include <algorithm>

class Solution {
public:
    int longestValidParentheses(std::string s) {
        std::stack<int> stk;
        // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        std::vector<int> dp(s.length() + 1, 0);
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') {
                // 遇到左括号，记录索引
                stk.push(i);
                // 左括号不可能是合法括号子串的结尾
                dp[i + 1] = 0;
            } else {
                // 遇到右括号
                if (!stk.empty()) {
                    // 配对的左括号对应索引
                    int leftIndex = stk.top();
                    stk.pop();
                    // 以这个右括号结尾的最长子串长度
                    int len = 1 + i - leftIndex + dp[leftIndex];
                    dp[i + 1] = len;
                } else {
                    // 没有配对的左括号
                    dp[i + 1] = 0;
                }
            }
        }
        // 计算最长子串的长度
        int res = 0;
        for (int i = 0; i < dp.size(); i++) {
            res = std::max(res, dp[i]);
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stk = []
        # dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        dp = [0] * (len(s) + 1)
        for i in range(len(s)):
            if s[i] == '(':
                # 遇到左括号，记录索引
                stk.append(i)
                # 左括号不可能是合法括号子串的结尾
                dp[i + 1] = 0
            else:
                # 遇到右括号
                if stk:
                    # 配对的左括号对应索引
                    left_index = stk.pop()
                    # 以这个右括号结尾的最长子串长度
                    len_sub = 1 + i - left_index + dp[left_index]
                    dp[i + 1] = len_sub
                else:
                    # 没有配对的左括号
                    dp[i + 1] = 0
        # 计算最长子串的长度
        res = 0
        for i in range(len(dp)):
            res = max(res, dp[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 遇到左括号，记录索引
                stk.push(i);
                // 左括号不可能是合法括号子串的结尾
                dp[i + 1] = 0;
            } else {
                // 遇到右括号
                if (!stk.isEmpty()) {
                    // 配对的左括号对应索引
                    int leftIndex = stk.pop();
                    // 以这个右括号结尾的最长子串长度
                    int len = 1 + i - leftIndex + dp[leftIndex];
                    dp[i + 1] = len;
                } else {
                    // 没有配对的左括号
                    dp[i + 1] = 0;
                }
            }
        }
        // 计算最长子串的长度
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func longestValidParentheses(s string) int {
    stk := []int{}
    // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
    dp := make([]int, len(s)+1)
    for i := 0; i < len(s); i++ {
        if s[i] == '(' {
            // 遇到左括号，记录索引
            stk = append(stk, i)
            // 左括号不可能是合法括号子串的结尾
            dp[i+1] = 0
        } else {
            // 遇到右括号
            if len(stk) > 0 {
                // 配对的左括号对应索引
                leftIndex := stk[len(stk)-1]
                stk = stk[:len(stk)-1]
                // 以这个右括号结尾的最长子串长度
                len := 1 + i - leftIndex + dp[leftIndex]
                dp[i+1] = len
            } else {
                // 没有配对的左括号
                dp[i+1] = 0
            }
        }
    }
    // 计算最长子串的长度
    res := 0
    for i := 0; i < len(dp); i++ {
        res = max(res, dp[i])
    }
    return res
}

// Helper function to find the maximum of two integers
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
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var longestValidParentheses = function(s) {
    let stk = [];
    // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
    let dp = new Array(s.length + 1).fill(0);
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) === '(') {
            // 遇到左括号，记录索引
            stk.push(i);
            // 左括号不可能是合法括号子串的结尾
            dp[i + 1] = 0;
        } else {
            // 遇到右括号
            if (stk.length > 0) {
                // 配对的左括号对应索引
                let leftIndex = stk.pop();
                // 以这个右括号结尾的最长子串长度
                let len = 1 + i - leftIndex + dp[leftIndex];
                dp[i + 1] = len;
            } else {
                // 没有配对的左括号
                dp[i + 1] = 0;
            }
        }
    }
    // 计算最长子串的长度
    let res = 0;
    for (let i = 0; i < dp.length; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_longest-valid-parentheses"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-valid-parentheses"></div></div>
</details><hr /><br />

</div>
</details>
</div>

