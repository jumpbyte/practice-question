package com.github.jumpbyte.practice.lock;

public class Reader extends Thread {
	
	private Buffer reader;

	public Reader(Buffer reader) {
		super();
		this.reader = reader;
	}

	@Override
	public void run() {
          reader.read();
          System.out.println("读取结束");
	}
}
