//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics数组 | 回溯 
//
// 👍 1650, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            char[][]  boards = new char[n][n];
            for (int row = 0; row < boards.length; row++) {
                for (int col = 0; col < n; col++) {
                    boards[row][col] = '.';
                }
            }
            backtrack(boards,new ArrayList<>(),0,n);
            return res;
        }

        // 路径：board 中小于 row 的那些行都已经成功放置了皇后
        // 选择列表：第 row 行的所有列都是放置皇后的选择
        // 结束条件：row 超过 board 的最后一行
        void backtrack(char[][] board, List<String> track, int row, int n){
            if(track.size() == n){
                res.add(new ArrayList<>(track));
                return;
            }
            int length = board[row].length;
            for (int i = 0; i < length; i++) {
                 //isValid
                if(!isValid(board,row,i)){
                    continue;
                }
                board[row][i] = 'Q';
                track.add(new String(board[row]));
                backtrack(board,track,row+1,n);
                board[row][i] = '.';
                track.remove(track.size()-1);
            }
        }

        /**
         * 是否可以在 board[row][col] 放置皇后
         * @param board
         * @param row
         * @param col
         * @return
         */
        public boolean isValid(char[][] board,int row, int col){
            int n = board.length;
            // 检查列是否有皇后互相冲突 row是下标 所以<=
            for (int i = 0; i <= row; i++) {
                if (board[i][col] == 'Q')
                    return false;
            }
            // 检查右上方是否有皇后互相冲突
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q')
                    return false;
            }
            // 检查左上方是否有皇后互相冲突
            for (int i = row - 1, j = col - 1;
                 i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q')
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}