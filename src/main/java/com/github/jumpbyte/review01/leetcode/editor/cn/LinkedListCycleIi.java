package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class LinkedListCycleIi {

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
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    break;
                }
            }
            // fast 遇到空指针说明没有环
            if(fast == null || fast.next == null){
                return null;
            }
            slow = head;
            // 快慢指针同步前进，相交点就是环起点
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        // put your test code here
        
    }
}