//车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
//
// 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有
// numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。 
//
// 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 4
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：trips = [[2,1,5],[3,3,7]], capacity = 5
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 10⁵ 
// 
//
// Related Topics数组 | 前缀和 | 排序 | 模拟 | 堆（优先队列） 
//
// 👍 227, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

public class CarPooling {
    public static void main(String[] args) {
        Solution solution = new CarPooling().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            //按照题意0 <= fromi < toi <= 1000，所以最多有1001个车站
            int[] nums = new int[1001];
            //差分解法
            Difference diff = new Difference(nums);
            for (int[] trip : trips) {
                //要上车的乘客数量
                int num = trip[0];
                int from = trip[1];
                //第 trip[2] 站乘客已经下车
                //即乘客在车上的区间是 [trip[1], trip[2] - 1]
                int to = trip[2] -1;
                diff.increment(from,to,num);
            }
            //res就是记录每一站车上当时的乘客数量
            int[] res = diff.result();
            //客车自始至终都不应该超载
            for (int num : res) {
                 if(capacity < num){
                     return false;
                 }
            }
            return true;
        }

        /**
         * 差分数组
         *
         * @author yuanjinan
         */
        private class Difference {
            /**
             * 差分数组
             */
            private int[] diff;

            /**
             * 输入一个初始数组，区间操作将在这个数组上进行
             *
             * @param nums
             */
            public Difference(int[] nums) {
                assert nums.length > 0;
                diff = new int[nums.length];
                //根据初始数组构造差分数组
                diff[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    diff[i] = nums[i] - nums[i - 1];
                }
            }

            /**
             * 给闭区间 [i, j] 增加 val（可以是负数）
             *
             * @param i
             * @param j
             * @param val
             */
            public void increment(int i, int j, int val) {
                diff[i] += val;
                //当 j+1 >= diff.length 时，说明是对 nums[i] 及以后的整个数组都进行修改，那么就不需要再给 diff 数组减 val 了
                if (j + 1 < diff.length) {
                    diff[j + 1] -= val;
                }
            }

            public int[] result() {
                int[] res = new int[diff.length];
                res[0] = diff[0];
                //根据差分数组构造结果数组
                for (int i = 1; i < diff.length; i++) {
                    res[i] = res[i - 1] + diff[i];
                }
                return res;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}