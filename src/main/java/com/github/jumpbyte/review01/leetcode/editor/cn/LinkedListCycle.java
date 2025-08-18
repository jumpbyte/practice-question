package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class LinkedListCycle {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        // 快慢指针,快指针每次走两步，慢指针每次走一步，如果存在环，快慢指针始终会相遇
        public boolean hasCycle(ListNode head) {
            ListNode slow = head,fast = head;
            while (fast!=null && fast.next !=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return  true;
                }
            }
            return  false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        // put your test code here
        
    }
}