package org.comstudy21.ch02;

import static java.lang.System.out;

import java.util.Scanner;

public class Ch02Ex03 {
	public static void main(String[] args){
		
		// 데이터 입력을 위한 scanner 객체 선언
		Scanner scan = new Scanner(System.in); //scn
		// system.in의 타입이 inputStream
	
		// 변수 선언
		int cnt01 = 0, price = 0, cnt02 = 0;
		
		out.printf("cnt01 입력: ");
		cnt01 = scan.nextInt();
		out.printf("price 입력: ");
		price = scan.nextInt();
		out.printf("cnt02 입력: ");
		cnt02 = scan.nextInt();
		
		//nextLine은 띄어쓰기 next는 그냥
		

	}
}

