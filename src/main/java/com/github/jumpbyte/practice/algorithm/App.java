package com.github.jumpbyte.practice.algorithm;

/**
 * @className: App
 * @author: yuanjinan
 * @create: 2019/07/25
 **/
public class App {

    public static void main(String[] args) {
        //testFixSnowflake();
        testMask();
        //toBinary(98074161038532608L);
    }

    private static void testMask() {
        //计算12位能耐存储的最大正整数，相当于：2^12-1 = 4095
        long seqMask = -1L ^ (-1L << 12L);
        System.out.println("seqMask: " + seqMask);
        toBinary(217080014192L);
        System.out.println(1L & seqMask);
        System.out.println(2L & seqMask);
        System.out.println(3L & seqMask);
        System.out.println(4L & seqMask);
        System.out.println(4095L & seqMask);
        System.out.println(4096L & seqMask);
        System.out.println(4097L & seqMask);
    }


    private static void testFixSnowflake() {

        long timestamp = 1564067502121L;
        long startTimestamp = 1540684800000L;
        long datacenterId = 12L;
        long workerId = 10L;
        long sequence = 0L;

        System.out.printf("\ntimestamp: %d \n", timestamp);
        System.out.printf("start_timestamp: %d \n", startTimestamp);
        System.out.printf("datacenterId: %d \n", datacenterId);
        System.out.printf("workerId: %d \n", workerId);
        System.out.printf("sequence: %d \n", sequence);
        System.out.println();
        System.out.printf("(timestamp - start_timestamp): %d \n", (timestamp - startTimestamp));
        System.out.printf("((timestamp - start_timestamp) << 22L): %d \n", ((timestamp - startTimestamp) << 22L));
        System.out.printf("(datacenterId << 17L): %d \n", (datacenterId << 17L));
        System.out.printf("(workerId << 12L): %d \n", (workerId << 12L));
        System.out.printf("sequence: %d \n", sequence);

        long result = ((timestamp - startTimestamp) << 22L) |
                (datacenterId << 17L) |
                (workerId << 12L) |
                sequence;
        System.out.println(result);
//        timestamp: 1564067502121
//        start_timestamp: 1540684800000
//        datacenterId: 12
//        workerId: 10
//        sequence: 0
//
//        (timestamp - start_timestamp): 23382702121
//        ((timestamp - start_timestamp) << 22L): 98074161036918784
//        (datacenterId << 17L): 1572864
//        (workerId << 12L): 40960
//        sequence: 0
//        98074161038532608

    }

    private static void toBinary(long n) {
        //我们可以直接利用移位操作对一个十进制数进行移位操作，即：将最高位的数移至最低位（移63位），
        //除过最低位其余位置清零，使用& 操作，可以使用和1相与（&），由于1在内存中除过最低位是1，
        // 其余63位都是零，然后把这个数按十进制输出；再移次高位，做相同的操作，直到最后一位
        for(int i = 63 ;i>=0;i--){
            System.out.print(n>>>i & 1);
        }
        //System.out.println(Long.toBinaryString(n));
    }

}
