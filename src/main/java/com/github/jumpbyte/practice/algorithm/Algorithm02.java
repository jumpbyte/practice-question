package com.github.jumpbyte.practice.algorithm;



public class Algorithm02 {


    public static void main(String[] args) {

    }



    private ListNode merge(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return ans.next;
    }


    public class ListNode {

        private int value;
        private ListNode pre;
        private ListNode next;

        public ListNode(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getPre() {
            return pre;
        }

        public void setPre(ListNode pre) {
            this.pre = pre;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

}
