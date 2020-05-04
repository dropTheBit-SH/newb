package ex15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

//int Read와 void Write를 사용하여 입출력
public class IOEx2 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] tmp = new byte[10];
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		input.read(tmp, 0, tmp.length); //tmp의 0번부터 length까지 읽어온다
		output.write(tmp, 5, 5); // 5번부터 5개를 쓴다
		byte[] outSrc = output.toByteArray(); //스트림의 내용을 바이트배열로 반환한다
		System.out.println("Input: "+Arrays.toString(inSrc));
		System.out.println("Temp: "+Arrays.toString(tmp));
		System.out.println("Output: "+Arrays.toString(outSrc));
	}
}
