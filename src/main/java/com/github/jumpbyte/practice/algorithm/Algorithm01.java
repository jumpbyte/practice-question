package com.github.jumpbyte.practice.algorithm;


import java.util.Stack;

/**
 * 题目：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * link: https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Algorithm01 {


    public static void main(String[] args) {
        int[] heights = new int[]{2,4,5,10,6,8,1,3,7,5,10};
        System.out.println(trap(heights));
    }


    public static int trap(int[] heights){
        int area = 0;
        Stack<Integer> stacks = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stacks.isEmpty() && heights[stacks.peek()] < heights[i]){
                int cur = stacks.pop();
                if(stacks.isEmpty()) break;
                int l = stacks.peek();
                int r = i;
                int h = Math.min(heights[l],heights[r]) - heights[cur];
                area +=(r - l - 1) * h;
            }
            stacks.push(i);
        }
        return area;
    }
}
