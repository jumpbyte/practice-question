//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics链表 
//
// 👍 1496, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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

        ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                //left=1 说明走到了链表正数第left个位置的节点，而此时的right就是left-right中间节点要反转的节点个数
                return reverseN(head, right);
            }
            //head.next 一直往前走，走了left位置 也就是left=1时，此时问题转化为对前n个节点进行反转的问题
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }


        //以head为起点反转前n个节点，这里对n递归递减计算前n个节点，base case:当n=1时，也就是链表正数第n个节点
        public ListNode reverseN(ListNode head, int n) {
            if (n == 1) {
                //记录第n个节点后继节点第n+1节点
                successor = head.next;
                return head;
            }
            //以head.next为起点，反转n-1个节点
            ListNode last = reverseN(head.next, n - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}