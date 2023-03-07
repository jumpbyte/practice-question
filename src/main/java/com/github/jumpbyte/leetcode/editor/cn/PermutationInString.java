//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics哈希表 | 双指针 | 字符串 | 滑动窗口 
//
// 👍 870, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        solution.checkInclusion("ab","eidboaoo");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] window = new int[26];
            int[] need = new int[26];
            int left=0,right =0, a='a';
            //记录当前窗口满足了多少个目标字符出现次数要求，每满足一个字符出现的次数 就加一
            int match=0;
            //目标字符种类数
            int kind=0;
            for (char c : s1.toCharArray()) {
                if (++need[c-a]==1) {
                    kind++;
                }
            }
            while (right < s2.length()){
                char r = s2.charAt(right);
                right++;
                if (need[r-a] > 0) {
                    window[r-a]++;
                    if(window[r-a] == need[r-a]){
                        match ++;
                    }
                }
                //窗口宽度只要增大到目标s1字符长度时，判断是否符合条件，然后开始收缩窗口左边
                while (right - left >= s1.length()){
                    //窗口长度和s1长度相等 并且 match和kind又相等 说明窗口内的字符串就是s1的一个排列
                    if(match == kind){
                        return true;
                    }
                    //移出窗口
                    char l = s2.charAt(left);
                    //收缩左边界
                    left ++ ;
                    if(need[l-a]>0){
                        if(window[l-a] == need[l-a]){
                            match--;
                        }
                        window[l-a]--;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}