package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class PermutationInString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
             Map<Character,Integer> need = new HashMap<>();
             Map<Character,Integer> window = new HashMap<>();
             for(char c : s1.toCharArray()){
                 need.put(c,need.getOrDefault(c,0)+1);
             }
             int left = 0,right = 0;
             int valid = 0;
             while (right < s2.length()){
                 char c = s2.charAt(right);
                 right++;
                 //更新窗口数据
                 if(need.containsKey(c)){
                     window.put(c,window.getOrDefault(c,0)+1);
                     if(window.get(c).equals(need.get(c))){
                         valid++;
                     }
                 }
             }
             return valid == need.size();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        // put your test code here
        
    }
}