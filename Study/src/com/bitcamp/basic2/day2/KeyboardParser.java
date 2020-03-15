package com.bitcamp.basic2.day2;

import java.io.IOException;

// 소스 하나당 클래스 정의 하나만하길 권장

public class KeyboardParser {
	
	
	
		/**
		 * 키보드에서의 입력 값은 정수(int) - ASKII : 1byte : byte
		 * -> 입력 받을 값은 byte 타입이면 되지만, 정수는 int 타입 -> int 사용
		 * 
		 * 정수를 반환하고자 한다 (숫자를 계산하여 정수로 만드는 처리 필요)
		 * 
		 */
	
	// get(생성자가 아닌 사용자의 입장에서, return의 의미)
	// 장치로부터의 입력, 읽기: device driver에 접근 필요 -> 클래스나 라이브러리를 찾아라 
	public int getInt() throws IOException { 
//		int n = System.in.read(); // 한 글자만 ASKII로
								  // (시스템의.input장치의.read메서드에 요청한다)
						  		  // 모든 입력은 예외적인 상황이 있다  IOEception(InputOutput)
						  		  // 대응 1) throws (책임을 던진다...다른 소스에 문제를 줄 수 있어)
						  		  //    2) try catch 권장
//		System.out.println(n);
//		int rs = n - '0';
//		System.out.println(rs); // 문자도 결국 정수이다, 0과 '0'은 다르다
// ****** 키보드는 아스키 코드!! 자바는 유니코드!!*******
		int n;
		int num = 0; // 변수의 지역성(선언을 중괄호 밖에서)
		while((n=System.in.read()) != '\n') { /* \r\n 13은 CarriageReturn, \r값만 남아서 원하는 값 안 나옴
											   * 해결방법: 1) \r로 바꾸기  2) break
											   */
			if(n=='\r') { break;} // 2번 방법(계산 수식 전에 해야 cr 값 안 쓴다)
			num = num*10 + (n-'0'); // (leftShift 개념: 0*10+1의자리 -> 1*10+2 -> 12*10+3 -> 123)
		}
		
		
		System.in.read(); // byte 단위로 버퍼값을 빼다보니, 최종 마지막 문자까지 비운다
//		Scanner.nextLine();은 버퍼를 배우는 일까지 함
		
		
		
		//return 값을 받아 main에서 출력~!
		return num; /* 메서드를 만들 때 반환타입을 void로 하면 리턴을 안 쓰지만, 나머지 타입은 반드시 return 필요
		 		     * return은 하나만 사용하길 권장
		 		     */
		
	}//end of method
		
		/**
		 * 2개 정수를 비교하는 함수
		 * 
		 * 자리, 값을 비교한 결과 (배열을 활용)
		 * 3자리 정수를 비교한다(3자리 정수를 분해하여 각 값을 서로 비교한다)
		 * 
		 * 나누기 1: 3자리 -> 나누기 10: 2자리 -> 나누기 100: 1자리
		 * 나머지 10: 1의 자리 -> 나머지 100: 10의 자리 -> 나머지 1000: 100의 자리
		 * i=1; i<1000; i*=10 //  ((a/i)%10)
		 * 
		 * getInt <-> compare 
		 * 
		 * 배열을 사용할 때는, 각 요소를 번호로 접근한다
		 * 각 번호가 의미하는 바를 미리 정의하고 사용하기를 권장
		 * (1번은 strike, 2번은 ball)
		 */

	public int[] compare(int a, int b) {
		
		int strike = 0;
		int ball = 0; // 개수를 세는 변수는 항상 0으로 초기화(개수, 총합, 편차 등)
		// 값과 위치 준비
		for(int i=1; i<1000; i*=10) { // a변수의 위치값
			int av = (a/i)%10; // av는 i자리 값
			for(int j=1; j<1000; j*=10) { 
				int bv = (b/j)%10;
		// 값과 위치 비교		
				if(av==bv) {
					if(i==j) {
						strike++;
					}else {
						ball++;
					}
				}
			}
		}
		
		// 타입이 같은 여러개의 변수는 배열을 사용한다
		int[] pack = new int[2]; //배열을 만든다-> new키워드
		pack[0] = strike;
		pack[1] = ball;
		return pack; 
		
	}//end of method
}//end of class
