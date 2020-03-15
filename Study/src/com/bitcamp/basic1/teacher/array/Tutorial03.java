package com.bit.demo.array;

public class Tutorial03 {

	public static int[] ballCount(int a, int b) {
		int[] count = new int[2];//[0]Strike [1]Ball
		// 10진 정수 : 일, 십, 백
		// 정수 -> []
		String as = String.valueOf(a);//""+a
		char[] achar = as.toCharArray();
		String bs = String.valueOf(b);//""+a
		char[] bchar = bs.toCharArray();
		
		System.out.println( achar );
		System.out.println( bchar );

		for(int ai=0; ai < achar.length; ++ai) {
			for(int bi=0; bi < bchar.length; ++bi) {
				if( achar[ai] == bchar[bi]) {
					if( ai == bi ) {
						count[0]++;//Strike
					}else {
						count[1]++;//Ball
					}
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		
		int[] count = ballCount(3456666, 3456666);		
		System.out.println("Strike:"+count[0]);
		System.out.println("Ball:"+count[1]);

	}

}
