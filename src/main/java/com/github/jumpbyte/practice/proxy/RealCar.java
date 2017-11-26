package com.github.jumpbyte.practice.proxy;

public class RealCar implements Car {

	@Override
	public void run() {
		System.out.println("I'm running..");
	}

	@Override
	public void stop() {
		System.out.println("I'm stoping..");
	}

}
