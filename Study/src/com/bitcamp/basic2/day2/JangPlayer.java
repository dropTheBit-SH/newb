package com.bitcamp.basic2.day2;
/**
TDD 테스트기반
“JUnit” 작은 단위로 만들어서 테스트하면서 개발
QA(테스트검사)에서 주로 시행: assert 메세지를 띄우는 작업

점진적인 업그레이드를 위한 문법
상속과 추상

상속을 사용하는 이유:
매개변수를 변경한다는 것은 호출하는 방식을 바꾸는 것이기 때문에
메서드 내부의 코드를 터치하지 않고 메인에서 수정
->클래스를 새로 만들어서 작성

상속을 최소화하는 것을 권장
super클래스가 상속 / 단일 상속을 원칙

원클래스의 전체 내용은 그대로 두고, 일부 내용만 변경하고자 할 때,
확장의 개념을 사용하여 수정

상속의 장점: 코드의 변경 최소화

override의 개념 주의

private 사용시 접근 오류 해결
1) private 대신 protected: protected는 가족들끼리니까 사용한다는 느낌
	(단, protected는 침해의 문제가 있을 수 있어서 사용하지 않을 것을 권장 )
2) 사용처에서 다시 private 필드 하나 더 선언 --- 권장!
3) 메서드를 만들어라(간접접근 가능)
	get, set 메서드 생성
		p1.answer = 불가 
		p1.setA = 가능	
4) super를 사용 (super.answer처럼)
	(단, 똑같은 걸 메모리에 여러개 불러오게 되서 비효율적이다...)
	
상속을 사용할 때는 그대로 가져온다기보다는
업데이트를 위한 확장의 개념을 위해서 사용하기를 권장한다!

부모클래스 = new 자식클래스() 
자식클래스 = new 부모클래스() 는 불가
(자식은 부모한테서 물려받기 때문에 가능하지만,
부모는 자식한테서 받는게 없어서 불가능)

부모자식간의 타입변환
upcasting upsizing
downcasting downsizing

A a = new B() 자식으로 생성된 걸, 부모로 바꾼거
B b = B a 자식으로 생성됐기 때문에, 자식으로 바꿀 수 있다
(B b = new A()는 불가)

object class 최상위 클래스 (조상)
object는 바꾼다는 개념이 필요하다

*/

public class JangPlayer extends Player { // 하나만 된당 쉼표 써서 여러개는 앙대요
	
	private int answer;

	@Override // 메서드의 교체
	public void predict(int strike, int ball) {

		System.out.println(super.getAnswer());
//		super.predict(strike, ball); // super는 Player 타입을 의미
	} //Player의 내용을 가져옴, 단 private 빼고
	
	
/**
이름은 같지만 호출하는 방법이 다른 똑같은 2개
(오버라이딩은 한개 로딩은 여러개)
 	
매개변수가 다르다는 것은 호출하는 방법이 다르다 (-> 실행하는 내용의 차이가 생긴다)

기능적인 것은 유지하고
다양한 타입을 갖고자 할 때 사용한다(ex. 출력할 값의 다양화)

생성자 쪽에서 많이 사용한다


*/
//	@Overload
	public void viewAnswer() {
		System.out.println(answer); 

	}
	
	public void viewAnswer(String mode) {
		System.out.println(answer); 

	}
}
