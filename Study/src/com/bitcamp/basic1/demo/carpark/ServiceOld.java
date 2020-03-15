package com.bit.demo.carpark;
/**
 * 클래스 용법
 * @author BIT02-23
 *
 */
public class ServiceOld {
	
	//필드: private (안 보이게 숨김, 보안) !!!
	private int code; //필드선언 옆에다가 대입해서 초기값 넣지 말 것!! 아래에 생성자를 만들기!!
					  //따로 생성자 만드는 것 = 명시적으로 선언한다~
	
	//메서드: public (상호작용이 필요) !!!
	//생성자: (constructor) 인스턴스를 생성할 때 VM에서 자동으로 동작
	//ex. new scanner() - 뒤의 괄호 생성자
	
	public ServiceOld(){ //기본생성자: 서비스 타입의 인스턴스가 나가는거라서 자료형을 적지 않는다
						 //단, 꼭 써야하는 경우도 있다
						 //인스턴스를 위한 초기화 작업을 한다(초기값을 넣는다)
		code = 0;
	}
	
	//겟터(get뭐시기), 셋터(set뭐시기): 필드의 값을 처리(반환하거나 저장)
	//메서드는 필드에 대한 처리
	public int getCode(){ // 값의 반환 - 반환이기 때문에 자료형 맞추기 - 참조해야 하므로 public
		return code;
	}
	public void setCode(int code){ // 전달 받은 값의 저장 - void 값이 없기도 해서  
		this.code = code; 
		// code의 중복 사용으로 헷갈릴 수 있어서 this라는 예약어 사용하여 구분
		// this는 현재 인스턴스 의미(set을 호출하는 시점의 인스턴스)
		// 클래스 아뉘야
	}
}
