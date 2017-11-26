package com.github.jumpbyte.practice.lock;

public class Writer extends Thread {
	
	private Buffer writer;
	
	

	public Writer(Buffer writer) {
		super();
		this.writer = writer;
	}

	@Override
	public void run() {
		writer.write();
	}

}
