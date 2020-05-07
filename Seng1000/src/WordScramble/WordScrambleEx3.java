package WordScramble;

//[����3] ����2�� ������ �����ؼ�, ������ ���ߴ��� ���α׷��� ������� �ʰ� ���������� �����ֵ��� �ϼ���.

import java.util.*;

public class WordScrambleEx3 {
	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };
		//������ ���Դ� ������ ������ �ʵ��� �ؾ��Ѵ� 
		//- ���Դ� ������ �����صθ鼭 ���ϰų�..���Դ� ������ ���ش�..
		//�� �������� strArr�� �迭��ŭ�� �ݺ��Ѵ�
		//���߸� ���� ������ �Ѿ��

		//1. �� ���� ����ŭ �ݺ��Ѵ�(strArr.length)
		int cnt = 0;
		String[] checkArr = new String[strArr.length];
		ws: while(cnt<strArr.length){
			//2. ������ �����Ѵ�(���� ������ �����صΰ� ���� ������ �ƴ� ������ ���Ѵ٣�
			String answer = getAnswer(strArr);
			for(int i=0; i<=cnt; i++){
				//2-1. ������ ����� ������, �ٽ� �����Ѵ�
				if(checkArr[i]!=null && checkArr[i].equalsIgnoreCase(answer)) continue ws;
			}
			//2-2. �ٸ���, ������ ���ؼ� ������ �����صд�
			checkArr[cnt++] = answer;
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
		}
		
		// �ڵ带 �־� �ϼ��ϼ���.
		// hint : while���� ��ø�ؼ�(2���� while��) �ۼ��ϼ���.

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
// Question :IWVE
// Your answer is :ievw
// ievw��/�� ������ �ƴմϴ�. �ٽ� �õ��غ�����.
// Question :IWVE
// Your answer is :view
// �����Դϴ�.
//
// Question :HOEP
// Your answer is :hope
// �����Դϴ�.
//
// Question :GNCAEH
// Your answer is :change
// �����Դϴ�.
//
// Question :HECNAG
// Your answer is :q
