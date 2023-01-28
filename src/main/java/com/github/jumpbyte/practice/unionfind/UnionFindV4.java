package com.github.jumpbyte.practice.unionfind;

/**
 * 并查集查询优化 - 按秩归并 + 路径压缩 针对find进行优化
 * 思想：任何有限集合(N个)元素都可以被一一映射为整数0到N-1，因此可以利用数组的下标和元素值形成某种映射，摒弃原来的SetNode的数据域
 * @className: UnionFindV4
 * @author: yuanjinan
 * @create: 2023/01/24
 **/
public class UnionFindV4 {


    /**
     * 元素下标和值形成映射关系，数组元素值代表所属父级的下标，元素值为负则是根节点，负数绝对值则表示集合的元素个数
     */
    private int[]  data;

    public UnionFindV4(int[] data) {
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
            //元素小往元素大的树合并，这里因为根元素存储的是负数，所以负数越小代表元素个数越大
            if(data[r1] < data[r2]){
                data[r1]+=data[r2];
                data[r2] = r1;
            }else {
                data[r2]+=data[r1];
                data[r1] = r2;
            }
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
        UnionFindV4 unionFind = new UnionFindV4(data);
        unionFind.union(1,2);
        unionFind.print();
        unionFind.union(2,3);
        unionFind.print();
        unionFind.union(4,0);
        unionFind.union(5,0);
        unionFind.print();
    }


}
