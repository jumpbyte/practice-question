 //给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 84, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
  package com.github.jumpbyte.leetcode.editor.cn;
  public class M1oyTv{
      public static void main(String[] args) {
           Solution solution = new M1oyTv().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String minWindow(String s, String t) {
        //因为给定字符都是英文字母，从大写A-z ascii码区间[65,122] 共计58个，因此可以用数组下标表示相对A的ascii码偏移量
        int[] window = new int[58];
        int[] need = new int[58];
        int right=0,left=0,base='A',minLen = Integer.MAX_VALUE;
        //记录最短子串其实索引
        int start=0;
        //t中的字符种类数
        int kind=0;
        //窗口满足t中字符出现次数要求计数
        int match=0;
        for (char c : t.toCharArray()) {
            if(++need[c-base]==1){
                kind++;
            }
        }
        while (right < s.length()){
             char r = s.charAt(right);
             right ++ ;
             if(need[r-base]>0){
                 window[r-base]++;
                 if(window[r-base] == need[r-base]){
                     match++;
                 }
             }
             while (match == kind){
                 //更新最短字符串长度
                 if(right - left < minLen){
                     start = left;
                     minLen = right - left;
                 }
                 char l = s.charAt(left);
                 left ++ ;
                 if(need[l-base]>0){
                     if (window[l-base] == need[l-base]) {
                         match--;
                     }
                     window[l-base] -- ;
                 }
             }
        }
        return minLen == Integer.MAX_VALUE ? "":s.substring(start,start+minLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }