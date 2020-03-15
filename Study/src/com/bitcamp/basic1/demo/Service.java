package com.bit.demo;
/**
 * 클래스 용법
 * @author BIT02-00
 *
 */
public class Service {
	// 필드 : private
	private int code;
	private String name;
	
	// 메서드 : public

	@Override
	public String toString() {
		// 현재 인스턴스의 필드들을 문자열로 변환한다...
		// Type@Address
		String s = "Service {";
		s += "code:"+code+", ";
		s += "name:"+name+"}";
		return s;
	}
	
	// 생성자 : VM 자동으로 만들어준다...
	public Service(){
		// 기본생성자
		// 초기화
		code = 0;
	}
	// Overload : 함수명 같고, 매개변수가 다르다.
	public Service(int code, String name){
		this.code = code;
		this.name = name;
	}

//	@Override // 함수를 교체한다..
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		//검사
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 겟터, 셋터 : 필드 값 반환,저장
	
	
	
	
	
	
	
	
	
	
	

}
