package com.github.jumpbyte.review01.leetcode.editor.cn;

import com.github.jumpbyte.leetcode.editor.common.ListNode;

public class ReverseLinkedListI {

    class Solution {

        /**
         *  1->2->3->4->5->NULL
         *  翻转前K个节点
         * @param head
         * @param n
         * @return
         */
        public ListNode reverseKList(ListNode head, int n) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode nxt = head.next;
            while (n > 0) {
                cur.next = pre;
                pre = cur;
                cur = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
                n--;
            }
            // 此时的 cur 是第 n + 1 个节点，head 是反转后的尾结点
            head.next = cur;

            // 此时的 pre 是反转后的头结点
            return pre;
        }
    }

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListI().new Solution();
        // put your test code here
        ListNode kList = solution.reverseKList(ListNode.createHead(new int[]{1, 2, 3, 4, 5}), 2);
        ListNode.print(kList);
    }
}
