package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class KthSmallestElementInASortedMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            if (matrix == null || matrix.length == 0 ) {
                return -1;
            }
            //创建最小堆，存储三元组(matrix[i][j],i,j)
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            //矩阵每行内元素已经升序排序，首先把矩阵的每行第一列元素优先加入最小堆
            for (int i = 0; i < matrix.length; i++) {
                pq.offer(new int[]{matrix[i][0],i,0});
            }
            int res = -1;
            // 执行合并多个有序链表的逻辑，找到第 k 小的元素
            while(!pq.isEmpty() && k > 0){
                int[] cur = pq.poll();
                res = cur[0];
                k--;
                int i = cur[1];
                int j = cur[2];
                // 当前行的下一个元素，加入最小堆
                if (j + 1 < matrix[0].length) {
                    pq.offer(new int[]{matrix[i][j+1],i,j+1});
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        // put your test code here
        System.out.println(solution.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));
        
    }
}