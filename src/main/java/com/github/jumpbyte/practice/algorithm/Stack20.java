package com.github.jumpbyte.practice.algorithm;

import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2759 👎 0

public class Stack20 {

    public static boolean isValid(String s) {
        if(s==null || s.isEmpty()){
            return true;
        }
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int l = chars.length;
        for (int i = 0; i < l; i++) {
            char c = chars[i];
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){
                    return false;
                }
                String pop = stack.pop();
                if(c == ')' && !pop.equals("(")){
                    return false;
                }
                if(c == ']' && !pop.equals("[")){
                    return false;
                }
                if(c == '}' && !pop.equals("{")){
                    return false;
                }
            }else {
                stack.push(String.valueOf(c));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.printf(Stack20.isValid("()")+"");
    }
}
