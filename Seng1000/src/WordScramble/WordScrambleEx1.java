package WordScramble;


//[문제1] 다음의 예제를 완성하시오.
//getAnswer(String[] strArr)는 배열strArr의 요소중의 하나를 임의로 골라서 반환한다.(Math.random()사용)
//getScrambledWord(String str)는 주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환한다.(Math.random()사용)
public class WordScrambleEx1 {
	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };
		String answer = getAnswer(strArr);
		String question = getScrambledWord(answer);
		System.out.println("Question :" + question);
		System.out.print("Your answer is :");
	} // main

	// 배열strArr의 요소중의 하나를 임의로 골라서 반환한다.(Math.random()사용)
	public static String getAnswer(String[] strArr) {
		return strArr[(int) (Math.random() * strArr.length)];
	}

	// 주어진 문자열 str의 각 문자의 순서를 뒤섞은 다음, 새로운 문자열로 반환한다.
	public static String getScrambledWord(String str) {
		// a번째 문자를 b번째 문자와 바꾼다
		// 0. String을 char 배열로 바꾼다
		char[] tmpArr = str.toCharArray();
		char tmp;
		// 1. 반복문을 이용하여, 전체 길이만큼 바꾸는 작업을 한다
		for (int i = 0; i < tmpArr.length; i++) {
			// 2. a번째 문자는 math.random으로 구한다
			int j = (int) (Math.random() * tmpArr.length);
			tmp = tmpArr[j];
			tmpArr[j] = tmpArr[i];
			tmpArr[i] = tmp;
		}
		// 3. 만약 결과물이 정답과 같다면 재귀호출한다
		if (tmpArr.equals(str.toCharArray()))
			getScrambledWord(str);
		return new String(tmpArr);
	} // scramble(String str)
}
