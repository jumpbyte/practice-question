package com.github.jumpbyte.practice.proxy;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
	     Car car=new RealCar();
	     InvocationHanlderImpl handler=new InvocationHanlderImpl(car);
	     Car proxy=(Car)Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), handler);
	     proxy.run();
	     proxy.stop();
	}

}
