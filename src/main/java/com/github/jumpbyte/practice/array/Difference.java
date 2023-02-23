package com.github.jumpbyte.practice.array;

/**
 * 差分数组 实现算法模板
 * @author yuanjinan
 */
public class Difference {

    /**
     * 差分数组
     */
    private int[] diff;

    /**
     * 输入一个初始数组，区间操作将在这个数组上进行
     * @param nums
     */
    public Difference(int[] nums){
        assert nums.length>0;
        diff = new int[nums.length];
        //根据初始数组构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    /**
     * 给闭区间 [i, j] 增加 val（可以是负数）
     * @param i
     * @param j
     * @param val
     */
    public void increment(int i , int j,int val){
        diff[i]+=val;
        //当 j+1 >= diff.length 时，说明是对 nums[i] 及以后的整个数组都进行修改，那么就不需要再给 diff 数组减 val 了
        if(j+1 < diff.length){
            diff[j+1] -= val;
        }
    }

    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        //根据差分数组构造结果数组
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i-1] + diff[i];
        }
        return res;
    }

}
