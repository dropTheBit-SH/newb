package com.bit;

import java.util.Scanner;

/* 실습. 요급 계산하기
 * 상황. 주차장에 주차한 시간 계산하여 요금을 받는 프로그램
 * 요구사항
 * 1. 기본요금: 5000원
 * 2. 10분당: 500원 가산
 * 3. 콘솔 입출력 환경에서 싫행
 */

public class dd {

	static Scanner sc = new Scanner(System.in);  
	/* scanner는 유지 되려는 속성이 있어서 여러개를 만들면 에러가 남
	 * 하나만 생성해야함(main 안에 있으면 계속 )
	 * class 안에 있는  변수는 메서드 들이 다 사용 가능(효율적인 코드)
	 * 크래스 안에는 필드와 메서드가 있음
	 * 해당 스캐너는 필드얌!
	 * static 안에서 사용할거니까 static까지
	 */
	
	// static 함수 안에서는 static만 호출 가능
	public static void main(String[] args) {
		int in = getTime(); // 들어온 시간 입력 (시, 분) 
		int out = getTime(); // 나가는 시간 입력
		int diff = diffTime(in, out); // 시간차: 뺄셈, 호출할 때 변수 위치 주의
		double price = getPrice(diff); // 요금 계산하기
		
		System.out.println("price :" + price);
	}

	// 시간 정보를 키보드로 받아서 반환하는 함수
	static int getTime(){ // 함수의 지역성 때문에 반환이 필요함
		int t = 0; 
				// [library 활용] scanner는 직접 입력 처리는 안하지만, 키보드 입력값을 원하는 형으로 바꿔줌
		t = sc.nextInt(); // 정수 처리
		return t; // 반환
	}
	
	// 시간차 구하기(상위 두자리를 빼서 분단위 구분 처리)
	static int diffTime(int in, int out) {
		return out - in; 
	}
	
	// 요금 계산하기
	static double getPrice(int diff){
		double price = 0.0;
		return price;
	}
}

// 함수의 지역성으로 인해 (내용을 알 수 없으므로) 반환과 전달 필요
// 일일이 전달 할 수 없기 때문에 필드로 빼서 (자기 변수처럼) 사용 가능
