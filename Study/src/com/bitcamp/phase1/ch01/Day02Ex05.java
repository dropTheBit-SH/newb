package org.comstudy21.ch01;
// System.in.read() : 아스키코드로 키보드 입력을 받는다
import java.io.IOException;

public class Day02Ex05 {
	
	public static void test(String[] args){
		
		System.out.printf("%c, %d\n", '0', (int)'0'); // 0에 대해서 char와 10진수로 출력
		System.out.printf("%c, %d\n", 'A', (int)'A');
		System.out.printf("%c, %d\n", 'a', (int)'a');
	}
	
	
	public static void main(String[] args) throws IOException{
	
	// scanner를 통한 입력 (java.util)
	// 나이입력 -> 이름입력
	
	int age = 0; // 변수 선언 및 초기화
	int name = 0;
	
	System.out.println("나이입력: ");
	age = System.in.read() - '0'; // 엔터가 들어올 때까지 buffer 안에 값을 받는다
	System.in.read(); // enter = \n\r  (\n 빼기)
	System.in.read(); // (\r 빼기)
	
	System.out.println("이름입력: ");
	name = System.in.read(); 
	
	System.out.printf("나이:%d, 이름:%c\n", age, name);

	}
}
