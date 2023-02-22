//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics递归 | 链表 
//
// 👍 2927, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
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

        /**
         * 使用 双指针 分别遍历list1和list2
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy  = new ListNode(-1);
            ListNode p1 = list1,p2=list2,p= dummy;
            while (p1!=null && p2!=null){
                if(p1.val > p2.val){
                    p.next = p2;
                    p2 = p2.next;
                }else {
                    p.next = p1;
                    p1 = p1.next;
                }
                p=p.next;
            }
            //最后接上还有剩余的链表
            if(p1 != null){
                p.next = p1;
            }
            if(p2 != null){
                p.next = p2;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}