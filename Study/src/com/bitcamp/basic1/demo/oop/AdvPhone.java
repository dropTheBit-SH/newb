package com.bit.demo.oop;

public class AdvPhone extends Phone {
// Phone  의 기능을 확장한다....
//	private String number;
	public void setNumber(String number) {
		this.number = number;		
	}
	
	@Override
	public void rcv() {
		// 호출하는 방법 그대로
		//	실행결과가 다르게.... 
		System.out.println(number+"...");
		System.out.println("전화받기....");
	}
}
