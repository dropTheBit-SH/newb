package ex15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

//int Read�� void Write�� ����Ͽ� �����
public class IOEx2 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] tmp = new byte[10];
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		input.read(tmp, 0, tmp.length); //tmp�� 0������ length���� �о�´�
		output.write(tmp, 5, 5); // 5������ 5���� ����
		byte[] outSrc = output.toByteArray(); //��Ʈ���� ������ ����Ʈ�迭�� ��ȯ�Ѵ�
		System.out.println("Input: "+Arrays.toString(inSrc));
		System.out.println("Temp: "+Arrays.toString(tmp));
		System.out.println("Output: "+Arrays.toString(outSrc));
	}
}
