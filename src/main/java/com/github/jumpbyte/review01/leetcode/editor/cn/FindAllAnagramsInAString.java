package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;

import com.github.jumpbyte.leetcode.editor.common.*;

public class FindAllAnagramsInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 写法二：将map改为数组记录某个字符出现的次数
         *
         * @param s
         * @param p
         * @return
         */
        public List<Integer> findAnagrams(String s, String p) {
            int[] need = new int[26];
            int[] window = new int[26];
            int base = 'a';
            int needCount = 0;
            for (char c : p.toCharArray()) {
                need[c - base]++;
                if (need[c - base] == 1) {
                    needCount++;
                }
            }
            int left = 0, right = 0;
            int valid = 0;
            List<Integer> res = new ArrayList<>();
            while (right < s.length()) {
                int c = s.charAt(right) - base;
                right++;
                if (need[c] > 0) {
                    window[c]++;
                    if (window[c] == need[c]) {
                        valid++;
                    }
                }
                while (right - left >= p.length()) {
                    // 满足条件
                    if (valid == needCount) {
                        res.add(left);
                    }
                    int d = s.charAt(left) - base;
                    left++;
                    if (need[d] > 0) {
                        if (window[d] == need[d]) {
                            valid--;
                        }
                        window[d]--;
                    }
                }

            }
            return res;
        }
    }


    /**
     * 写法一：使用map记录某个字符出现的次数，通用滑动窗口模版
     * @param s
     * @param t
     * @return
     */
    public List<Integer> findAnagramsV1(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录结果
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }


    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        // put your test code here

    }
}