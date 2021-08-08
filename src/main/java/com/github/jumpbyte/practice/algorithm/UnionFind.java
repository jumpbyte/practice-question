package com.github.jumpbyte.practice.algorithm;


/**
 * 并查集模板示例
 */
public class UnionFind {

    /**
     * 初始：并查集数组元素个数，每次union成功减一
     */
    private int count;
    /**
     * 并查集数组元素
     */
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
