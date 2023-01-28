package com.github.jumpbyte.practice.unionfind;

/**
 * 并查集简化实现
 * 思想：任何有限集合(N个)元素都可以被一一映射为整数0到N-1，因此可以利用数组的下标和元素值形成某种映射，摒弃原来的SetNode的数据域
 * @className: UnionFindV2
 * @author: yuanjinan
 * @create: 2023/01/24
 **/
public class UnionFindV2 {


    /**
     * 元素下标和值形成映射关系，数组元素值代表所属父级的下标，元素值<0则认为是根节点
     */
    private int[]  data;

    public UnionFindV2(int[] data) {
        this.data = data;
    }

    /**
     * 查找x所属根元素的下标(查找x属于哪一个集合)
     * @param x
     * @return
     */
    public int find(int x){
        if(data==null || data.length==0){
            return  -1;
        }
        for (; data[x]>=0;x=data[x]);
        return x;
    }

    /**
     * 合并x,y所属不同的集合
     * @param x
     * @param y
     */
    public void union(int x,int y){
        int r1 = find(x);
        int r2 = find(y);
        if(r1 < 0 || r2<0){
            return ;
        }
        if(r1 != r2 ){
            data[r2] = r1;
        }
    }

    public int getSetCount(){
        int count=0;
        for (int i = 0; i < data.length; i++) {
             if(data[i]<0){
                 count++;
             }
        }
        return count;
    }

    public void  print(){
        for (int i = 0; i < data.length; i++) {
            System.out.println(i+" - "+data[i]);
        }
        System.out.println("集合个数："+getSetCount());
    }

    public static void main(String[] args) {
        // 0,3 -> 5  1,2,4
        int[]  data = new int[]{-1,-1,-1,-1,-1,-1};
        UnionFindV2 unionFind = new UnionFindV2(data);
        unionFind.union(0,3);
        unionFind.print();
        unionFind.union(2,5);
        unionFind.union(0,5);
        unionFind.print();
        unionFind.union(1,4);
        unionFind.print();
//由于union 总是让y所在集合2指向x所在集合1，在有些情况这样树高会越来越高 导致效率下降 如下示例所示
//        unionFind.union(1,0);
//        unionFind.print();
//        unionFind.union(2,0);
//        unionFind.union(3,0);
//        unionFind.print();
//        unionFind.union(4,0);
//        unionFind.union(5,0);
    }


}
