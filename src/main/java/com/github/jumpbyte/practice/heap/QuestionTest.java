package com.github.jumpbyte.practice.heap;

import java.util.Scanner;

/**
 * @author yuanjinan
 */
public class QuestionTest {

    public static void main(String[] args) {
        Question1 question1 = new Question1();
        question1.run();
    }


    /**
     * 将一系列给定数字插入一个初始化为空的小顶堆H[],随后对任意给定的下标i,打印H[i]到根节点的路径
     * 输入样例：
     * 5 3   -5个元素 给定3个标i
     * 46 23 26 24 10   -小顶堆元素
     * 5 4 3   -下标i
     * 输出样例：
     * 24 23 10
     * 46 23 10
     * 26 10
     */
    public static class Question1 {

        int[] data;
        int size;

        public void run() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入最小堆元素个数:");
            int n = scanner.nextInt();
            System.out.println("请输入需要打印路径的i个数:");
            int m = scanner.nextInt();
            initMinHeap(n);
            for (int i = 0; i < n; i++) {
                System.out.println("请输入堆元素：");
                int x = scanner.nextInt();
                insert(x);
            }
            for (int i = 0; i < m; i++) {
                System.out.println("请输入下标i：");
                int j = scanner.nextInt();
                System.out.println("下标" + j + "到根元素的路径为:");
                System.out.print(data[j] + " ");
                while (j > 1) {
                    j /= 2;
                    System.out.print(data[j] + " ");
                }
                System.out.print("\n");
            }
        }

        public void initMinHeap(int n) {
            data = new int[n + 1];
            data[0] = Integer.MIN_VALUE;
        }

        public void insert(int x) {
            int i = ++size;
            for (; data[i / 2] > x; i /= 2) {
                data[i] = data[i / 2];
            }
            data[i] = x;
        }
    }

}
