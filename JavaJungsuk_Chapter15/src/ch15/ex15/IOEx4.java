package ex15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx4 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] tmp = new byte[4];
		byte[] outSrc = null;
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0){
				int len = input.read(tmp);
				output.write(tmp, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		outSrc = output.toByteArray(); //스트림의 내용을 바이트배열로 반환한다
		System.out.println("Input: "+Arrays.toString(inSrc));
		System.out.println("Temp: "+Arrays.toString(tmp));
		System.out.println("Output: "+Arrays.toString(outSrc));
	}
}
