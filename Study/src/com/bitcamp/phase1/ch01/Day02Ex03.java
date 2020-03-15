package org.comstudy21.ch01;

import java.io.IOException;

public class Day02Ex03 {
	public static void main(String[] args) throws IOException{
		/* 데이터의 입력
		 * 1) System.in 
		 * 2) Scanner [권장]
		 */
		
		// 나이를 입력 받아서 출력한다 
		System.out.print("나이 입력: ");
		int age = System.in.read() - 48; // IOException 예외처리가 필요하다
		
		System.out.printf("나이: %d\n", age); 
		// !!! ASKII코드(또는 유니코드)로 인식하여 원하는 값이 출력되지 않는다
		// 0 : 48, a: 97, A: 65 (48 = '0')
		// !!! read는 한 번에 한 글자만 읽어 올 수 있다
		
//		age = age *10; 
//		age += System.in.read() -48;


	}
}
