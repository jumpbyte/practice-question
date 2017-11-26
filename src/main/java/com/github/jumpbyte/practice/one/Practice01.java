package com.github.jumpbyte.practice.one;

/**
 * 排序算法练习
 * @author yuanjinan
 *
 */
public class Practice01 {

	public static void main(String[] args) {
		
		System.out.println("冒泡排序：");
		int[] nums=new int[]{3,1,9,11,8,20,15};
		maoPaoSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		
		System.out.println("插入排序：");
		int[] nums1=new int[]{3,1,9,11,8,20,15};
		insertSort(nums1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}
	
	public static void  maoPaoSort(int[] nums){
		
		for(int i=0;i<nums.length;i++){
			
			for (int j = 0; j < nums.length-i-1; j++) {
				
				if(nums[j]>nums[j+1]){
					int temp=nums[j+1];
					nums[j+1]=nums[j];
					nums[j]=temp;
				}
			}
		}
	}
	
	public static void insertSort(int[] nums){
		int len=nums.length;
		for (int i = 1; i < len; i++) {
			int j;
			int temp=nums[i];
			for(j=i;j<0;j--){
				if(nums[j-1]>temp){
					nums[j]=nums[j-1];
				}else{
					break;
				}
			}
			nums[j]=temp;
		}
	}
}
