package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class IntersectionOfTwoLinkedLists {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        //可以让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
        //如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA,p2 = headB;
            while (p1!=p2){
                if(p1 == null){
                    p1 = headB;
                }else {
                    p1 = p1.next;
                }
                if(p2 == null){
                    p2 = headA;
                }else {
                    p2 =p2.next;
                }
            }
            return p1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        // put your test code here
        
    }
}