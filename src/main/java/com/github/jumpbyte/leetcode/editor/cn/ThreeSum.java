//////给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0
// 且
////不重
//////复的三元组。 
//////
////// 注意：答案中不可以包含重复的三元组。 
//////
////// 
//////
////// 示例 1： 
//////
////// 
//////输入：nums = [-1,0,1,2,-1,-4]
//////输出：[[-1,-1,2],[-1,0,1]]
////// 
//////
////// 示例 2： 
//////
////// 
//////输入：nums = []
//////输出：[]
////// 
//////
////// 示例 3： 
//////
////// 
//////输入：nums = [0]
//////输出：[]
////// 
//////
////// 
//////
////// 提示： 
//////
////// 
////// 0 <= nums.length <= 3000 
////// -10⁵ <= nums[i] <= 10⁵ 
////// 
////// Related Topics 数组 双指针 排序 👍 4898 👎 0
////
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：用3个指针k,i,j，只不过k正常遍历（保证下一次移动到的元素不与上一次的相同，第一次开始的k因为前面没有元素故为不同），
         * 因为要求nums[k]+nums[i]+nums[j] = 0，则为求nums[i]+nums[j] = -nums[k],当确定时-nums[k]，i增大，j就减小，则i，j为对碰双指针，
         * i = k+1开始遍历（同样保证下一次移动到的元素不与上一次的相同，j同理i），j=l-1开始遍历（j向左移动且nums[i]+nums[j] > target），当i==j是，双指针遍历结束。
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int l = nums.length;
            Arrays.sort(nums);
            if (nums.length <= 2) {
                return new ArrayList<>();
            }
            for (int k = 0; k < l; k++) {
                //保证前后两次枚举k下标对应数值不相同
                if (k > 0 && nums[k - 1] == nums[k]) {
                    continue;
                }
                int target = -nums[k];
                //声明i,j 分别将i，j放在数组两端
                for (int i = k + 1; i < l; i++) {
                    //保证前后两次枚举i下标对应数值不相同
                    if (i > k + 1 && nums[i - 1] == nums[i]) {
                        continue;
                    }
                    //j在最后端
                    int j = l - 1;
                    //保证i始终在j的左侧
                    while (j > i && nums[i] + nums[j] > target) {
                        //和大于target 说明j端的值太大，要继续左移
                        j--;
                    }
                    // 如果指针重合，随着 i 后续的增加
                    // 就不会有满足 nums[k]+nums[i]+nums[j]=0 并且 i<j 的 nums[j] 了，可以退出循环
                    if (i == j) {
                        break;
                    }
                    if (nums[k] + nums[i] + nums[j] == 0) {
                        List<Integer> tempList = Arrays.asList(nums[k], nums[i], nums[j]);
                        res.add(tempList);
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}