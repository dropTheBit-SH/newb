package com.bit.demo.oop;

// 객체 지향 개념, 문법 - 독립적인...
// 독립된 객체들의 조합(연결)하는 방법... 찾아라....

public class Sample {
	// 함수 함수로 전달한다... 복사해서 주니까 값의 변경 여부
	public static void att(Object arg) {
		System.out.println(
				arg.getClass().getName()
				);
		if( arg instanceof AdvPhone) {
			System.out.println("true");
		}
	}
	
	public static void main(String[] args) {
		
//		Phone p1 = new Phone();// 실 생성 type ?
//		att(p1);
//		
//		p1.set
//		AdvPhone p2 = (AdvPhone)p1;
//		p2.setNumber("232323");
		
//		AdvPhone p2 = new Phone();
		// 부모, 자식 간 다형성
		

//		Phone p1 = new Phone();
//		p1.rcv();
//		p1.call();
//
//		AdvPhone p2 = new AdvPhone();
//		p2.setNumber("010-2020-3030");
//		p2.rcv();
//		p2.call();
		
		
		
		// 오버라이딩.... 오버로딩.....
	}

}
