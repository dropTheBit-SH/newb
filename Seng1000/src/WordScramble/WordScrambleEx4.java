package WordScramble;

//[����4] �������� �� ����, ������ ������ getHint�޼��带 �ϼ��ϼ���.
//String getHint(String answer, char[] hint) - ������ ���� �Ϻθ� �����ִ� �޼���
// �ѹ� Ʋ�� ������ �ѱ��ھ� �� �����ش�.
//answer - ������ ����
//hint - ������ ���� ��Ʈ(previous hint)

import java.util.*;

class WordScrambleEx4 {

	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };
		Scanner s = new Scanner(System.in); // �ѹ� ������ ���� �����ϸ� �ǹǷ� �ݺ��� ������ �̵�
		while (true) {
			String answer = getAnswer(strArr);
			String question = getScrambledWord(answer);
			char[] hint = new char[answer.length()];
			// hint�� '_'�� �ʱ�ȭ �Ѵ�. ������ LOVE��� hint�� "____"�� �ȴ�.
			for (int i = 0; i < hint.length; i++) {
				hint[i] = '_';
			}
			while (true) {
				System.out.println("Question :" + question);
				System.out.print("Your answer is :");
				String input = s.nextLine();
				if (input.equalsIgnoreCase("q"))
					System.exit(0);
				if (input.equalsIgnoreCase(answer)) {
					System.out.println("�����Դϴ�.");
					System.out.println();
					break;
				} else {
					System.out.println(input + "��/�� ������ �ƴմϴ�. �ٽ� �õ��غ�����.");
					System.out.println("Hint:" + getHint(answer, hint));
				}
			} // while
		} // outer while
	} // main

	public static String getAnswer(String[] strArr) {
		int idx = (int) (Math.random() * strArr.length);
		return strArr[idx];
	}

	// ���� ����� ����� ������쵵 ���� �� ����. �������� �ʰ�... �׳� ������
	public static String getScrambledWord(String str) {
		char[] chArr = str.toCharArray();
		for (int i = 0; i < chArr.length; i++) {
			int idx = (int) (Math.random() * str.length());
			char tmp = chArr[i];
			chArr[i] = chArr[idx];
			chArr[idx] = tmp;
		}
		return new String(chArr);

	} // scramble(String str)

	public static String getHint(String answer, char[] hint) {
		int count = 0; // ��Ʈ�� ���Ե� '_'�� ����
		// 1. �ݺ����� �̿��ؼ� hint�� ���Ե� '_'�� ������ ����.
		for(int i=0; i<answer.length(); i++)
			if(hint[i]=='_') count++;
		// 2. count�� ���� 2���� Ŭ ���� ������ �� ���ڸ� hint�� �ִ´�.
		// ������ �� �˷��ִ� ��Ȳ�� ���� �ʰ� �ϱ� ����.
		// [����] �ݵ�� ���� ��Ʈ ���� �ѱ��ڸ� �� ���������.
		// ���� ��� ������ "LOVE"�̰� ���� ��Ʈ�� "L___"�̾��ٸ�
		// �� ���� ��Ʈ�� "L__E"�Ǵ� "L_V_" �� ���� ���̾�� �Ѵ�.
		// Math.random()�� ����ؼ� ������ �� ���ڸ� ��� ��Ʈ�� ������ �ȴ�.
		if(count > 2){
			while(true){
				int idx = (int) (Math.random() * answer.length());
				if(hint[idx]=='_'){
					hint[idx] = answer.charAt(idx);
					break;
				}
			}
		}
		return Arrays.toString(hint);
	} // getHint()
}

// [������]
//
// Question :HEANGC
// Your answer is :chaneg
// chaneg��/�� ������ �ƴմϴ�. �ٽ� �õ��غ�����.
// Hint:__A___
// Question :HEANGC
// Your answer is :chance
// chance��/�� ������ �ƴմϴ�. �ٽ� �õ��غ�����.
// Hint:__A_G_
// Question :HEANGC
// Your answer is :hcange
// hcange��/�� ������ �ƴմϴ�. �ٽ� �õ��غ�����.
// Hint:__ANG_
// Question :HEANGC
// Your answer is :hange
// hange��/�� ������ �ƴմϴ�. �ٽ� �õ��غ�����.
// Hint:C_ANG_
// Question :HEANGC
// Your answer is :ceange
// ceange��/�� ������ �ƴմϴ�. �ٽ� �õ��غ�����.
// Hint:C_ANG_
// Question :HEANGC
// Your answer is :change
// �����Դϴ�.
//
// Question :VEIW
// Your answer is :q
