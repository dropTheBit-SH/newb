package com.bitcamp.basic2.day4;

/**
추상클래스는 추상메서드가 있는 클래스(추상메서드가 있기 때문에 추상클래스이다)
모든 메서드를 구현하지 않으면 인스턴스를 생성할 수 없는 것은 마찬가지이다
(인스턴스를 생성하려면 완전체여야한다)

클래스에 abstract 추가
 */

public abstract class Note20Phone implements Phone { 
									// phone 인터페이스를 구현하는 클래스(Phone에서 주는 제시나 기준 적용)
								    // implements 구현 가능한 상태로 만들겠다 

	public void showSerial(){
//		System.out.println(Phone.serialnumber); // 인스턴스를 만들 수 없기 때문에 Phone.
		System.out.println(serialnumber);
	}
	
	@Override
	public void recv() {
		System.out.println("받는중");
	}

//	@Override
//	public void call() {
//		System.out.println("거는중");
//	} 
	
	
	
	
}
