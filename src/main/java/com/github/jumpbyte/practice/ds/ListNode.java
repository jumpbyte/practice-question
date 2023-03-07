package com.github.jumpbyte.practice.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * leetcode 链表结构定义
 * @author yuanjinan
 */
public class ListNode {

    public int val;
    public ListNode next;

    /**
     * #19.
     */
    public ListNode() {
    }

    /**
     * #19.
     */
    public ListNode(int val) {
        this.val = val;
    }

    /**
     * #19.
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode curr = this;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return "[" + list.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
    }
}
