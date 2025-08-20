package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class AddTwoNumbersIi {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                int x = stack1.isEmpty() ? 0 : stack1.pop();
                int y = stack2.isEmpty() ? 0 : stack2.pop();
                int sum = x + y + carry;
                carry = sum / 10;
                ListNode node  = new ListNode(sum % 10);
                if(pre == dummy){
                    pre.next = node;
                }else {
                    ListNode next = pre.next;

                }
            }
            if (carry > 0) {

            }
            return dummy.next;
            
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        // put your test code here
        
    }
}