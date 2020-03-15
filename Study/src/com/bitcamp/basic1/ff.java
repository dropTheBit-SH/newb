package com.bit;
/* 
 * 제어문 연습
 * 정수의 출력
 * 1~25까지 연속하는 정수 출력
 * 여러가지 방법을 찾는다
 * 5행 5열의 형태
 */

public class ff {

	public static void main(String[] args) {
		
		//System.out.println("1 2 3 4 5");
		//System.out.println("1 2 3 4 5");
		
		int count = 0;
		for(int v = 1; v <= 25;) {
			System.out.print(v+"\t");
			v++;
			count++;
			
			if(count == 5) { // 행단 개수 (행단개수가 다르다면 변수를 하나 추가하여 작성)
				System.out.print("\n");
				count= 0; // 횟수를 세고 줄을 바꾸기 위해
			}
		}
		
		int value = 1;
		for(int r=0; r<5; ++r) { // 규격을 맞춰넣고 값을 기입하기 위해 r행 c열
			for( int c=0; c<5; c++) {
				System.out.print(value+"\t"); // 변하는 값 value
				value++;
			}
			System.out.println(); // 행바꾸기
		}
		
		/* 아래의 코드는 행열의 위치를 잡을 수 있기 때문에
		 * 값을 검색해야 하는 경우 등에 쓰인다
		 */
		
		//구구단 출력 3행 3열
		//화면에 출력할 결과의 규칙성을 찾는다(한 번 기준) + 반복한다 
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		int cols = 3; // 변수를 옵션으로 설정해야 추후에 수정이 쉽다(상수를 변수처리)
		for(int m=2; m<9; m+=cols) {  // 블럭의 반복, m변수는 첫번째 단값
			for(int k=1; k<=9; ++k) {  // n단
				for(int i=0; i<cols; ++i) { // x n
					int d = m + i; 
					System.out.print(d+" x " +k+" = "+(d*k));
					System.out.print("\t");
				}
				System.out.println();
			}
			
		}	
	
	}
}
