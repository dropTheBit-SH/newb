package com.bit.demo.oop;

public class Phone {
// 전화번호, 통화를 할 수 있다.
	protected String number;
	
	public void rcv() {
		System.out.println("전화왔어요");		
	}
	public void call() {
		System.out.println("전화를 걸고 있어요");
	}
}
