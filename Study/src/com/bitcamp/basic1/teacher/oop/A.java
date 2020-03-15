package com.bit.demo.oop;

/**
 * 1. 복합적인 자료형 새로 만든다.
 * 2. 현실 모든 것을 추상적 개념화 ( 살아있다... ) 
 * - 클래스 : 연관성 깊은 것들을 한데 모은 단위....
 * 	- 최소, 필수 정보, 처리를 모아라
 * 	-	data 필요한 것... 
 * @author BIT02-00
 *
 */
public class A {
	// 사용 권한, 범위
//	public int a_num;	// (default) int a_num
	private int a_num;	// (default) int a_num
	
	public A() {}
	public A(A origin) {
		this.a_num = origin.getAnum();
	}
	public int getAnum() {
		return a_num;
	}
	public int setAnum(int v) {
		return a_num = v;
	}

}












