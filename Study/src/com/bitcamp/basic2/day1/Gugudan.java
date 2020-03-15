package com.bitcamp.demo;

public class Gugudan {

	public int print() {
		/* [기능 정의] 구구단: 2~9단까지 1~9까지의 곱셈 값들의 나열
		
		 * 정의와 구현, 인터페이스와 임플리먼트
		 * 규칙성(알고리즘): 반복, 상황에 따라: if
		 * 			   : 한 번, 최소 처리 단위를 찾아라(이후 연결, flow)
		 * 일정한 증감: for문	일정하지는 않지만 변화: while-loop문
		 */ 		   
		
		int di = 1;
		int cols = 3; /* 하나의 값이 여러개에 영향을 주는 경우 변수로 선언(일종의 설정값)
					   * 변수의 지역성(연관관계를 생각하고 영향을 주는 범위를 고려)
					   */
		
		for (int d=2; d<=9; d+=cols){ 
			for (int i=1; i<=9; i+=di){ /* 초기식; 조건식; 증감식 
									     * 증감식에서 i++ 보다는 i+=di로 변수를 넣으면 유지보수에 편함
									     */
				for (int k=0; k<cols; ++k) { 
					if ( (d+k) < 10) {
					System.out.print((d+k) + " x "+ i +" = " + ((d+k)*i)+ "\t");
					} // end of if: 2~9단까지만!
					
				} // end of for: 3개의 단씩 표현	(0~2까지 더하기)
				System.out.println();
			} // end of for: n단의 1~9까지 곱하기
			
			  /* i = 9 됐을 때까지만 실행-> 다음 코드의 위치 생각
			   */
			
		} // end of for: 2~9단까지 
		
		return 0;
	}
}
