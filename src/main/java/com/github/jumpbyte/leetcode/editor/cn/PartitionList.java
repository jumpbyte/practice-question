//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics链表 | 双指针 
//
// 👍 683, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.List;

public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
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
        public ListNode partition(ListNode head, int x) {
            if(head == null || head.next == null){
                return head;
            }
            //存储比x小的节点
            ListNode smaller = new ListNode(-1);
            //存储比x大的节点
            ListNode bigger = new ListNode(-1);
            //s, b 指针负责生成结果链表
            ListNode p = head,s = smaller,b = bigger;
            // p 负责遍历原链表，类似合并两个有序链表的逻辑
            // 这里是将一个链表分解成两个链表
            while (p!=null){
                if(p.val < x){
                    s.next = p;
                    s = s.next;
                }else {
                    b.next = p;
                    b = b.next;
                }
                // 断开原链表中的每个节点的 next 指针
                ListNode temp = p.next;
                p.next = null;
                p = temp;
            }
            s.next = bigger.next;
            return smaller.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}