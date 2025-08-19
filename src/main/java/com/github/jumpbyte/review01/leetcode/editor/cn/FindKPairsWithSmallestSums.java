package com.github.jumpbyte.review01.leetcode.editor.cn;

import java.util.*;
import com.github.jumpbyte.leetcode.editor.common.*;

public class FindKPairsWithSmallestSums {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();
            //创建小顶堆,存储三元组 (num1[i], nums2[i], i)
            //i 记录 nums2 元素的索引位置，用于生成下一个节点
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
            for (int i = 0; i < nums1.length ; i++) {
                pq.offer(new int[]{nums1[i], nums2[0], 0});
            }
            while (k > 0 && !pq.isEmpty()){
                int[] cur = pq.poll();
                k--;
                res.add(Arrays.asList(cur[0], cur[1]));
                int nextIdx = cur[2] + 1;
                if (nextIdx < nums2.length) {
                    pq.offer(new int[]{cur[0], nums2[nextIdx], nextIdx});
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
        // put your test code here
        
    }
}