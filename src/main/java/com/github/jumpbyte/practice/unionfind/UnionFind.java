package com.github.jumpbyte.practice.unionfind;

/**
 * 并查集初版实现
 *
 * @className: UnionFind
 * @author: yuanjinan
 * @create: 2023/01/24
 **/
public class UnionFind {

    /**
     * 集合
     */
    private SetNode[]  sets;

    public UnionFind(SetNode[] sets) {
        this.sets = sets;
    }

    /**
     * 查找x所属根元素的下标(查找x属于哪一个集合)
     * @param x
     * @return
     */
    public int find(Object x){
        if(sets==null || sets.length==0){
            return  -1;
        }
        int i;
        //找到x所在下标索引
        for (i=0;i<sets.length && !sets[i].data.equals(x);i++);
        if(i>=sets.length) {
            return -1;
        }
        //查找x根元素下标i返回
        for(;sets[i].parent>=0;i=sets[i].parent);
        return i;
    }

    /**
     * 合并x,y所在的两个集合(若两个集合不相同)
     * @param x
     * @param y
     */
    public void union(Object x,Object y){
        if(sets==null || sets.length==0){
            return ;
        }
        int xRootIndex = find(x);
        int yRootIndex = find(y);
        if(xRootIndex<0 || yRootIndex<0){
            System.out.println("x,y 不都在集合中");
            return;
        }
        if(xRootIndex != yRootIndex){
            //把y所属集合合并到x的集合中
            sets[yRootIndex].parent = xRootIndex;
        }
    }

    /**
     * 是否属于同一个集合
     * @param x
     * @param y
     * @return
     */
    public boolean isSameSet(Object x,Object y){
        if(sets==null || sets.length==0){
            return false;
        }
        int xRootIndex = find(x);
        int yRootIndex = find(y);
        return xRootIndex == yRootIndex && xRootIndex!=-1;
    }



    static class SetNode{
        /**
         * 数据域
         */
        private Object data;
        /**
         * 所属父级元素的下标
         */
        private int parent;

        public SetNode(Object data, int parent) {
            this.data = data;
            this.parent = parent;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }
    }


    public static void main(String[] args) {
        // 1,2,3,4,5,6
        int n =6;
        SetNode[]  sets =new SetNode[n];
        for (int i = 0; i < n; i++) {
            SetNode node = new SetNode(i+1,-1);
            sets[i] = node;
        }
        UnionFind  unionFind = new UnionFind(sets);
        unionFind.union(1,2);
        unionFind.union(2,3);
        System.out.println(unionFind.isSameSet(1,4));
        unionFind.union(4,5);
        System.out.println(unionFind.isSameSet(1,4));
    }
}
