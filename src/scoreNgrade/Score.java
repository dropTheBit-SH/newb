package day03;

import java.util.Scanner;

/* 숙제
 * 0~100 사이의 점수는 정상 실행, 그 외에는 error!이거나 다시 실행 - 3가지 이상 고민하기
 * A+ A A- 형식으로 점수 표시하기 - 변수 추가 및 수정 자유
 * 0~2 - 3보다 작으면, 7~9 + 6보다 크면
 */

public class Score {
	static Scanner sc = new Scanner(System.in);
	static int score;
	static char grade;
	static char sign;
	
	public static void main(String[] args) {
		
		/*1번*/
		System.out.println("점수 입력: ");
		score = sc.nextInt();
		if(score<0 || score>100){
			System.out.println("점수를 다시 확인해주세요");
			main(null);
		}
		
		/*2번*/
		do{
			System.out.println("점수 입력: ");
			score = sc.nextInt();
		}while(score<=0 || score>=100);
		
		/*3번*/
		System.out.println("점수 입력: ");
		score = sc.nextInt();
		for(;score<=0 || score>=100;){
			System.out.println("점수를 다시 확인해주세요");
			main(null);
		}
			
		if(score>=90 && score<=100)	grade = 'A';
		else if(score>=80)			grade = 'B';
		else if(score>=70)			grade = 'C';
		else if(score>=60)			grade = 'D';
		else						grade = 'F';
	
		
		int tmp = score % 10;
		if(score==100){
							sign = '+';
		}else if(grade!='F'){
			if(tmp<3)		sign = '-';
			else if(tmp>6)	sign = '+';
			else			sign = ' ';
		}

		System.out.printf("%d점은 %c%c학점입니다", score, grade, sign);
	}

}
