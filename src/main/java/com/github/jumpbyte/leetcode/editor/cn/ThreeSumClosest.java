////给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
////
//// 返回这三个数的和。 
////
//// 假定每组输入只存在恰好一个解。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：nums = [-1,2,1,-4], target = 1
////输出：2
////解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//// 
////
//// 示例 2： 
////
//// 
////输入：nums = [0,0,0], target = 1
////输出：0
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 3 <= nums.length <= 1000 
//// -1000 <= nums[i] <= 1000 
//// -10⁴ <= target <= 10⁴ 
//// 
//// Related Topics 数组 双指针 排序 👍 1179 👎 0
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        //System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(solution.threeSumClosest(new int[]{321, 413, 82, 812, -646, -858, 729, 609, -339, 483, -323, -399, -82, -455, 18, 661, 890, -328, -311, 520, -865, -174, 55, 685, -636, 462, -172, -696, -296, -832, 766, -808, -763, 853, 482, 411, 703, 655, -793, -121, -726, 105, -966, -471, 612, 551, -257, 836, -94, -213, 511, 317, -293, 279, -571, 242, -519, 386, -670, -806, -612, -433, -481, 794, 712, 378, -325, -564, 477, 169, 601, 971, -300, -431, -152, 285, -899, 978, -419, 708, 536, -816, -335, 284, 384, -922, -941, 633, 934, 497, -351, 62, 392, -493, -44, -400, 646, -912, -864, 835, 713, -12, 322, -228, 340, -42, -307, -580, -802, -914, -142, 575, -684, -415, 718, -579, 759, 579, 732, -645, 525, 114, -880, -603, -699, -101, -738, -887, 327, 192, 747, -614, 393, 97, -569, 160, 782, -69, 235, -598, -116, 928, -805, -76, -521, 671, 417, 600, -442, 236, 831, 637, -562, 613, -705, -158, -237, -299, 808, -734, 364, 919, 251, -163, -343, 899}, 2218));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 双指针法
         * 先让数组有序，也就是需要先对数组进行排序
         * 然后每次固定一个元素，再去寻找另外两个元素，也就是双指针
         * 双指针法的代码实现
         * 利用 Arrays.sort(nums) 对数组进行排序。
         * 初始化一个用于保存结果的值 result = nusm[0] + nums[1] + nums[2] （不要自己设初值，直接从数组中抽取三个元素，假设这是最接近的三数之和，然后再更新就是了）。
         * 利用下标 i 对数组进行遍历，此时就是在固定第一个元素，注意，下标 i 的边界为 i < nums.length-2，否则设置指针的时候会出现数组越界。
         * 每次遍历的过程中设置两个指针，分别是 left = i + 1、right = nums.length - 1。
         * 检查 sum = nums[i] + nums[left] + nums[right]与 target 的距离，如果该距离比之前保存的 result 与 target 的距离更小，就更新 result。
         * 然后就是移动双指针。
         * 如果 sum 的值比 target 大，那么我们让 right--，因为数组是有序的，right --会使得下一次的 sum 更小，也就更接近 target 的值
         * 同理，如果 sum 的值 target 小，那么我们让 left++。·
         * left++ 和 right-- 的界限自然是 left != right，如果 left == right，说明我们已经将所有的元素都遍历过一遍了。
         * 重复上面的操作，直到i循环结束为止，返回 result。
         *
         * @param nums
         * @param target
         * @return
         */
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int result = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left != right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(sum - target) < Math.abs(result - target))
                        result = sum;
                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}