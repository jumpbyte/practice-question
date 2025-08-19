package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedListIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * test
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
        public ListNode deleteDuplicates(ListNode head) {
             ListNode dummy = new ListNode(-1);
             dummy.next = head;
             ListNode cur = dummy;
             while (cur.next != null && cur.next.next != null){
                 if(cur.next.val == cur.next.next.val){
                     int x = cur.next.val;
                     while (cur.next != null && cur.next.val == x){
                         cur.next = cur.next.next;
                     }
                 }else {
                     cur = cur.next;
                 }
             }
             return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        // put your test code here
        
    }
}