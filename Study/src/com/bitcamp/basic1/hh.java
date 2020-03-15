package com.bit;



// 3자리 정수 2개를 비교해서 위치와 값을 판단하는 게임
// 배열 + if문(값 비교 후 위치 파악)

public class hh {
	
	public static int[] ballCount(int myNum, int urNum) { 	// 배열, int형 참조변수
			int[] count = new int[2]; 	// 정수 -> []
				
			String myS = String.valueOf(myNum); 	// string으로 변환(""+a)
			char[] myChar = myS.toCharArray();  	// 캐릭배열을 문자열로 
			String urS = String.valueOf(urNum);
			char[] urChar = urS.toCharArray();

			System.out.println(myChar);
			System.out.println(urChar);

				for(int myI=0; myI<myChar.length; ++myI) {
					for(int urI=0; urI<urChar.length; ++urI) {
						if(myChar[myI] == urChar[urI]) {
							if( myI==urI ) {
								count[0]++; 
							}else {
								count[1]++; 
							}
						}
					}
				}
				return count; 		//배열을 반환한다
			}
	
	public static void main(String[] args) { 	// 한정함수 결과를 비교한 2개의 결과
			int[] count = ballCount(252, 322);		// 배열명을 반환받는다
			System.out.println("Strike : "+count[0]);
			System.out.println("Ball : "+count[0]);
			}
}
