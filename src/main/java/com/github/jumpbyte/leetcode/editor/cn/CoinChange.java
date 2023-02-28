 //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics广度优先搜索 | 数组 | 动态规划 
//
// 👍 2308, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

 
  package com.github.jumpbyte.leetcode.editor.cn;

 import java.util.Arrays;

 public class CoinChange{
      public static void main(String[] args) {
           Solution solution = new CoinChange().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int coinChange(int[] coins, int amount) {
        //dp定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出
        int[] dp = new int[amount +1];
        //数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp,amount+1);
        //base case dp[0] = 0;
        dp[0] = 0;
        //外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            //内层 for 循环在求所有选择的最小值
            //当金额为i时的最少硬币数量也就是金额为i-coins[0],i-coins[1],i-coins[2].. i-coins[n]其中最少硬币数量+1
            for (int coin : coins) {
                if(i - coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
    //PS:为啥 dp 数组中的值都初始化为 amount + 1 呢，因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），
    // 所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。为啥不直接初始化为 int 型的最大值 Integer.MAX_VALUE 呢？
    // 因为后面有 dp[i - coin] + 1，这就会导致整型溢出
}
//leetcode submit region end(Prohibit modification and deletion)

  }