package com.bitcamp.basic2.tutorials;
/*
 * AI:ML:DeepL 
 * 

y = ax + b (일차함수) 직선
int a;
int b; 
int x;
int y = a * x + b;

출력 x를 1~20까지
[x,y]\n
여러개를 저장: 자료형이 같은 배열 - 요소 하나당 (x,y)

정답을 위한 배열을 만들고
for문을 이용해서 x값 만들고, y값 연산해서 저장 
배열 출력

배열로 표현하는 방법
1) 쪼개어 담기(범위 내에서 처리) // 1차배열: 변수 - 하나의 값
2) 2개씩 다차배열 // 2차배열: 1차배열 - 여러 개의 속성

data 배열에는 20개의 1차배열이 있고
그 1차배열은 2개의 요소가 있다
data 배열의 i번 배열의 요소 [0]번 [1]번

for - each: 요소 또는 각각의 데이터 단위로 반복한다
요소 번호 개념이 없다 -> 검색 등의 개념에서 사용
다차배열은 차수를 낮추는 단계를 표현하길 권장

*/



public class Ex01 {
	public static void main(String[] args) {
		
		int a = 1;
		int b = 0; 
		int x;
//		int [] data = new int[20];
		int [][] data = new int[20][2]; // 행열 개념 주의
		int i = 0; // 행 번호 

		for(x=1; x<=20; ++x) {
			int y = a * x + b;			
//			System.out.println("["+x+", "+y+"]");
			data[i][0] = x;
			data[i][1] = y;
			++i;
			
		}
		

		
//		for(int[] d1 : data ) { //(배열단위)
//				System.out.println("["+d1[0]+", "+d1[1]+"]");
//			}
		
		for(int[] d1 : data ) { // 1차배열 뽑은 상태에서 각 요소별로 출력(변수단위)
			System.out.print("[");
			for(int d2 : d1 ) {
				System.out.print(d2+","); // 쉼표가 2번 나옴
			}
			System.out.println("]");
		}
		
		
		
//		int[][][] set = new int[3][4][2];
//		for(int[][] d2: set) {
//			for(int[] d1: d2) {
//				for(int var: d1) {
//					
//				}
//			}
//		}
		
		//컬렉션 (자료구조)를 배우게 되면 자주 많이 사용하게 되는 반복법
//		Long[][][] set = new Long[3][4][2]; // 클래스Long
//		for(Long[][] d2: set) {
//			for(Long[] d1: d2) {
//				for(Long var: d1) {
//					var.byteValue(); // 꺼내서 사용
//				}
//			}
//		}
		
		
	}
}
