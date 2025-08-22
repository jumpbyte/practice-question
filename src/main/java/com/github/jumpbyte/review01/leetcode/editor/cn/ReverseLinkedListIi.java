package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class ReverseLinkedListIi {

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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head == null || left > right){
                return null;
            }
            int i = 0;
            ListNode cur = head;
            while (i < left){
                cur = cur.next;
                i++;
            }
            cur.next = reverseN(cur.next, right - left);
            return head;
        }

        public ListNode reverseN(ListNode head, int n){
            ListNode pre = null;
            ListNode cur = head;
            ListNode nxt = head.next;
            while (n > 0){
                cur.next = pre;
                pre = cur;
                cur = nxt;
                nxt = nxt.next;
                n--;
            }
            return pre;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // put your test code here
        
    }
}