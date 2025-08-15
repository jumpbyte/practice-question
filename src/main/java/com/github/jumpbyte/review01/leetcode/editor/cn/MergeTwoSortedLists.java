package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class MergeTwoSortedLists {

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null || list2 == null){
                return null;
            }
            //双指针法合并两个有序链表
            ListNode dummy = new ListNode(-1);
            ListNode p1 = list1,p2 = list2, p = dummy;
            while (p1 != null && p2 != null){
                if(p1.val > p2.val){
                    p.next = p2;
                    p2 = p2.next;
                }else{
                    p.next = p1;
                    p1 = p1.next;
                }
                p = p.next;
            }
            p.next = p1 == null ? p2 : p1;
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // put your test code here
        ListNode list1 = ListNode.createHead(new int[]{1,2,4});

        ListNode list2 = ListNode.createHead(new int[]{3,5,6});
        ListNode result = solution.mergeTwoLists(list1, list2);
        for (ListNode p = result; p != null; p = p.next){
            System.out.print(p.val + " ");
        }
    }
}