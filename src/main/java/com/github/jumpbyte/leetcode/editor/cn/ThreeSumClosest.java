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
        System.out.println(solution.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            if(nums.length<3){
                return -1;
            }
            Integer result = null;
            for (int i = 0; i < nums.length-2; i++) {
                int x = nums[i];
                int y= nums[i+1];
                for (int j = i+2; j < nums.length; j++) {
                    int z = nums[j];
                    int sum = x + y + z;
                    int leftNum  = sum - target;
                    if(result == null){
                        result = leftNum;
                    }else {
                        result = Math.abs(result) > Math.abs(leftNum) ? leftNum : result;
                    }
                    if(sum > target){
                        break;
                    }
                }
            }
            return target + result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}