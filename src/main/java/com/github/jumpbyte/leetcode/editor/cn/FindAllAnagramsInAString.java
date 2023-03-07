 //给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 1104, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
  package com.github.jumpbyte.leetcode.editor.cn;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 public class FindAllAnagramsInAString{
      public static void main(String[] args) {
           Solution solution = new FindAllAnagramsInAString().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] window = new int[26];
        int[] need = new int[26];
        int needCount=0;
        for (char c : p.toCharArray()) {
             need[c-'a'] +=1;
             if(need[c-'a'] == 1){
                 needCount ++;
             }
        }
        int left=0,right=0;
        int match=0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()){
            //c 移入窗口
            char c = s.charAt(right);
            //增大窗口
            right++;
            //进行窗口内数据的一系列更新
            if(need[c-'a']>0){
                window[c-'a']++;
                if(window[c-'a'] == need[c-'a']){
                    match++;
                }
            }
            //窗口长度增大到p的长度时，开始收缩窗口，并且此时判断是否符合条件
            while (right - left == p.length()){
                //窗口长度正好覆盖目标p的长度，说明窗口内的字符串是p的不同排列
                if(match == needCount){
                    res.add(left);
                }
                char d =  s.charAt(left);
                left ++ ;
                if(need[d-'a']>0){
                    if(window[d-'a'] == need[d-'a']){
                        match--;
                    }
                    window[d-'a']--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }