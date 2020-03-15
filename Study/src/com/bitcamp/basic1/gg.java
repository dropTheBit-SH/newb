package com.bit;

public class gg {

	public static void main(String[] args) {
//		// 정수 배열 1차 고정길이(넘으면 에러)
//		int[] ar1 = new int[10]; //0~9번
//		System.out.println(ar1); //id식별값(주소): 배열+int+at+16진수 위치표현
//		System.out.println(ar1.length); //길이는 함수간 전달처리를 위해 필요
//		//length 값 -1이 길이(참조를 많이 해서..)
//		
//		/*ar1.length=20; 불가 배열은 생성 뒤 고정 app append
//		 *ar1[10]=10;
//		 */
//		
//		for(int i=0; i<ar1.length; ++i) {
//			System.out.println(ar1[i]); // 9-i 역순(임의 접근)
//			
//		}

		
		// 20개의 임의 정수들을 저장하라
		int[] ran = new int[20] ;
		for(int i=0; i<ran.length-1; ++i) {
			ran[i] = (int)(Math.random()*10); // 0~1사이의 수
			//Math.pow(a, b); // 지수
			//Math.sqrt(a); // 제곱근
			//표준편차 
		}
		
		for(int i=0; i<20; ++i) {
			System.out.println(ran[i]);
		}
		
	

		
	}

}
