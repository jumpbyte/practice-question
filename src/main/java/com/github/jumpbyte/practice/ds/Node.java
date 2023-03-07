package com.github.jumpbyte.practice.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * 图节点定义
 * @author yuanjinan
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public List<Node> neighbors;    // #133

    public Node() {
    }

    /**
     * #138、#116、#133.
     */
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        neighbors = new ArrayList<>();
    }

    /**
     * #138.
     */
    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    /**
     * 剑指Offer 36.
     */
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * #133.
     */
    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
