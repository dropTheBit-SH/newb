package com.bit;

public class cc {
	
	public static void main(String[] args) {
 
	int a = 5;
	int b = 2;
	int c = 8;
	int num;
	
	// 총합
	num = a + b + c;
	
	//누적(권장)
	num = 0;
	num = num + a;
	num = num + b;
	num = num + c;

	//축약
	num+=a;
	num+=b;
	num+=c;
	
	System.out.println(num);
	
	//int num2 = 100 % 10; // 나머지 연산자
	
	/* 
	 * 일정값을 넘지 않는 결과를 구할 때 활용할 수 있다
	 * 범위개념 주의: 100%10 0~9까지 10개, 100%16 0~15까지 16개
	 * 임의의 숫자 %('a'~'z')+'a': 임의의 문자열
	 */
	
	//int min = 1;
	//int max = 100;
	//int num2 = 10 % (max) + min; 
	
	/* 
	 * 0~99까지 나오지만 정수에 따라서 범위가 달라짐(일반화 필요함)
	 * 
	 * 
	 */
	
	// 값 끼리의 크기 비교: 논리 boolean true false
	// 조건식: 선택 실행, 식별값 필요
	System.out.println(10<=5); // t or f 값을 내보내기 때문에 ㄴ
	
	
	/*
	 *  논리 여러개 조합 및 비교(논리연산자는 논리값과 쓰인다) 
	 *  and와 or의 뉘앙스 차이 
	 *  not 연산자로 기존 조건식 활용
	 *  xor 비트연산(bit-wise): 다르면 1 / 반전개념 → 암호화 복호화 (cash)
	 */
	
	
	
	
	
	}
}
