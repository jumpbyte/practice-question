//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3557 👎 0


package com.github.jumpbyte.leetcode.editor.cn;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * 双指针法, 按照列计算每柱子最多能接的雨水
         * 空间复杂度： O(1), 时间复杂度O(N^2)
         *
         * @param height
         * @return
         */
        public int trapByDoublePoint(int[] height) {
            int sum = 0;
            for (int i = 0; i < height.length; i++) {
                if (i == 0 || i == height.length - 1) {
                    continue;
                }
                //记录右边柱子的最高高度
                int rHeight = height[i];
                //记录左边柱子的最高高度
                int lHeight = height[i];
                //找右边的最高柱子
                for (int r = i + 1; r < height.length; r++) {
                    rHeight = Math.max(height[r], rHeight);
                }
                //找左边最高的柱子
                for (int l = i - 1; l >= 0; l--) {
                    lHeight = Math.max(lHeight, height[l]);
                }
                int h = Math.min(rHeight, lHeight);
                if (h > 0) {
                    sum += h - height[i];
                }

            }
            return sum;
        }


        /**
         * 一分为二，快慢指针
         * 找到最大柱子maxH及索引maxIndex,用最大柱子将其分为两边，左边和右边
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            int sum = 0;
            //最大柱子
            int maxH = -1;
            //最大柱子的下标  [0,1,0,2,1,0,1,2,2,1,2,1]
            int maxIndex = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > maxH) {
                    maxH = height[i];
                    maxIndex = i;
                }
            }
            //左边遍历, 快慢指针
            for (int left = 0; left < maxIndex; left++) {
                for (int i = left + 1; i <= maxIndex; i++) {
                    if (height[i] < height[left]) {
                        sum += height[left] - height[i];
                    } else {
                        left = i;
                    }
                }
            }
            //右边遍历,快慢指针
            for (int right = height.length - 1; right > maxIndex; right--) {
                for (int i = right - 1; i >= maxIndex; i--) {
                    if (height[i] < height[right]) {
                        sum += height[right] - height[i];
                    } else {
                        right = i;
                    }
                }
            }
            return sum;
        }


        /**
         * 在双指针解法中，我们可以看到只要记录左边柱子的最高高度 和 右边柱子的最高高度，就可以计算当前位置的雨水面积，这就是通过列来计算。
         * <p>
         * 当前列雨水面积：min(左边柱子的最高高度，记录右边柱子的最高高度) - 当前柱子高度。
         * <p>
         * 为了的到两边的最高高度，使用了双指针来遍历，每到一个柱子都向两边遍历一遍，这其实是有重复计算的。我们把每一个位置的左边最高高度记录在一个数组上（maxLeft），右边最高高度记录在一个数组上（maxRight）。这样就避免了重复计算，这就用到了动态规划。
         * <p>
         * 当前位置，左边的最高高度是前一个位置的左边最高高度和本高度的最大值。
         * <p>
         * 即从左向右遍历：maxLeft[i] = max(height[i], maxLeft[i - 1]);
         * <p>
         * 从右向左遍历：maxRight[i] = max(height[i], maxRight[i + 1]);
         * <p>
         * 这样就找到递推公式。
         * 空间复杂度: O(N)
         * 时间复杂度: O(N)
         *
         * @param height
         * @return
         */
        public int trapByDP(int[] height) {

            int size = height.length;
            //记录每个柱子左边柱子最大高度
            int[] maxLeft = new int[size];
            //记录每个柱子右边柱子最大高度
            int[] maxRight = new int[size];
            maxLeft[0] = height[0];
            maxRight[size - 1] = height[size - 1];
            for (int i = 1; i < size; i++) {
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
            }
            for (int i = size - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], height[i]);
            }
            int sum = 0;
            for (int i = 0; i < size; i++) {
                int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
                if (count > 0) {
                    sum += count;
                }
            }
            return sum;
        }


    }


//leetcode submit region end(Prohibit modification and deletion)

}