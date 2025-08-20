package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;

import com.github.jumpbyte.leetcode.editor.common.*;

public class AddTwoNumbers {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null || l2 == null){
                return null;
            }
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            ListNode p1 = l1, p2 = l2;
            int carry = 0;
            while (p1 != null || p2 != null) {
                int x = p1 == null ? 0 : p1.val;
                int y = p2 == null ? 0 : p2.val;
                int sum = x + y + carry;
                carry = sum / 10;
                sum = sum % 10;
                ListNode node = new ListNode(sum);
                cur.next = node;
                cur = node;
                p1 = p1 == null ? null : p1.next;
                p2 = p2 == null ? null : p2.next;
            }
            if (carry > 0) {
                cur.next = new ListNode(carry);
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // put your test code here
        ListNode.print(solution.addTwoNumbers(ListNode.createHead(new int[]{2,4,3}), ListNode.createHead(new int[]{5,6,4})));

    }
}