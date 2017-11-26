package com.github.jumpbyte.practice.gof;

/**
 * 懒汉，恶汉，双重校验锁，枚举和静态内部类
 * 
 * 静态内部类实现单例模式版本
 * @author yuanjinan
 *
 */
public class Singleton1 {
	
	private  static class SingletonHolder{
		private static final Singleton1 INSTANCE=new Singleton1();
	}
	
	private Singleton1(){
		
	}
	
	public static Singleton1 getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	public static void main(String[] args) {
		int sum=0;
		sum='8'-'5';
		System.out.println(sum);
		System.out.println('8'+'0');
		System.out.println('5'+'0');
		System.out.println('0'+'8');
	}

}
