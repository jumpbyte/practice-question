package com.github.jumpbyte.practice.two;

import java.util.HashMap;
import java.util.Map;

public abstract class Expression {
	
	private static Map<Integer,String> map=new HashMap<>();
	private static Map<Integer, String> table=new HashMap<>();
	//四百七十一万六千四百五十二  4716452
	static {
		map.put(0, "零");
		map.put(1, "一");
		map.put(2, "二");
		map.put(3, "三");
		map.put(4, "四");
		map.put(5, "五");
		map.put(6, "六");
		map.put(7, "七");
		map.put(8, "八");
		map.put(9, "九");
		table.put(0, "个");
		table.put(1, "十");
		table.put(2, "百");
		table.put(3, "千");
		table.put(4, "万");
		table.put(8, "亿");
	}
	
	public static void main(String[] args) {
		Long num=(long) (4716452L/(Math.pow(10,6)));
		System.out.println(parse(123456L));
	}
	
	public  static String parse(Long num){
	    int length=String.valueOf(num).length()-1;
		if(length >4 && length<8){
			return table.get(length-4)+table.get(4);
		}else if(length>8){
			return table.get(length-8)+table.get(8);
		}
		else{
			return table.get(length);
		}
	}

}
