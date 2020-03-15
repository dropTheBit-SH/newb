package com.bit.demo.carpark;
/**
 * 클래스 용법
 * @author BIT02-23
 *
 */
public class ServiceOld2 {
	
	//overload(같은 이름의 메서드를 여러개: 추가)
	//함수명 같고, 매개변수 다르다
	public ServiceOld2() {
		//기본생성자
		//초기화
		code = 0;
		//System.out.append( , , ) // 여러개의 타입
	}

	public ServiceOld2(int code, String name) {
		this.code = code;
		this.name = name;
		code = 0;
	}
	
	
	//override(기존에 있던 걸 빼고 새로 넣는 것: 교체)
	//이클립스 기능으로 추가 가능 @override
	private int code; 
	private String name;
	
	public String toString() {
		//현재 인스턴스의 필드들을 문자열로 변환하다
		//Type@Address 별의미가 없어서 문자열로 바꿔서 출력 
		String s = "Service {" ; 
		s += "code:"+code+", ";
		s += "name:"+name+"}";
		return s;
	}

	//게터 세터의 자동생성: 라이브러리 or 이클립스 내부 기능
	public int getCode() {
		return code;
	}

	public void setCode(int code) { // void가 오기도 하지만 클래스 등이 올 수도 있음
		//세터: 값의 검사 필요 또는 만들지 말 것(보안성 문제)
		//생성자 만들 때만 사용
		//타입을 변경하면 무조건 명시 !!!!!
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}


//new Service();
//체이닝 연속하여 표현 / .으로 연결된 표현, 이어지는 메서드 형태 / return this가 달라질 수 있다
//예전에는 따로 코딩 / 별개의 문장으로 보임


