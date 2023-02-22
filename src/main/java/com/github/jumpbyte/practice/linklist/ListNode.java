package com.github.jumpbyte.practice.linklist;

/**
 * 自定义链表
 *
 * @author yuanjinan
 */
public class ListNode<T> {

    private T val;

    ListNode<T> next;


    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    /**
     * 求链表长度
     *
     * @return
     */
    public int length() {
        ListNode<T> node = this;
        int j = 0;
        while (node != null) {
            j++;
            node = node.next;
        }
        return j;
    }

    /**
     * 查找第k个元素
     *
     * @param k
     * @return
     */
    public ListNode<T> findKth(int k) {
        ListNode<T> p = this;
        int i = 1;
        while (i < k && p != null) {
            i++;
            p = p.next;
        }
        if (i == k) {
            return p;
        }
        return null;
    }

    /**
     * 查找倒数第k个节点
     * 思路：假设链表长度是n,倒数第k个节点也就是正数第n-k+1,先用一个指针p1让其先走k步，然后再用一个指针p2指向头节点，让p1,p2一起往前走直到p1走完
     * 此时，p2刚好走了n-k+1步
     * @param k
     * @return
     */
    public ListNode<T>  findBackKth(ListNode head, int k){
         ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1= p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    /**
     * 按照值查找
     *
     * @param targetVal
     * @return
     */
    public ListNode<T> find(T targetVal) {
        ListNode<T> p = this;
        while (p != null && p.val != targetVal) {
            p = p.next;
        }
        return p;
    }

    /**
     * 在第i个位置插入元素
     *
     * @param value
     * @param i
     * @param link
     * @return
     */
    public static <T> ListNode<T> insert(T value, int i, ListNode<T> link) {
        ListNode<T> p;
        ListNode<T> newNode;
        if (i == 1) {
            newNode = new ListNode<>();
            newNode.setVal(value);
            newNode.setNext(link);
            return newNode;
        }
        p = link.findKth(i - 1);
        if (p == null) {
            System.out.println("插入位置i不存在");
            return null;
        }
        newNode = new ListNode<>();
        newNode.setVal(value);
        newNode.setNext(p.next);
        p.setNext(newNode);
        return newNode;
    }

    /**
     * 删除第i个位置节点
     *
     * @param i
     * @param link
     * @param <T>
     * @return
     */
    public static <T> ListNode<T> delete(int i, ListNode<T> link) {
        ListNode<T> p;
        if (i == 1) {
            p = link.next;
            link.next = null;
            return p;
        }
        p = link.findKth(i - 1);
        if (p == null) {
            System.out.println("删除位置错误");
            return null;
        } else {
            ListNode<T> s = p.next;
            p.setNext(s.next);
            s.next = null;
            return link;
        }
    }


}
