package day04;

import java.util.Scanner;

//switch
public class Day04Ex02 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
  
		int score = 0;
		String grade = "F";
		System.out.println("점수: ");
		score = sc.nextInt();
    
		while(!(score>0 && score<=100)){
			System.out.println("다시 확인하세요");
			System.out.println("점수: ");
			score = sc.nextInt();
		}
		
		switch(score/10){
			case 10: grade += "+"; break;
			case 9: case 8: case 7: case 6:
				switch(score%10){
					case 9: case 8: case 7:
						grade += "+"; break;
					case 0: case 1: case 2:
						grade += "-"; break;
				}
		}
		
		System.out.printf("점수는 %d, 학점은 %s", score, grade);
	}
}
