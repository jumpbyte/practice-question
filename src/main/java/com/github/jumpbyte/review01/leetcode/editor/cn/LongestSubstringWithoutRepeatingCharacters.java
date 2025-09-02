package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class LongestSubstringWithoutRepeatingCharacters {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> window = new HashMap<>();
            int left=0,right=0;
            int res = 0;
            while (right < s.length()){
                char c = s.charAt(right);
                right ++ ;
                //进行窗口内数据的一系列更新
                window.put(c,window.getOrDefault(c,0)+1);
                // 判断左侧窗口是否要收缩
                //当 window[c] 值大于 1 时，说明窗口中存在重复字符，不符合条件，就该移动 left 缩小窗口了。
                while (window.get(c) > 1 ){
                    char d = s.charAt(left);
                    left++;
                    //进行窗口内数据的一系列更新
                    window.put(d,window.get(d)-1);
                }
                //更新结果
                //要在收缩窗口完成后更新 res，因为窗口收缩的 while 条件是存在重复元素，换句话说收缩完成后一定保证窗口中没有重复。
                res = Math.max(res,right-left);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        // put your test code here
        System.out.println(solution.lengthOfLongestSubstring("abcbdba"));
        
    }
}