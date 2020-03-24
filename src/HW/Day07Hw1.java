package day07;

import java.util.Arrays;
import java.util.Random;

public class Day07Hw1 {

	public static Random rand = new Random();

	public static void main(String[] args) {
		int[] lotto = new int[6];
		
		 // 1번: 랜덤생성 이중for문 
		for(int i=0; i<6; i++){
			lotto[i] = 1 + rand.nextInt(45);
			for(int j=0; j<i; j++){
				if(lotto[i]==lotto[j])	i--;
			}
		}
		
		 // 2번: 랜덤호출
		int[] lottoNum = new int[45];
		for(int i=0; i<45; i++){
			lottoNum[i] = i+1;
		}
		
		for(int i=0; i<6; i++){
			lotto[i] = lottoNum[rand.nextInt(45)];
			for(int j=0; j<i; j++){
				if(i!=0 && lotto[i]==lotto[j])	i--;
			}	
		}
		
		 // 3번: 랜덤호출 후 해당 번호 삭제
		int[] lottoNum = new int[45];
		for(int i=0; i<45; i++){
			lottoNum[i] = i+1;
		}
		
		for(int i=0; i<6; i++){
			int tmp = rand.nextInt(45);
			lotto[i] = lottoNum[tmp];
			lottoNum[tmp] = 0;
			if(lotto[i]==0)		i--;
		}
		
		// 공통 출력
		System.out.println(Arrays.toString(lotto));
	}

}
