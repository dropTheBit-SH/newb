package com.bit;

public class A {
//public int a_num;
	
	private int a_num; //

	
	public A() {}
	public A(A origin) {
		this.a_num = origin.getAnum();
		
	}
	
	public int getAnum() {
		return a_num;
	}
	
	public int setAnum(int v) {
		return a_num = v; 
	}

	// default int a_num 기본값이기 때문에 따로 쓰지 않는다
	
	
}

