package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class PalindromeNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            String s = String.valueOf(x);
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left ++ ;
                right -- ;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        // put your test code here
        System.out.println(solution.isPalindrome(121));
        
    }
}