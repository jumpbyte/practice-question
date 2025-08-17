package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class RemoveNthNodeFromEndOfList {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        // 双指针，删除倒数第n个节点
        public ListNode removeNthFromEnd(ListNode head, int n) {

             ListNode dummy = new ListNode(-1);
             dummy.next = head;
             ListNode p1 = head;
            for (int i = 0; i < n + 1; i++) {
                if (p1 != null) {
                    p1 = p1.next;
                }
            }
            ListNode p2 = head;
            while (p1 != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            if(p2.next != null){
                p2.next = p2.next.next;
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here
        
    }
}