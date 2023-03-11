//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics数组 | 排序 
//
// 👍 1823, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] merge1(int[][] intervals) {
            //按照每个区间start升序，start相等按照end升序，防止漏掉交集区间
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            if (intervals.length == 1) {
                return intervals;
            }
            int start = intervals[0][0];
            int end = intervals[0][1];
            List<int[]> result = new ArrayList<>();
            for (int i = 1; i < intervals.length; i++) {
                int[] cur = intervals[i];
                if (cur[0] <= end && cur[1] >= end) {
                    end = cur[1];
                }
                if (cur[0] > end) {
                    result.add(new int[]{start, end});
                    start = cur[0];
                    end = cur[1];
                }
                //最后一个元素，直接加入
                if (i == intervals.length - 1) {
                    result.add(new int[]{start, end});
                }
            }
            return result.toArray(new int[0][0]);
        }

        public int[][] merge(int[][] intervals) {
            LinkedList<int[]> res = new LinkedList<>();
            // 按区间的 start 升序排列
            Arrays.sort(intervals, (a, b) -> {
                return a[0] - b[0];
            });

            res.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] curr = intervals[i];
                // res 中最后一个元素的引用
                int[] last = res.getLast();
                if (curr[0] <= last[1]) {
                    last[1] = Math.max(last[1], curr[1]);
                } else {
                    // 处理下一个待合并区间
                    res.add(curr);
                }
            }
            return res.toArray(new int[0][0]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}