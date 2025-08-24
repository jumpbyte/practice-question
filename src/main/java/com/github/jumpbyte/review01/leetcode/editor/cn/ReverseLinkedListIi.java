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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(head == null || m > n){
                return null;
            }
            if (m == 1) {
                return reverseN(head, n);
            }
            // 找到第 m 个节点的前驱
            ListNode pre = head;
            for (int i = 1; i < m - 1; i++) {
                pre = pre.next;
            }
            // 从第 m 个节点开始反转
            pre.next = reverseN(pre.next, n - m + 1);
            return head;

        }

        private ListNode successor = null;
        public ListNode reverseN(ListNode head, int n){
            if (n == 1) {
                // 记录第 n + 1 个节点
                successor = head.next;
                return head;
            }
            // 以 head.next 为起点，需要反转前 n - 1 个节点
            ListNode last = reverseN(head.next, n - 1);

            head.next.next = head;
            // 让反转之后的 head 节点和后面的节点连起来
            head.next = successor;
            return last;

        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // put your test code here
        
    }
}