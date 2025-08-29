package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            // 窗口需要凑齐的字符及其出现的次数
            Map<Character,Integer>  needs = new HashMap<>();
            // 记录窗口中的字符及其出现的次数
            Map<Character,Integer>  window = new HashMap<>();
            // 窗口中已经满足的目标字符个数
            int validCount=0;
            int left =0 ,right = 0;
            // 记录最小覆盖子串的起始索引及长度
            int start = 0,len = Integer.MAX_VALUE;

            for(char c : t.toCharArray()){
                needs.put(c,needs.getOrDefault(c,0)+1);
            }

            while (right < s.length()){
                char c = s.charAt(right);
                right ++ ;
                //进行窗口内数据一系列更新
                if(needs.containsKey(c)){
                    window.put(c,window.getOrDefault(c,0)+1);
                    // 窗口中字符的个数和needs中字符个数相等时，累计目标字符符合个数
                    if(window.get(c).equals(needs.get(c))){
                        validCount++;
                    }
                }

                while (validCount == needs.size()){
                    //判断最小覆盖子串
                    if(right - left < len){
                        start = left;
                        len = right - left;
                    }
                    //d是即将移出窗口的字符
                    char d = s.charAt(left);
                    left ++ ;
                    //缩小窗口，进行窗口内数据一系列更新
                    if(needs.containsKey(d)){
                        if(window.get(d).equals(needs.get(d))){
                            validCount--;
                        }
                        window.put(d,window.get(d)-1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // put your test code here
        
    }
}