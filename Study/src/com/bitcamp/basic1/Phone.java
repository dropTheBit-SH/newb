package com.bit;

// 전화번호, 통화 기능, 

public class Phone {
	
//	private String number;
	protected String number; // protected는 상속 가능 (family 공유~)
		
	
	public void rcv() {
		System.out.println("전화왔어요");
	}
	
	public void call() {
		System.out.println("전화를 걸고 있어요");
	}
}
