package Quiz;

//[문제3] 문제2에서 완성된 코드를 이용해서, 문제의 순서를 임의로 바꾸고, 선택지도 임의로 바뀌어 출력되도록 하세요.
//void shuffle(String[] data) - 주어진 문자열배열의 각 요소의 순서를 임으로 뒤바꾼다.

import java.util.*;

class QuizEx3 {
	public static void main(String[] args) {
		String[] data = { "다음 중 키워드가 아닌 것은?`2`final`True`if`public", "다음 중 자바의 연산자가 아닌 것은?`6`&`|`++`!=`/`^",
				"다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false`", };

		Scanner s = new Scanner(System.in);
		int score = 0;
		shuffle(data); // 문제를 섞는다.
		for (int i = 0; i < data.length; i++) {
			String[] tmp = data[i].split("`", 3);
			
			String question = tmp[0];
			String answer = tmp[1];
			String[] choices = tmp[2].split("`");

			answer = choices[Integer.parseInt(answer) - 1];
			shuffle(choices); // 선택지를 섞는다.

			System.out.println("[" + (i + 1) + "] " + question);

			for (int x = 0; x < choices.length; x++) {
				System.out.printf("%d. %s ", x+1, choices[x]);
			}

			System.out.println();
			System.out.print("[답]");
			String input = choices[Integer.parseInt(s.next())-1];
			
			if (input.equals(answer)) { 
				//선택한 번호의 문자열이 답(문자열)과 같은지 확인한다
				score++;
			}

			System.out.println();
			System.out.println();
		}
		s.close();
		System.out.println("정답개수/전체문항수 :" + score + "/" + data.length);
	} // main

	public static void shuffle(String[] data) {
		// 1. 배열data의 개수가 0보다 같거나 적으면 메서드 전체를 빠져나간다.
		if(data.length <= 0) return;
		// 2. 선택지의 순서를 뒤바꾼다. 반복문과 Math.random()사용
		for(int i=0; i<data.length; i++){
			int idx = (int)(Math.random() * data.length);
			String tmp = "";
			tmp = data[i];
			data[i] = data[idx];
			data[idx] = tmp;
		}
	} // shuffle()
}

// [실행결과]
// [1] 다음 중 자바의 연산자가 아닌 것은?
// 1./ 2.| 3.++ 4.!= 5.^ 6.&
// [답]5
//
// [2] 다음 중 키워드가 아닌 것은?
// 1.final 2.True 3.if 4.public
// [답]2
//
// [3] 다음 중 메서드의 반환값이 없음을 의미하는 키워드는?
// 1.null 2.void 3.false
// [답]2
//
// 정답개수/전체문항수 :3/3
