package com.bitcamp.basic2.day4;

/**
클래스가 아니라는 것은 인스턴스 생성을 할 수 없다는 것이고
자료형의 개념을 갖지 않는다는 것이다
(인스턴스는 ~자료형의 변수)

인터페이스는 완전 미구현 상태로 추성메서드만 작성 가능
(실행되는 개념이 아니다)

필드는 상수만 사용 가능 final

기준을 최소한으로 정의
 */


public interface Phone { 
	
//	private final String serialnumber = "SS-model-phone"; // 오직 퍼블릭만 가능
	final String serialnumber = "SS-model-phone"; // final 생략 가능

	
	// 통화 기능
	abstract void recv(); // abstract(추상) 생략 가능
	void call();
	
}
