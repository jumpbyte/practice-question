package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int cur = 0;
            int next = 1;
            while (next < nums.length){
                if(nums[cur] != nums[next]){
                    cur++;
                    nums[cur] = nums[next];
                    next++;
                }else{
                    next++;
                }
            }
            return cur + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        // put your test code here
        System.out.println(solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}