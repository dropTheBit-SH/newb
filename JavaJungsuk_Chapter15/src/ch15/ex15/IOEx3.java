package ex15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx3 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] tmp = new byte[4];
		byte[] outSrc = null;
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.out.println("Input: "+Arrays.toString(inSrc));
		
		try {
			while(input.available() > 0){ //available() ��Ʈ�����κ��� �о�� �� �ִ� ������ ũ��
				input.read(tmp);
				output.write(tmp);
//				System.out.println("Temp: "+Arrays.toString(tmp));
				outSrc = output.toByteArray(); //��Ʈ���� ������ ����Ʈ�迭�� ��ȯ�Ѵ�
				printArrays(tmp, outSrc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void printArrays(byte[] tmp, byte[] outSrc) {
		System.out.println("Temp: "+Arrays.toString(tmp));
		System.out.println("Output: "+Arrays.toString(outSrc));
	}
}
