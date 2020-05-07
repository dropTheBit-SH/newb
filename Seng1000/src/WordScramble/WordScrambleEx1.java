package WordScramble;


//[����1] ������ ������ �ϼ��Ͻÿ�.
//getAnswer(String[] strArr)�� �迭strArr�� ������� �ϳ��� ���Ƿ� ��� ��ȯ�Ѵ�.(Math.random()���)
//getScrambledWord(String str)�� �־��� ���ڿ� str�� �� ������ ������ �ڼ��� ����, ���ο� ���ڿ��� ��ȯ�Ѵ�.(Math.random()���)
public class WordScrambleEx1 {
	public static void main(String[] args) {
		String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW" };
		String answer = getAnswer(strArr);
		String question = getScrambledWord(answer);
		System.out.println("Question :" + question);
		System.out.print("Your answer is :");
	} // main

	// �迭strArr�� ������� �ϳ��� ���Ƿ� ��� ��ȯ�Ѵ�.(Math.random()���)
	public static String getAnswer(String[] strArr) {
		return strArr[(int) (Math.random() * strArr.length)];
	}

	// �־��� ���ڿ� str�� �� ������ ������ �ڼ��� ����, ���ο� ���ڿ��� ��ȯ�Ѵ�.
	public static String getScrambledWord(String str) {
		// a��° ���ڸ� b��° ���ڿ� �ٲ۴�
		// 0. String�� char �迭�� �ٲ۴�
		char[] tmpArr = str.toCharArray();
		char tmp;
		// 1. �ݺ����� �̿��Ͽ�, ��ü ���̸�ŭ �ٲٴ� �۾��� �Ѵ�
		for (int i = 0; i < tmpArr.length; i++) {
			// 2. a��° ���ڴ� math.random���� ���Ѵ�
			int j = (int) (Math.random() * tmpArr.length);
			tmp = tmpArr[j];
			tmpArr[j] = tmpArr[i];
			tmpArr[i] = tmp;
		}
		// 3. ���� ������� ����� ���ٸ� ���ȣ���Ѵ�
		if (tmpArr.equals(str.toCharArray()))
			getScrambledWord(str);
		return new String(tmpArr);
	} // scramble(String str)
}
