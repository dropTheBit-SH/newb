package Quiz;

//[����3] ����2���� �ϼ��� �ڵ带 �̿��ؼ�, ������ ������ ���Ƿ� �ٲٰ�, �������� ���Ƿ� �ٲ�� ��µǵ��� �ϼ���.
//void shuffle(String[] data) - �־��� ���ڿ��迭�� �� ����� ������ ������ �ڹٲ۴�.

import java.util.*;

class QuizEx3 {
	public static void main(String[] args) {
		String[] data = { "���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public", "���� �� �ڹ��� �����ڰ� �ƴ� ����?`6`&`|`++`!=`/`^",
				"���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false`", };

		Scanner s = new Scanner(System.in);
		int score = 0;
		shuffle(data); // ������ ���´�.
		for (int i = 0; i < data.length; i++) {
			String[] tmp = data[i].split("`", 3);
			
			String question = tmp[0];
			String answer = tmp[1];
			String[] choices = tmp[2].split("`");

			answer = choices[Integer.parseInt(answer) - 1];
			shuffle(choices); // �������� ���´�.

			System.out.println("[" + (i + 1) + "] " + question);

			for (int x = 0; x < choices.length; x++) {
				System.out.printf("%d. %s ", x+1, choices[x]);
			}

			System.out.println();
			System.out.print("[��]");
			String input = choices[Integer.parseInt(s.next())-1];
			
			if (input.equals(answer)) { 
				//������ ��ȣ�� ���ڿ��� ��(���ڿ�)�� ������ Ȯ���Ѵ�
				score++;
			}

			System.out.println();
			System.out.println();
		}
		s.close();
		System.out.println("���䰳��/��ü���׼� :" + score + "/" + data.length);
	} // main

	public static void shuffle(String[] data) {
		// 1. �迭data�� ������ 0���� ���ų� ������ �޼��� ��ü�� ����������.
		if(data.length <= 0) return;
		// 2. �������� ������ �ڹٲ۴�. �ݺ����� Math.random()���
		for(int i=0; i<data.length; i++){
			int idx = (int)(Math.random() * data.length);
			String tmp = "";
			tmp = data[i];
			data[i] = data[idx];
			data[idx] = tmp;
		}
	} // shuffle()
}

// [������]
// [1] ���� �� �ڹ��� �����ڰ� �ƴ� ����?
// 1./ 2.| 3.++ 4.!= 5.^ 6.&
// [��]5
//
// [2] ���� �� Ű���尡 �ƴ� ����?
// 1.final 2.True 3.if 4.public
// [��]2
//
// [3] ���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?
// 1.null 2.void 3.false
// [��]2
//
// ���䰳��/��ü���׼� :3/3
