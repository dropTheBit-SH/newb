package com.bitcamp.basic2.tutorials;

public class Ex02 {
	
//	int[][]b = new int[20][2];
//	for(row=0;row<20;++row) {
//		for(col=0;col<2;++col) {
//			System.out.println([row][col]);
//		}
//	}
	
	public static void main(String[] args) {
		// y = ax + b
		// 임의 x와 y를 주었을 때, 직선 선상의 점이 아닌 경우 y의 오차를 출력한다
		// y'와 y의 오차

		int [][] data = new int[20][2]; 
		int i = 0; 

		for(int x=1; x<=20; ++x) {
			data[i][0] = x;
			data[i][1] = x;
			++i;
		}
		
		// 두 점을 잇는 직선 방정식
		
		int a = 2;
		int b = 1;
		for(i=0; i<20; ++i) {
			int x = data[i][0];
			int y = ( a * x ) + b; // 미리 약속한 처리식
			int offset = y - data[i][1]; // 기대하는 결과와의 차이
			if(offset != 0) {
				System.out.println("loss: "+offset);
			}
		}
	}
}
