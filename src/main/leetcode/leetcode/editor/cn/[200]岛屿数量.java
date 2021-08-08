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
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1268 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    /**
     * 并查集
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        //水域数量
        int waters = 0;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                 if(grid[i][j] == '0'){
                     waters++ ;
                 }else {
                     int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
                     for (int[] d : directions) {
                         int x = i + d[0];
                         int y = j + d[1];
                         if(x>=0 && x< rows &&  y>=0  && y < cols && grid[x][y] == '1'){
                             uf.union(x * cols+y,i * cols + j);
                         }
                     }
                 }
            }
        }
        return uf.getCount() - waters;
    }


    /**
     * 并查集模板类
     */
    public class UnionFind {

        private int count;
        private int[] roots;

        public UnionFind(char[][] grids){
            int rows = grids.length;
            int cols = grids[0].length;
            this.roots = new int[rows * cols];
            this.count = rows * cols;
            for (int i = 0; i < roots.length; i++) {
                roots[i] = i;
            }
        }

        public int find(int x){
            if(roots[x] == x){
                return x;
            }
            return roots[x] = find(roots[x]);
        }

        public void union(int x,int y ){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                 roots[rootX] = rootY;
                 count--;
            }
        }

        public int getCount(){
            return this.count;
        }
    }

    /**
     * BFS 解法
     * @param grid
     * @return
     */
    public int numIslandsBFS(char[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        Queue<int[]>  queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int count=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //遇到为1的岛屿
                if(grid[i][j] == '1'){
                    count ++;
                    grid[i][j]='0';
                    //将i,j坐标加入待查找相连岛屿坐标队列中
                    queue.add(new int[]{i,j});
                    while (!queue.isEmpty()){
                        //此循环是以 i,j为基准点 向上下左右方向逐步扩散查找所有相连的为1岛屿，并置为0，防止在下次外层循环出现
                        int[] point  = queue.poll();
                        int x = point[0];
                        int y = point[1];
                        if(x-1>=0 && grid[x-1][y] == '1'){
                            grid[x-1][y]='0';
                            queue.add(new int[]{x-1,y});
                        }
                        if(x+1 < rows && grid[x+1][y] == '1'){
                            grid[x+1][y]='0';
                            queue.add(new int[]{x+1,y});
                        }
                        if(y-1>=0 && grid[x][y-1] == '1'){
                            grid[x][y-1]='0';
                            queue.add(new int[]{x,y-1});
                        }
                        if(y+1 < cols && grid[x][y+1] == '1'){
                            grid[x][y+1]='0';
                            queue.add(new int[]{x,y+1});
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * DFS 解法
     * @param grid
     * @return
     */
    public int numIslandsByDFS(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid,i,j,rows,cols);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid,int x, int y,int rows,int cols){
        if(x<0 || y<0  || x>= rows || y>= cols || grid[x][y] =='0'){
            return;
        }
        grid[x][y] = '0';
        dfs(grid,x+1,y,rows,cols);
        dfs(grid,x-1,y,rows,cols);
        dfs(grid,x,y+1,rows,cols);
        dfs(grid,x,y-1,rows,cols);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
