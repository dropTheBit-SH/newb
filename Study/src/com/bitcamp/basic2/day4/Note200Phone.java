package com.bitcamp.basic2.day4;

/**
 추상클래스를 상속하여 완전 구현 클래스를 만든다
이미 구현된 메서드도 있고, 직접 구현해야 하는 메서드도 있다

 interface 설계
 ▼ 
 abstract 틀
 ▼
 class 제품
 */

public class Note200Phone extends Note20Phone {
	
	public void call() {
		System.out.println("Note20Phone:call");
	}

}
