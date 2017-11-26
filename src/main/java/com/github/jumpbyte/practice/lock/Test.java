package com.github.jumpbyte.practice.lock;

public class Test {

	public static void main(String[] args) {
		
		Buffer buffer=new Buffer();
		final Writer writer=new Writer(buffer);
		final Reader reader=new Reader(buffer);
		writer.start();
		reader.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				long start=System.currentTimeMillis();
				for(;;){
					if(System.currentTimeMillis()-start>5000){
						System.out.println("不等待了，尝试中断");
						reader.interrupt();
						break;
					}
				}
			}
		}).start();
	}

}
