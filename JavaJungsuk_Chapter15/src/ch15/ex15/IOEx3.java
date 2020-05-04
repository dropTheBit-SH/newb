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
			while(input.available() > 0){ //available() 스트림으로부터 읽어올 수 있는 데이터 크기
				input.read(tmp);
				output.write(tmp);
//				System.out.println("Temp: "+Arrays.toString(tmp));
				outSrc = output.toByteArray(); //스트림의 내용을 바이트배열로 반환한다
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
