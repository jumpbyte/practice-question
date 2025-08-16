package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class KthNodeFromEndOfListLcci {

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
        //倒数第K个节点，双指针，快慢指针
        public int kthToLast(ListNode head, int k) {
            if(head == null || k <= 0){
                return -1;
            }
            ListNode p1 = head;
            // p1 先走 k 步
            for (int i = 0; i < k; i++) {
                p1 = p1.next;
            }
            ListNode p2 = head;
            // p1,p2一起走,当p1走到尾，恰好走了n-k  (n假设是链表的总长度),p2停留在n-k+1的位置,即倒数第k个节点
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2.val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new KthNodeFromEndOfListLcci().new Solution();
        // put your test code here
        ListNode head = ListNode.createHead(new int[]{1,2,3,4,5});
        int val =  solution.kthToLast(head, 2);
        System.out.println( val);
    }
}