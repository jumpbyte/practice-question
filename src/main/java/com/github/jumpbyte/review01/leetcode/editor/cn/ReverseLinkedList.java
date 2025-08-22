package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class ReverseLinkedList {

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
         * 解法一： 迭代法
         *
         * @param head
         * @return
         */
        public ListNode reverseList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //  由于单链表的结构，至少要用三个指针才能完成迭代反转
            //  cur 是当前遍历的节点，pre 是 cur 的前驱结点，nxt 是 cur 的后继结点
            ListNode pre = null, cur = head, nxt = head.next;
            while (cur != null) {
                //逐个结点反转
                cur.next = pre;
                //更新指针位置
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
            }
            return pre;
        }

        /**
         * 解法二： 递归翻转
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            //利用后序遍历，将前节点的下一个节点的next指针指向自己
            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // put your test code here
        
    }
}