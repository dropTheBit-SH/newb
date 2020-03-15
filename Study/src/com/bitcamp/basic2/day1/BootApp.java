package com.bitcamp;

/* import: 다른 패키지에 있는 클래스를 사용
 */
import com.bitcamp.demo.Gugudan;

public class BootApp {

	public static void main(String[] args) {
		Gugudan gugu = new Gugudan(); /* 생성하는 함수(생성자) 호출
									   */
		int n = gugu.print(); /* int n = 부분을 입력해주지 않으면 void 타입으로 생성됨
							   * 호출 시점의 표현을 중점적으로 생각하여 만든다
							   */
		
	} // end of main: main 함수가 종료되면 프로그램도 끝이 난다
} 
