package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class MergeKSortedLists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0){
                return null;
            }
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            //用最小堆存储K个链表头节点，找出最小头结点
            PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
            for (ListNode head : lists) {
                if(head!=null){
                    pq.add(head);
                }
            }
            while (!pq.isEmpty()){
                //获取最小头结点，添加到结果链表
                ListNode minNode = pq.poll();
                p.next = minNode;
                if(minNode.next!=null){
                    pq.add(minNode.next);
                }
                p = p.next;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here
        ListNode[] lists = new ListNode[]{
                ListNode.createHead(new int[]{1,4,5}),
                ListNode.createHead(new int[]{1,3,4}),
                ListNode.createHead(new int[]{2,6})
        };
        ListNode result = solution.mergeKLists(lists);
        ListNode.print(result);
        
    }
}