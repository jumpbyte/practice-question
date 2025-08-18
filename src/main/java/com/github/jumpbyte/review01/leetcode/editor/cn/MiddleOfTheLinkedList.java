package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class MiddleOfTheLinkedList {

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
        // 快慢指针
        public ListNode middleNode(ListNode head) {
            if(head == null){
                return null;
            }
            ListNode slow = head,fast = head;
            while (fast!=null && fast.next !=null){
                //慢指针走一步，快指针走两步
                slow = slow.next;
                fast = fast.next.next;
            }
            //快指针走到尾，慢指针正好走到中间位置
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        // put your test code here
        ListNode head = ListNode.createHead(new int[]{1,2,3,7,4,5});
        ListNode.print(solution.middleNode(head));
    }
}