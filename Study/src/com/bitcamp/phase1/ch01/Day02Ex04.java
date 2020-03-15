package org.comstudy21.ch01;

import java.io.IOException;

public class Day02Ex04 {
	
	public static void main(String[] args) throws IOException{
		byte[] b = new byte[20]; // b라는 변수에 20개 byte값 저장
		System.out.print("성명입력: ");
		System.in.read(b);
		System.out.println(new String(b).trim()); // 배열을 스트링으로 형변환
		//trim은 문자열 앞뒤의 공백을 삭제(white space)
		System.out.println("이름 출력 완료");

		
		System.out.print("나이입력: ");
		System.in.read(b);
		System.out.println(Integer.parseInt(new String(b).trim()));
	}
}
