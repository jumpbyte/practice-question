package com.github.jumpbyte.practice.one;

import java.util.Stack;

public class StackQueue {
	
	static Stack<Integer> stack1=new Stack<>();
	static Stack<Integer> stack2=new Stack<>();
	
	
	public void add(Integer node){
		stack1.push(node);
	}
	
	public Integer remove(){
		
		if(stack2.isEmpty()){//pop时如果stack2为空，则将stack1内元素倒置入stack2,取栈顶元素
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		StackQueue queue=new StackQueue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}

}
