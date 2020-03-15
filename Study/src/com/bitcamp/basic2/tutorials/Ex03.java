package com.bitcamp.basic2.tutorials;
/**
기본형인 데이터들은 2차 배열을 종종 사용한다
표의 개념

학생 점수: 1명 당 5개씩 점수(국, 영, 수, 총점, 평균)
type: double

 */

class Student{
	
	String name;
//	double [] scores; // 1) 배열 or 2) 개별 선언
	double [] kor;
	double [] eng;
	double [] math;
	double [] sum;
	double [] avg;
}

public class Ex03 {

	public static void main(String[] args) {
//		case01(); // 기본형 배열
		case02(); // 학생명: 문자열이어서 문제 발생
				  // 1) 스트링 배열을 만들 경우, 요소번호 연결을 해야해서 복잡해짐
				  // 2) 클래스 타입(복합형)을 만든다
		Student s = getStudent(); // static 멤버가 아닌 한 인스턴스는 생성해야한다
	}
	
	public static Student getStudent(){
		return new Student();
	}
	
	// 클래스 배열(not 인스턴스 배열)
	public static void case02() {
		Student[] std = new Student[5]; // 클래스이기 때문에 인스턴스가 생성된게 아니라 배열을 만든 것
										// 클래스는 반드시 new 인스턴스 생성 필요 (NPE에러)
		
//		Student[] std = new Student[] {
//				new Student(),
//				new Student(),
//				new Student(),
//				new Student(),
//				new Student(),
//		}
		for(int i=0; i<5; ++i) {
			std[i] = new Student(); // 인스턴스 생성해야한다...주의!!!!!!!!!!!
			std[i].name = "Kim"+ i;
			std[i].kor = 100;
			std[i].eng = 100;
			std[i].math = 100;
		}
	}
	
	
	public static void case01() {
		double[][] scores = new double[5][5]; // 행열 구분 5학생 5점수
		
		// s번 행에는 s번 학생 
		for(int s=0; s<5; s++) { // 1차 구조 표현시 번호 하나는 일일이 적어줘야함
			scores[s][0] = 100;
			scores[s][1] = 100;
			scores[s][2] = 100;
			scores[s][3] = 0;
			scores[s][4] = 0;
		}
		
		
		// 총점과 평균	
		for(int s=0; s<5; ++s) {
			for(int i=0; i<3; ++i) {
				scores[s][3] += scores[s][i]; 
			}
			scores[s][4] = scores [s][3]/3; // 총점은 한 번만 계산하면 되니까 쫓겨남
		}
		
		
		
		// 출력
		for(int r=0; r<5; r++) { //row 학생
			for(int c=0; c<5; c++) { //col 점수
				System.out.print( scores[r][c] + "\t");
			}
			System.out.println();
		}	
		
	}
}
