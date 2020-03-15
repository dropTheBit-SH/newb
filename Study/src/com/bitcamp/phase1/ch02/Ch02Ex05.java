package org.comstudy21.ch02;

import java.util.Scanner;
import static java.lang.System.out;

public class Ch02Ex05 {
	public static void main(String[] args) {
		
		double area = 0; // 원의 면적
		double line = 0; // 원의 둘레의 길이
		double r = 0; // 반지름
		final double PI = 3.141592;
		
		// 원의 반지름을 입력 받아서 둘레의 길이와 면적을 출력하는 프로그램
		
		Scanner scan = new Scanner(System.in);
		
		out.printf("반지름: \n");
		r = scan.nextDouble();
		
		area = PI * (r * r);
		line = 2 * PI * r;
		
		out.printf("반지름 %.1f 일 때, 면적은 %.1f이고 둘레는 %.1f"
												, r, area, line);
		
		
	}
}
