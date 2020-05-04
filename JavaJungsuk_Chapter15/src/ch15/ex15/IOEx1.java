package ex15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
// bytearrayinputstream �̿��Ͽ� ����Ʈ�迭 inSrc�� outSrc�� ����
public class IOEx1 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int data = 0;
		while((data = input.read()) != -1)
			output.write(data);
		outSrc = output.toByteArray(); //��Ʈ���� ������ ����Ʈ�迭�� ��ȯ�Ѵ�
		System.out.println("Input: "+Arrays.toString(inSrc));
		System.out.println("Output: "+Arrays.toString(outSrc));
	}
}
