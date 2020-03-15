package com.bitcamp.basic2.day2;

import java.io.IOException;

public class BootApp {
	public static void main(String[] args) throws IOException {
//		KeyboardParser kb = new KeyboardParser(); // key~클래스의 인스턴스인 kb(변수이기도 함)
		
//		int n = kb.getInt(); 
//		System.out.println(n);
		
// *****배열 번호에 따른 용도 미리 정의!! 번호로만은 알 수가 업숴!! *****
		
//		int[] count = kb.compare(123, 124); 		
//		System.out.println(count.length); // 길이를 알면 요소 번호의 범위를 알 수 있다(길이 n, 0~n-1번까지 n개가 있다)
//		
//		if(count[0]==3) {
//			System.out.println("Corrected");
//		}
		
//		KeyboardParser kb = new KeyboardParser(); // key~클래스의 인스턴스인 kb(변수이기도 함)
//		System.out.println("정답 3자리 정수: ");
//		int answer = kb.getInt();
//		
////	System.out.println(System.in.read());// 키보드의 buffer(메모리 공간)이 비워져있지 않으면 입력을 받지 않고 지나가버린다
////									 // buffer 안에 있는 쓰레기값을 비워줘야한다
////									 // 지우는법: buffer 안의 값을 불러온다
//		
//		System.out.println("물음값 3자리 정수: ");
//		int value = kb.getInt();
//		int[] rs = kb.compare(answer, value);
		
		Player[] list = new Player[2]; // 길이: 최대, 현재
//		Player[] list = new Player[2]{};
//		list[0] = new Player(); 
		list[0] = new JangPlayer(); // 상속하기 위해
		list[1] = new Player();
		
		
		// 게임 진행
		
		int caller = 0;
		while(true){ // 상태 개념에서 주로 사용 권장
			int cv =  list[caller].getCallValue(); // callVaue 0과 1이 서로 부르는 확인할 값(주고 받는 체계)
			int[] rs = list[1-caller].response(cv); // 0과 1이 서로 대답
			list[caller].predict(rs[0], rs[1]);  //list[caller]가 정답을 알려줌
												 // 매개변수의 순서 유의
			/*
			 * if else문 보다는 
			 * 배열 요소번호를 활용하여 쉽게 스위칭
			 */
			
			System.out.println(rs[0]+"S");
			System.out.println(rs[1]+"B");
			
			if( rs[0]==3 /*정답일때*/ ) { // while loop를 멈추기 위한 if break
				System.out.println(0+"Payer win");
				break;
			}
			// 순서 변경
			caller=(caller==1)?0 : 1;  // 0->1, 1->0
									   // 1) if문을 활용하여 a면 b로, b면 a로
									   // 2) ? :을 활용하여 적용(if문의 축약과 동일)
//			caller = 1-caller	       // 3) 산술식
		}
		
//		Player p1 = new Player();
//		Player p2 = new Player(); 
		// 룰은 같지만 데이터는 각각 다른 값을 갖을 때: 객체 활용
//		p1.answer = 279; // 누가 정했는가?! 현재는 main이 정한 상태!(마치 선수에게 심판이 정해준 것 같은 상태)
//		p2.answer = 327; // private 멤버는 외부에서 접근할 수 없다
		
		// 1 -> 2, 2 -> 1 (p1과 p2간의 요청과 응답) 스위칭	
		// 판단(정답이 아니면 멈춘다)
		// 배열 번호: 정수 -> swich 활용

//		int[] rs = p1.response(123);
//		int[] rs2 = p2.response(123);		
//		System.out.println(rs[0]+"S");
//		System.out.println(rs[1]+"B");
		
	}
}

