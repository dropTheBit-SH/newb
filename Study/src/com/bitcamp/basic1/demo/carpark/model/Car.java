package com.bit.demo.carpark.model;
// main 메서드가 있는 것과 패키지가 다르다
//언제 들어와서 언제 나간다의 기록
public class Car {
	
	private String no;
	private int intime;
	private int outtime; // 필드는 항상 프라이빗 선언 !!!!

	
	public int getOuttime() {
		return this.outtime; // 위 필드의 값을 리턴 (세터와 게터는 짝궁)
	}
	
	public void setOuttime(int outTime) {
		this.outtime = outTime;
	}

	public int getIntime() {
		return this.intime;
	}
	
	public void setIntime(int inTime2) {
		this.intime = inTime2;
	}
	
	
	
	public String getNo() {
		return this.no;
	}
	
	public void setNo(String carno) {
		this.no = carno;
	}
	
	
	@Override // 자바에게 옵션을 주는 명령 @
	public String toString(){ 
		String s = " "; 
		s += no + "(차랑번호): ";
		s += intime + " (들어온 시간)- ";
		s += outtime + "(나가는 시간)";  
		return s;
	}

	
	
	

}
