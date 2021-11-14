原理：首先创建两个新节点，一个作为构建答案链表，一个作为返回值的新链表头结点。
开始循环遍历题传链表，只要题传链表的当前节点不为空就一直循环。
若当前节点的值不是题传val，那就把当前节点作为新链表的一项now.next = head;，同时now、head后移now = now.next;、head = head.next; 
若当前节点的值是题传val，那就直接head后移，now不动。
循环结束后，我们存在一个漏洞，如果题传链表的最后一个节点其值是题传val，那么我们的now不会执行now.next = head;但是在进行倒数第二个节点的操作时，由于我们的now执行了now.next = head;所以now.next.next就是最后一个节点，这会导致如下情况：
题目传入[1,2,6,3,4,5,6]我们返回[1,2,3,4,5,6]
所以循环结束后我们还需要判断若now.next存在且其val为题传val，那么我们需要执行now.next = null;将最后一个节点去除。
```
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode now = new ListNode(); // 构建新链表用
        ListNode ans = now; // 作为返回值

        while(head != null){
            if(head.val != val){
                now.next = head;
                // 只有当前节点可以被加入时才让now后移
                now = now.next;
            }
            head = head.next;
        }
        // 为防止输入[1,2,6,3,4,5,6]返回[1,2,3,4,5,6]
        if(now.next != null && now.next.val == val){
            now.next = null;
        }
        return ans.next;
    }
}
```
