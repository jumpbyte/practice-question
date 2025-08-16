package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class PartitionList {

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
        public ListNode partition(ListNode head, int x) {
            ListNode smaller = new ListNode(-1);
            ListNode bigger = new ListNode(-1);
            ListNode p = head,s = smaller,b = bigger;
            while (p!=null){
                if(p.val < x){
                    s.next = p;
                    s = s.next;
                }else {
                    b.next = p;
                    b = b.next;
                }
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }
            s.next = bigger.next;
            return smaller.next;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        // put your test code here
        ListNode list = ListNode.createHead(new int[]{1,4,3,2,5,2});
        ListNode result = solution.partition(list, 3);
        ListNode.print(result);
    }
}