package Quiz;

//[����1] �־��� ���ڿ� �����͸� ������ �������� ���� ��µǵ��� �ڵ带 �ϼ��ϼ���.
//�������� ������ ����, ��, �������� ������ �Ǿ� ������ �����ڴ� `(����1���� Ű)�Դϴ�.
class QuizEx1 {
	public static void main(String[] args) {
		String[] data = { "���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public", "���� �� �ڹ��� �����ڰ� �ƴ� ����?`5`&`|`++`!=`/`^",
				"���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false", };

		System.out.println("[������]");
		for (int i = 0; i < data.length; i++) {
			// 1. StringŬ������ String[] split(String regex, int limit)�� ����ؼ� ������ �������� ��������.
			String[] tmpQ = data[i].split("`", data[i].length());
			// 2. ������ ����ϼ���.
			System.out.printf("[%d] %s\n",i+1,tmpQ[0]);
			// 3. �������� ������ ���� String[] split(String regex)�� ����ϼ���.
			String[] tmpA = data[i].split("`");
			// 4.�ݺ����� �̿��ؼ� �������� ����ϼ���. : 2������ ����
			for(int j=2, cnt=1; j<tmpA.length; j++){
				System.out.printf("%d. %s ", cnt++, tmpA[j]);
			}
			System.out.println();
		}
	} // main
}

// [������]
// [1] ���� �� Ű���尡 �ƴ� ����?
// 1.final 2.True 3.if 4.public
// [2] ���� �� �ڹ��� �����ڰ� �ƴ� ����?
// 1.& 2.| 3.++ 4.!= 5./ 6.^
// [3] ���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?
// 1.void 2.null 3.false
