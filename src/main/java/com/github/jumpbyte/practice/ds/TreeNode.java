package com.github.jumpbyte.practice.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * leetcode 数结构定义
 * @author yuanjinan
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    /**
     * #94.
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * #94.
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Convert to level-order traversal string.
     *
     * <p>Example:
     * <pre>
     *      1──────────┐
     *              ┌──2
     *           ┌──3
     *           4
     * </pre>
     * is converted to {@code [1,null,2,3,null,4]}
     *
     * <p>Algorithm:
     * 1. add a null sentinel to each leaf
     * 2. level-order traversal including both nulls and valid values
     * 3. remove trailing nulls from the traversal output
     *
     * @return converted string
     */
    @Override
    public String toString() {
        ArrayDeque<Optional<TreeNode>> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.add(Optional.of(this));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll().orElse(null);
            if (node != null) {
                list.add(node.val);
                queue.add(Optional.ofNullable(node.left));
                queue.add(Optional.ofNullable(node.right));
            } else {
                list.add(null);
            }
        }

        int rightIndex = list.size();
        while (list.get(rightIndex - 1) == null) {
            rightIndex--;
        }
        return "[" + list.subList(0, rightIndex).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")) + "]";
    }
}
