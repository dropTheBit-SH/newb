package com.bit.demo.flow;

public class Tutorial02 {

	public static void main(String[] args) {
		// 구구단 출력 3행 3열 형식으로 출력
		// 화면에 출력할 결과 - 규칙성(한 번 기준), 변화
		int cols = 4;
		for(int m=2; m < 9; m+=cols) {
			for(int k=1; k<=9; ++k){
				for(int i=0;i<cols;++i){
					int d = m + i;
					System.out.print(d+" x "+k+" = "+(d*k));
					System.out.print("\t");
				}
				System.out.println();
			}
		}
	}
	public static void sample02() {
		//sample01();
		// 행렬곱, 합
		int value = 1;
		for(int r=0; r < 5; ++r) {
			for( int c=0; c < 5; c++) {
				System.out.print(value+"\t");				
				value++;
			}
			System.out.println();
		}
	}
	public static void sample01() {
		int count = 0;
		for(int v = 1; v <= 25; ) {
			 System.out.print(v+"\t");
			 v++;
			 count +=1;
			 if( count == 5 ) {
				System.out.print("\n");
				count = 0;
			 }
		}

	}

}
