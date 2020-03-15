package com.bit.demo.flow;

public class Loop {
	// iterator
	// 조건?�� : 참인 ?��?��, ?���? 계속?��?�� ?��?��
	public static void main(String[] args) {
		// ?��?��
		int n = 0;
		while( !( 0 < n && n < 10 ) ) {
			// 반드?�� 멈춰?�� ?��?��... 조건?�� 거짓
			// ?��?�� ?��?��?��?��?��
			n += 3;
			if( n % 5 == 0) {
				break;
			}
		}
		System.out.println(n);

		// ?��보드 ?��?�� ?�� 값의 범위, ?��무�?? ?��?��
		do {
			n -= 2;
		}while( n > 0);
		System.out.println(n);
		
		// 번호:?��?�� - 배열
		for(int i=0; i < 20; i+=2) {// 초기?��; 조건?��; 증감?��
			System.out.println(i);			
		}
		// 1�? : for()
		// 2�? : for(){ for() {} }
		
//		for( : ) {
//			
//		}
			

	}

}
