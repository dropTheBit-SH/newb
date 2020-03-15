package org.comstudy21.ch02;
// 성명, 국어, 영어, 수학 점수를 입력 받아서 
// 총점, 평균을 출력하는 프로그램을 만들어라

// 자기소개를 데이터를 입력 받아서 출력하는 프로그램을 만들어라

import static java.lang.System.out;
import java.util.Scanner;

public class Ch02Ex06 {
	
	public static void main(String[] args) {
	
	String name = "";
	int kor = 0, eng = 0, mat = 0, sum = 0;
	double avg = 0;
	
	Scanner scan = new Scanner(System.in);
	
	out.printf("이름: ");
	name = scan.nextLine();
	out.printf("국어: ");
	kor = scan.nextInt();
	out.printf("영어: ");
	eng = scan.nextInt();
	out.printf("수학: ");
	mat = scan.nextInt();
	
	sum = kor + eng + mat;
	avg = sum / 3;
	
	out.printf("%s의 총점은 %d, 평균은 %.1f입니다.\n", name, sum, avg);
	out.printf("국어: %d, \t영어: %d, \t수학: %d", kor, eng, mat);
	
	}
}
