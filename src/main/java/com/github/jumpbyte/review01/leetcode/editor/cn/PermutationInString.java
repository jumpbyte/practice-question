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
                 // 判断左侧窗口是否要收缩，这里其实 可以使用  if(right - left == s1.length()) 判断
                 while (right - left >= s1.length()){
                     // 在这里判断是否找到了合法的子串
                     if(valid == need.size()){
                         return true;
                     }
                     char d = s2.charAt(left);
                     left++;
                     // 进行窗口内数据的一系列更新
                     if(need.containsKey(d)){
                         if(window.get(d).equals(need.get(d))){
                             valid--;
                         }
                         window.put(d,window.get(d)-1);
                     }
                 }
             }
            // 未找到符合条件的子串
             return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        // put your test code here  yaoehllelloeh
        System.out.println(solution.checkInclusion("hello","yaoehllelloeh"));
        
    }
}