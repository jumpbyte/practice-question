//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 5741 👎 0
package com.github.jumpbyte.leetcode.editor.cn;


public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 10};
        int[] nums2 = new int[]{2, 5, 6, 7};
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int[] nums = new int[m + n];
            int i = 0;
            int j = 0;
            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    nums[i + j] = nums1[i++];
                } else {
                    nums[i + j] = nums2[j++];
                }
            }
            if (i < m) {
                for (int i1 = i; i1 < nums1.length; i1++) {
                    nums[j + i1] = nums1[i1];
                }
            }
            if (j < n) {
                for (int i1 = j; i1 < nums2.length; i1++) {
                    nums[i + i1] = nums2[i1];
                }
            }
            String str = "";
            for (int num : nums) {
                str += num + ",";
            }
            System.out.println(str.substring(0, str.length() - 1));
            int mod = (m + n) % 2;
            if (mod > 0) {
                return nums[(m + n + 1) / 2 - 1];
            } else {
                return (nums[(m + n) / 2 - 1] + nums[(m + n) / 2]) / 2d;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}