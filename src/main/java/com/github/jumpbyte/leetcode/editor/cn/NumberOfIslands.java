//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 2109, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //方向数组 上下左右
        private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int numIslands(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        //让水淹没i,j四周相邻的岛屿
                        dsf(grid, i, j);
                    }
                }
            }
            return res;
        }
        // 从 (i, j) 开始，将与之相邻的陆地都变成海水
        private void dsf(char[][] grid, int i, int j) {
            int m = grid.length, n = grid[0].length;
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return;
            }
            if(grid[i][j] == '0'){
                //已经是海水了
                return;
            }
            //先让自己淹没，防止走回头路
            grid[i][j] = '0';
            //让水蔓延[i,j]四周 上下左右
            for (int[] direction : directions) {
                int start_i = i + direction[0];
                int start_j = j + direction[1];
                dsf(grid, start_i, start_j);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}