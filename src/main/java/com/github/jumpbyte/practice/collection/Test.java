package com.github.jumpbyte.practice.collection;

public class Test {

	public static void main(String[] args) {

		int[] a = new int[] { 1, 3, 6, 7, 8, 9, 10 };
		int[] b = new int[] { 4, 5, 8, 11, 15, 18 };
		int[] dest = new int[a.length + b.length];
		System.arraycopy(a, 0, dest, 0, a.length);
		System.arraycopy(b, 0, dest, a.length, b.length);
		
		System.out.println("返回的值为："+getIntByPos(a, b, 4));
        
	}

	//给定两个有序数组，将两个数组合并一个有序数组，给定一个pos下标，返回次下标在合并后数组的数值
	public static int getIntByPos(int[] a, int[] b, int pos) {

		int length = a.length + b.length;
		if (pos > length - 1|| pos<0) {
			System.out.println("超出索引");
			return -1;
		}
		int[] result = new int[length];

		int i = 0, j = 0, k = 0; // i:用于标示a数组 j：用来标示b数组 k：用来标示传入的数组

		while (i < a.length && j < b.length)
			if (a[i] <= b[j]) {
				result[k++] = a[i++];
			} else {
				result[k++] = b[j++];
			}
		/* 后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入 */
		while (i < a.length)
			result[k++] = a[i++];
		while (j < b.length)
			result[k++] = b[j++];
		
		System.out.println("合并后的有序数组为：");
		String str="";
		for (int k2 = 0; k2 < result.length; k2++) {
			str+=result[k2]+",";
			
		}
		System.out.println(str.substring(0, str.length()-1));
		return result[pos];
	}

}
