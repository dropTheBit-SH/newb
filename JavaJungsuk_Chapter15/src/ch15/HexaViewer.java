package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

//[15-2] 지정된 이진파일의 내용을 실행결과와 같이 16진수로 보여주는 프로그램(HexaViewer.java)을 작성하라.
//[Hint] PrintStream과 printf()를 사용하라.
public class HexaViewer {
	public static void main(String[] args) {
		try {
			FileInputStream input = new FileInputStream(args[0]);
			PrintStream output = new PrintStream(System.out);
			//%02x 2자리, 빈자리는 0으로 채운 16진수(%d 10진수, %o 8진수, %x 16진수)
			for(int i=0, data=0; (data=input.read()) != -1;) {
				output.printf("%02x", data);
				if(++i%16==0) output.println();
			}
			input.close();
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		
	}
}
