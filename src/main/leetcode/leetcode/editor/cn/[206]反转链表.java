//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 1877 👎 0


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



    /**
     * while 解决
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //1->2->3->3->4->5
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head!=null && head.next!=null){
            ListNode dnext= dummy.next;
            ListNode hnext = head.next;
            dummy.next = hnext;
            head.next = hnext.next;
            hnext.next = dnext;
        }
        return dummy.next;
    }

    /**
     * 递归 解决
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        //1->2->3->3->4->5
         if(head == null || head.next == null){
             return head;
         }
         ListNode root = reverseList(head.next);
         head.next.next = head;
         head.next = null;
         return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
