//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵 
//
// 👍 937, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.github.jumpbyte.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        //并查集解法
        public void solveWithUF(char[][] board) {
            if (board.length == 0) return;
            int m = board.length, n = board[0].length;
            // 给 dummy 留一个额外位置
            UF uf = new UF(m * n + 1);
            int dummy = m * n;
            // 将首列和末列的 O 与 dummy 连通
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O')
                    uf.union(i * n, dummy);
                if (board[i][n - 1] == 'O')
                    uf.union(i * n + n - 1, dummy);
            }
            // 将首行和末行的 O 与 dummy 连通
            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O')
                    uf.union(j, dummy);
                if (board[m - 1][j] == 'O')
                    uf.union(n * (m - 1) + j, dummy);
            }
            // 方向数组 d 是上下左右搜索的常用手法
            int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
            for (int i = 1; i < m - 1; i++)
                for (int j = 1; j < n - 1; j++)
                    if (board[i][j] == 'O')
                        // 将此 O 与上下左右的 O 连通
                        for (int k = 0; k < 4; k++) {
                            int x = i + d[k][0];
                            int y = j + d[k][1];
                            if (board[x][y] == 'O')
                                uf.union(x * n + y, i * n + j);
                        }
            // 所有不和 dummy 连通的 O，都要被替换
            for (int i = 1; i < m - 1; i++)
                for (int j = 1; j < n - 1; j++)
                    if (!uf.connected(dummy, i * n + j))
                        board[i][j] = 'X';
        }
        class UF {
            private int count;
            private int[] parents;

            public UF(int n) {
                count = n;
                parents = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
            }

            public void union(int a, int b) {
                int rootA = find(a);
                int rootB = find(b);
                if(rootA == rootB){
                    return;
                }
                parents[rootA] = rootB;
                //两个连通分量合并成一个连通分量
                count--;
            }

            public int find(int x) {
                if (parents[x] != x) {
                    parents[x] = find(parents[x]);
                }
                return parents[x];
            }

            public boolean connected(int a,int b) {
                int rootA = find(a);
                int rootB = find(b);
                return rootA == rootB;
            }

            public int getCount() {
                return count;
            }
        }


        //dfs解法
        List<int[]> memo = new ArrayList<>();
        public void solve(char[][] board) {
            int m = board.length ,n = board[0].length;
            //找到四个边上的O的位置，递归蔓延到其他相邻的O的节点,将其一一更改为#,然后再剩下的O节点就是被X包围的节点，直接修改为X，最后将剩下的更改为O
            //左右边
            for (int i = 0; i < m; i++) {
                if(board[i][0]=='O'){
                    dfs(board,i,0);
                }
                if(board[i][n-1]=='O'){
                    dfs(board,i,n-1);
                }
            }
            //上下边
            for (int j = 1; j < n-1; j++) {
                if(board[0][j]=='O'){
                    dfs(board,0,j);
                }
                if(board[m-1][j] == 'O'){
                    dfs(board,m-1,j);
                }
            }
            //再将其剩下的O字符修改为X
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                   if(board[i][j] == 'O'){
                       board[i][j] ='X';
                   }
                }
            }
            //将#的更改为O
            for (int[] p : memo) {
                board[p[0]][p[1]] = 'O';
            }
        }

        public void dfs(char[][] board , int i, int j){
            int m = board.length ,n = board[0].length;
            if(i<0 || j<0 || i>=m || j>=n){
                return;
            }
            if(board[i][j] == 'X' ){
                return;
            }
            if(board[i][j] =='#'){
                return;
            }
            memo.add(new int[]{i,j});
            board[i][j] = '#';
            //上下左右
            dfs(board,i-1,j);
            dfs(board,i+1,j);
            dfs(board,i,j-1);
            dfs(board,i,j+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}