package com.github.jumpbyte.practice.two;

public class Context {
	
	private Long context;
	
	private String data;
	
	public Context(Long context) {
		super();
		this.context = context;
	}

	public Long getContext() {
		return context;
	}

	public void setContext(Long context) {
		this.context = context;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
