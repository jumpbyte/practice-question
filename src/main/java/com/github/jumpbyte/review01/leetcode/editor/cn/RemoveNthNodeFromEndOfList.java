package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;

import com.github.jumpbyte.leetcode.editor.common.*;

public class RemoveNthNodeFromEndOfList {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        // 双指针，删除倒数第n个节点
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null || n <= 0){
                return null;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            //删除倒数第 n 个，首先要找到它的前驱节点，即倒数第n+1个节点
            ListNode pre = findNthFromEnd(dummy, n+1);
            pre.next = pre.next.next;
            return dummy.next;
        }

        private ListNode findNthFromEnd(ListNode head, int n) {
            ListNode first = head;
            ListNode second = head;
            // first先走n步
            for (int i = 0; i < n; i++) {
                first = first.next;
            }
            // first和second同时走，first走到链表末尾时，second指向倒数第n个节点
            while (first != null){
                first = first.next;
                second = second.next;
            }
            return second;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here
        ListNode root = ListNode.createHead(new int[]{1,2,3,4,5});
        ListNode result = solution.removeNthFromEnd(root, 5);
        ListNode.print(result);

    }
}