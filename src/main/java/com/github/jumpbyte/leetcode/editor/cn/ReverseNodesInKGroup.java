//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 1783 👎 0


package com.github.jumpbyte.leetcode.editor.cn;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        //1,2,3,4,5
        ListNode root = new ListNode(1);
        ListNode seconds = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        root.next = seconds;
        seconds.next = three;
        three.next = four;
        four.next = five;
        System.out.println(solution.reverseKGroup(root, 2));
    }
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

        public ListNode reverseKGroup(ListNode head, int k) {
            //链表遍历指针
            ListNode cur = head;
            //暂存本组head节点
            ListNode groupHead = null;
            //上一组的tail节点
            ListNode lastGroupTail = null;
            if (k == 1) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            int num = 1;
            while (cur != null) {
                if (num % k == 1) {
                    groupHead = cur;
                }
                ListNode tmp = cur.next;
                if (num % k == 0) {
                    ListNode reverseGroupHead = reverse(groupHead, cur);
                    if (lastGroupTail == null) {
                        dummy.next = reverseGroupHead;
                    } else {
                        lastGroupTail.next = reverseGroupHead;
                    }
                    lastGroupTail = groupHead;
                    groupHead = null;
                }
                cur = tmp;
                num++;
            }
            if (groupHead != null && lastGroupTail != null) {
                lastGroupTail.next = groupHead;
            }
            return dummy.next;
        }

        /**
         * 反转head至tail之间的节点
         *
         * @param head
         * @param tail
         * @return
         */
        private ListNode reverse(ListNode head, ListNode tail) {
            //1->2  2->1
            if (head == null || tail == null) {
                return null;
            }
            ListNode newHead = head;
            ListNode oldHead = newHead.next;
            while (newHead != tail) {
                ListNode tmp = oldHead.next;
                oldHead.next = newHead;
                newHead = oldHead;
                oldHead = tmp;
            }
            head.next = null;
            return newHead;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}