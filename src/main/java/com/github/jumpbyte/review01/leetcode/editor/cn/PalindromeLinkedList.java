package com.github.jumpbyte.review01.leetcode.editor.cn;

import com.github.jumpbyte.leetcode.editor.common.*;

import java.util.List;

public class PalindromeLinkedList {

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

        /**
         * 解法二：快慢指针定位中间节点，然后右半部分链表，比较左右链表节点值是否相等
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast!=null && fast.next !=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            // 如果 fast 指针没有指向 null，说明链表长度为奇数，slow 还要再前进一步
            if(fast != null){
                slow = slow.next;
            }
            ListNode left = head;
            ListNode right = reverseInplace(slow);
            while (right != null){
                if(left.val != right.val){
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;

        }

        private ListNode reverseInplace(ListNode head){
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        /**
         * 解法一：翻转一个新的链表，比较两个链表每个节点的值是否相同，有一个不相等则返回 false
         * @param head
         * @return
         */
        public boolean isPalindrome1(ListNode head) {
            ListNode newHead = reverseList(head);
            while (newHead!=null){
                if (newHead.val!=head.val){
                    return false;
                }
                newHead = newHead.next;
                head = head.next;
            }
            return true;
        }

        public ListNode reverseList(ListNode head) {
            ListNode  dummy = new ListNode(-1);
            ListNode cur = head;
            //将链表翻转 形成一个新的链表，不破坏原始链表
            while (cur!=null){
                ListNode nxt = cur.next;
                ListNode dnext =  dummy.next;
                dummy.next = new ListNode(cur.val);
                dummy.next.next = dnext;
                cur = nxt;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here
        ListNode head = ListNode.createHead(new int[]{1,2,2,1});
        System.out.println(solution.isPalindrome1(head));
    }
}