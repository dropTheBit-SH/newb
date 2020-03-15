package org.comstudy21.ch02;
//자기소개를 데이터를 입력 받아서 출력하는 프로그램을 만들어라
/// 성명, 나이, 사는곳, 전공, 직업, 특기, 키, 시력, 혈액형, 장래희망

import static java.lang.System.out;
import java.util.Scanner;

public class Ch02Ex07 {
	public static void main(String[] args) {
		
		String nam = "", adr = "", maj = "", job = "", hob = "", blo = "", dre = "";
		int age = 0;
		double hei = 0, sigR = 0, sigL = 0;  
		
		Scanner sc = new Scanner(System.in);
		
		out.printf("이름: ");
		nam = sc.nextLine(); 
		out.printf("주소: ");
		adr = sc.nextLine(); 
		out.printf("전공: ");
		maj = sc.nextLine();
		out.printf("직업: ");
		job = sc.nextLine();
		out.printf("특기: ");
		hob = sc.nextLine();
		out.printf("혈액형: ");
		blo = sc.nextLine();
		out.printf("나이: ");
		age = sc.nextInt(); 
		out.printf("키: ");
		hei = sc.nextDouble();
		out.printf("시력(우): ");
		sigR = sc.nextDouble();
		out.printf("시력(좌): ");
		sigL = sc.nextDouble(); 
		out.printf("장래희망: ");
		dre = sc.nextLine();
		
		
		out.printf("성명: %s\t 나이: %d\n", nam, age);
		out.printf("사는곳: %s\n", adr);
		out.printf("전공: %s\t 직업: %s\t 특기: %s\n", maj, job, hob);
		out.printf("키: %.1f\t 시력(우): %.1f\t 시력(좌): %.1f\t 혈액형: %s\n", hei, sigR, sigL, blo);
		out.printf("장래희망: %s\n", dre);
		
	}
}
