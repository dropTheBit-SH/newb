package com.bit;

public class Sample {
	
//	public static void att(Object arg) { // 모든 타입 가능(object에 포함되는) / 메서드 제약
//		arg.setNumber; 					 // 불가
//		arg.getClass();					 // 오브젝트-클래스를 가져오면 사용할 수 있는 범위가 많아짐
//		arg.getClass().getName();		 //
	
//		if(arg instanceof AdvPhone) { // AdvPhone 타입인 걸 알 수 있음(누구의 인스턴스인가) 
//			System.out.println("true");
//		}
//	}
		
	
	public static void main(String[] args) {
		
//		Object p1 = new AdvPhone(); // object는 최상위이기 때문에 무슨 타입이든 가능 
		Phone p1 = new AdvPhone(); // 가능 
//		Phone p1 = new Phone(); // Phone에는 setNumber가 없기 때문에 classCaseExpection 런타임 에러(이클립스가 아니라 실행 후 에러)
								// (뭘로 선언했는지가 중요)
								// 업캐스팅(서브 클래스의 객체가 수퍼 클래스 타입으로 형변환), 다운캐스팅
//		att(p1); // att는 오브젝트 타입으로 받으니까 실행에 문제가 없다
		
		
		
		p1.call();
		p1.rcv();
		AdvPhone p2 = (AdvPhone)p1; // 형변환 가능, 하나의 인스턴스를 두개의 타입으로 사용(다형성: 다양한 형으로 다룰 수 있다) 
									// (p2를 AdvPhone으로 보겠다)
									// (원래 AdvPhone 타입으로 사용되었었기 때문에 원래의 모습으로 돌린 것)
//		AdvPhone p2 = new Phone(); // 부모의 인스턴스에는 자식의 내용이 없기 때문에 불가
		p2.setNumber("");
		Phone p1 = new Phone(); //(부모)
		p1.rcv();
		p1.call();
		
		
		AdvPhone p2 = new AdvPhone(); //(자식) AdvPhone에 .rcv나 .call이 없는데도 "상속"해서 에러가 뜨지 않는다
		p2.setNumber("010-2698-0415");
		p2.rcv(); // 전화 받으면서 번호 보이기는 기능이 바뀌는게 아니라 화면만 바뀌는 거
		p2.call();
		
		
	}
}
