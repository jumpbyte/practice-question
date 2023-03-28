 //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics数组 | 哈希表 
//
// 👍 16561, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
  package com.github.jumpbyte.leetcode.editor.cn;

 import java.util.HashMap;

 public class TwoSum{
      public static void main(String[] args) {
           Solution solution = new TwoSum().new Solution();
           solution.twoSum(new int[]{3,2,4},6);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int[] twoSum(int[] nums, int target) {
              // 维护 val -> index 的映射
              HashMap<Integer, Integer> valToIndex = new HashMap<>();
              for (int i = 0; i < nums.length; i++) {
                  // 查表，看看是否有能和 nums[i] 凑出 target 的元素
                  int need = target - nums[i];
                  if (valToIndex.containsKey(need)) {
                      return new int[]{valToIndex.get(need), i};
                  }
                  // 存入 val -> index 的映射
                  valToIndex.put(nums[i], i);
              }
              return null;
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }