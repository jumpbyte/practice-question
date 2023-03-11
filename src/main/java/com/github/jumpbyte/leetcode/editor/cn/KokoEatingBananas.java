//珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
//
// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：piles = [3,6,7,11], h = 8
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：piles = [30,11,23,4,20], h = 5
//输出：30
// 
//
// 示例 3： 
//
// 
//输入：piles = [30,11,23,4,20], h = 6
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10⁴ 
// piles.length <= h <= 10⁹ 
// 1 <= piles[i] <= 10⁹ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 470, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minEatingSpeed(int[] piles, int h) {
            //最小速度应该是 1，最大速度是piles数组中元素的最大值，因为每小时最多吃一堆香蕉，胃口再大也白搭嘛
            int left=1;
            //题目已知piles[i]最大不超过10^9,right取10^9+1,注意right是开区间
            int right = 1000000000 + 1;
            //最小速度 所以 此题是 二分搜索最左侧边界
            //左闭右开区间[left,right)
            while (left < right){
                int mid = left+(right - left) /2;
                if(eatHours(piles,mid) == h){
                     //收缩右侧边界
                     right = mid;
                }else if(eatHours(piles,mid) > h){
                    //怎么样使得eatHours返回的值更小
                    left = mid + 1;
                }else if(eatHours(piles,mid)<h){
                    //怎么样使得eatHours返回的值更大
                    right = mid;
                }
            }
            return left;
        }

        /**
         * 定义：吃香蕉的速度为x时，计算吃完所有香蕉所需要的时间并返回,函数随着x的增加单调递减
         * @param x  x
         * @return
         */
        public int eatHours(int[] piles,int x){
            int hours=0;
            for (int i = 0; i < piles.length; i++) {
                   hours += piles[i]/x;
                   //piles[i] 吃掉k根，还有剩余，必须休息，等下一个小时吃完
                   if(piles[i] % x>0){
                       hours++;
                   }
            }
            return hours;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}