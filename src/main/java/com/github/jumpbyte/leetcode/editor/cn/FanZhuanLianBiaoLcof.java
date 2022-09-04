//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
//
// Related Topics 递归 链表 👍 478 👎 0


package com.github.jumpbyte.leetcode.editor.cn;

public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        /**
         * 解法1
         *
         * @param head
         * @return
         */
        public ListNode reverseList1(ListNode head) {
            //1->2->3->3->4->5
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            while (head != null && head.next != null) {
                ListNode dnext = dummy.next;
                ListNode hnext = head.next;
                dummy.next = hnext;
                head.next = hnext.next;
                hnext.next = dnext;
            }
            return dummy.next;
        }


        /**
         * 解法2
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            //1->2->3->3->4->5
            if (head == null) {
                return null;
            }
            ListNode newHead = head;
            ListNode oldHead = newHead.next;
            while (oldHead != null) {
                ListNode tmp = oldHead.next;
                oldHead.next = newHead;
                newHead = oldHead;
                oldHead = tmp;
            }
            head.next = null;
            return newHead;
        }

        /**
         * 解法3：递归法
         * @param head
         * @return
         */
        public ListNode reverseList3(ListNode head) {
            //1->2->3->3->4->5
            if (head == null || head.next == null) {
                return head;
            }
            ListNode root = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return root;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
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
}