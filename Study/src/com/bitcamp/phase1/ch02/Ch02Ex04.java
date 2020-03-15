package org.comstudy21.ch02;

import java.util.Scanner;

import static java.lang.System.out;

public class Ch02Ex04 {
	public static void main(String[] args) {
		//Scanner를 이용해서 가로 길이, 세로 길이를 입력 받아서 직사각형의 넓이를 출력하는 프로그램을 만드세요
		
		Scanner sc = new Scanner(System.in);
		
		double width = 0, height = 0; 
		out.print("가로 길이: \n");
		width = sc.nextInt();
		out.printf("세로 길이: \n");
		height = sc.nextInt();
		
		double area = 0;
		area = width * height;
		
		out.printf("가로 %.1f, 세로 %.1f인 직사각형의 넓이는 %.1f입니다."
				, width, height, area);
	}
}
