 //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 2371, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
  package com.github.jumpbyte.leetcode.editor.cn;

 import java.util.HashMap;
 import java.util.Map;
 import java.util.Objects;

 public class MinimumWindowSubstring{
      public static void main(String[] args) {
           Solution solution = new MinimumWindowSubstring().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String minWindow(String s, String t) {
        //需要凑齐的字符至少出现的次数
        Map<Character,Integer>  needs = new HashMap<>();
        //记录窗口中的字符以及出现次数
        Map<Character,Integer>  window = new HashMap<>();
        //记录窗口内已出现目标字符的个数，当字符个数完全覆盖到目标所有字符，即可收缩窗口左边
        int validCount=0;
        //记录最小覆盖子串的起始索引及窗口长度
        int start=0, len = Integer.MAX_VALUE;
        //窗口起止位置，注意是左闭右开区间[left,right) 方便后续处理
        int left = 0, right = 0;
        for (char c : t.toCharArray()) {
            needs.put(c,1);
        }
        while (right < s.length()){
            //c 是将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            if(needs.containsKey(c)){
                // 进行窗口内数据的一系列更新
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).intValue() == needs.get(c).intValue()){
                    //c第一次出现在窗口内时，目标出现字符个数计数加1，保证同一个字符多次只累加1次
                    validCount ++;
                }
            }
            while (validCount == needs.size()){
                // 在这里更新最小覆盖子串
                if(right - left < len){
                    start = left;
                    //注意是左闭右开区间，长度不包括right索引位置
                    len = right - left;
                }
                //d是即将移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left ++ ;
                // 进行窗口内数据的一系列更新
                if(needs.containsKey(d)){
                    if(Objects.equals(window.get(d), needs.get(d))){
                        //当某个字符最后离开窗口，目标出现字符个数计数减一
                        validCount--;
                    }
                    //移出窗口，出现次数减一
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return  len == Integer.MAX_VALUE ? "": s.substring(start,len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }