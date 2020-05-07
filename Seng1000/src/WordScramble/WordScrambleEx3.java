package WordScramble;

//[문제3] 문제2의 예제를 변경해서, 문제를 맞추더라도 프로그램이 종료되지 않고 다음문제를 보여주도록 하세요.

import java.util.*;

public class WordScrambleEx3 {
	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };
		//기존에 나왔던 문제는 나오지 않도록 해야한다 
		//- 나왔던 문제를 저장해두면서 비교하거나..나왔던 문제는 빼준다..
		//총 문제수인 strArr의 배열만큼만 반복한다
		//맞추면 다음 문제로 넘어간다

		//1. 총 문제 수만큼 반복한다(strArr.length)
		int cnt = 0;
		String[] checkArr = new String[strArr.length];
		ws: while(cnt<strArr.length){
			//2. 문제를 선택한다(나온 문제는 저장해두고 같은 문제가 아닐 때까지 비교한다）
			String answer = getAnswer(strArr);
			for(int i=0; i<=cnt; i++){
				//2-1. 문제가 기출과 같으면, 다시 출제한다
				if(checkArr[i]!=null && checkArr[i].equalsIgnoreCase(answer)) continue ws;
			}
			//2-2. 다르면, 다음을 위해서 기출을 저장해둔다
			checkArr[cnt++] = answer;
			String question = getScrambledWord(answer);
			
			while (true) {
				System.out.println("Question :" + question);
				System.out.print("Your answer is :");
				
				// 1. 화면을 통해 사용자의 입력을 받는다.(Scanner클래스 사용)
				Scanner scan = new Scanner(System.in);
				String input = scan.next();
				// 2. 사용자가 q 또는 Q를 입력하면 프로그램을 종료한다.
				if (input.equalsIgnoreCase("q"))
					System.exit(0);
				// 3. 사용자가 정답을 맞출때까지 반복하다가
				// 사용자가 정답을 맞추면, while문을 빠져나간다.
				if (input.equalsIgnoreCase(answer)) {
					System.out.println("정답입니다.");
					break;
				} else {
					System.out.println(input+"은/는 정답이 아닙니다. 다시 시도해보세요.");
				}
				scan.close();
			} // while
		}
		
		// 코드를 넣어 완성하세요.
		// hint : while문을 중첩해서(2개의 while문) 작성하세요.

	} // main

	public static String getAnswer(String[] strArr) {
		int idx = (int) (Math.random() * strArr.length);
		return strArr[idx];
	}

	public static String getScrambledWord(String str) {
		char[] chArr = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			int idx = (int) (Math.random() * str.length());
			char tmp = chArr[i];
			chArr[i] = chArr[idx];
			chArr[idx] = tmp;
		}
		return new String(chArr);
	} // scramble(String str)
}

// [실행결과]
//
// Question :IWVE
// Your answer is :ievw
// ievw은/는 정답이 아닙니다. 다시 시도해보세요.
// Question :IWVE
// Your answer is :view
// 정답입니다.
//
// Question :HOEP
// Your answer is :hope
// 정답입니다.
//
// Question :GNCAEH
// Your answer is :change
// 정답입니다.
//
// Question :HECNAG
// Your answer is :q
