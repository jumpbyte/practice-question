package com.github.jumpbyte.practice.constants;

/**
 * @author yuanjinan <yuanjinan@daojia.com>
 * @create 2017/11/3 22:57
 */
public class Test {

    public static void main(String[] args) {

        //以下情况值针对jdk 1.7 or 1.8有效
        //而针对1.6(含)以下，常量池中存放的是对象本身，而不是对象引用地址，因此以下输出都为false
        String str1 = new StringBuilder("Hello").append("World").toString();
        //按照首次出现原则，创建str1时，jvm会先将HelloWorld在堆中创建，并在常量池中存放其引用地址
        //因此str1.intern()拿到的地址与str1 同时指向了堆中的"HelloWorld"字符串实例
        System.out.println(str1.intern() == str1);// 首次出现原则，true
        String str2 = new StringBuilder("ma").append("in").toString();
        //字符串 main 于本方法名称一样，因此在运行时期间就已经创建在堆中，且常量池中存储了其引用地址
        //str2.intern() 实际则返回的是常量池中的那个引用，与str2本身不是同一块堆中的内存
        System.out.println(str2.intern() == str2);//false
    }
}
