package WordScramble;

//[����2] ������ �������� while���� ���θ� �ּ��� ������ �����ؼ� �ϼ��ϼ���.

import java.util.*;

class WordScrambleEx2 {
	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };

		String answer = getAnswer(strArr);
		String question = getScrambledWord(answer);

		while (true) {
			System.out.println("Question :" + question);
			System.out.print("Your answer is :");

			// 1. ȭ���� ���� ������� �Է��� �޴´�.(ScannerŬ���� ���)
			Scanner scan = new Scanner(System.in);
			String input = scan.next();
			// 2. ����ڰ� q �Ǵ� Q�� �Է��ϸ� ���α׷��� �����Ѵ�.
			if (input.equalsIgnoreCase("q"))
				System.exit(0);
			// 3. ����ڰ� ������ ���⶧���� �ݺ��ϴٰ�
			// ����ڰ� ������ ���߸�, while���� ����������.
			if (input.equalsIgnoreCase(answer)) {
				System.out.println("�����Դϴ�.");
				break;
			} else {
				System.out.println(input+"��/�� ������ �ƴմϴ�. �ٽ� �õ��غ�����.");
			}
			scan.close();
		} // while

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

// [������]
//
// Question :HEOP
// Your answer is :phoe
// phoe��/�� ������ �ƴմϴ�. �ٽ� �õ��غ�����.
// Question :HEOP
// Your answer is :hope
// �����Դϴ�.
