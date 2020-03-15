package com.bitcamp.basic2.day2;

// 원 소스 원 클래스가 원칙이지만 실습 필요해서 작성하는거구 빌드하면 bin폴더에선 2개로 나뉨


//class B{
//	
//}

class A{
	private int n;
		// 요청한다는 것은 method를 만든다는 것
	
//	private B inst;
	
	//@overloading
	public A() {
		//기본 생성자
	}
	
	public A(A arg) {
		this.n = arg.getN();
		this.inst=arg.getInst(); 
		// 깊은 복사를 할 때, 필드 중에 클래스 타입이 있기 때문에 복잡(항상 기본형만 있는게 아니라...)
	}
	
	public A setN(int arg) {
		this.n = arg;
		return this; // new 또는 this로 A의 인스턴스를 반환
	}
	

}

public class Test02 {
	
	static A a;	
	
	public static void todo(A a) {
		
		// static에서 다른 메서드 호출하려면 모두 static
		// 정적인 것은 정적인 것만 쓸 수 있다
		
		a.setN(100);
		
	}
	
	public static void main(String[] args) {

//		A a = new A();
//		A b = a.setN(10); // Test가 a에게 요청한다
//		b.setN(100);
//		System.out.println( a == b );  
//		// A a와 A b 이름은 다르지만 인스턴스는 하나
//		// 결국 setN을 두번해도 같은 곳이기 때문에 결과는 같다
//		A c = new A();
//		c.setN(10);
//		System.out.println(a.equals(c)); 
//		// 참조값(주소)부터 비교 
//		// 값의 비교를 위해서는 override를 만들어서 바꾸거나, 새로 방법을 만들어서 비교한다

//		A a = new A();		
		a = new A();
//		todo(a); 
		// main의 a랑 todo의 a는 똑같은 A 매개변수를 갖는다
		// todo에서 main이 갖고 있는 인스턴스 수정 (a.setN(100);)
		// test 클래스가 a 클래스에게 지시 -> a 클래스가 값을 변경한다
		// 지시한다, 요청한다, 위임한다
		// 요청한다 : 메서드 안에서 처리한다
		// 위임한다: 필드 쪽에 붙어 있으면

		a.setN(10);		
		// 다른 곳(todo)에서 값 수정이 싫다 -> 사본 만들기
		// 참조가 같다는건 원본을 준다는 것
		A b = new A(a); // 복사생성자
		todo(b);
		
		System.out.println(a.getN());
	}
}
