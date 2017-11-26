package com.github.jumpbyte.practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHanlderImpl implements InvocationHandler {
	
	private  Car car;
	public  InvocationHanlderImpl(Car car) {
		this.car=car;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("begin call the real method");
		method.invoke(car, args);
		System.out.println("end call the real method");
		return null;
	}

}
