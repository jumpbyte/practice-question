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
            if(head == null || head.next == null){
                return head;
            }
            //pre 指向当前处理的节点（当前段的起始节点）。
            //next 是 pre 的下一个节点，用于判断是否重复。
            //cur 用于连接最终保留的节点。
             ListNode dummy = new ListNode(-1);
             dummy.next = head;
             ListNode pre = dummy.next;
             ListNode next = pre.next;
             ListNode cur = dummy;
             while (next != null){
                 // 有重复节点
                 if(pre.val == next.val){
                     while (next != null && pre.val == next.val){
                         next = next.next;
                     }
                     //跳过所有重复节点，将 cur.next 指向第一个不重复的节点
                     cur.next = next;
                     pre = next;
                     next = pre != null? pre.next : null;
                 }else{
                     // 没有重复，三个指针后移
                     pre = next;
                     next = pre.next;
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
        ListNode head = ListNode.createHead(new int[]{1,1,1,2,3});
        ListNode.print(solution.deleteDuplicates(head));
        head = ListNode.createHead(new int[]{1,2,3,3,4,4,5});
        System.out.println();
        ListNode.print(solution.deleteDuplicates(head));
        
    }
}