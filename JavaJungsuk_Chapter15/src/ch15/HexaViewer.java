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

//[15-2] ������ ���������� ������ �������� ���� 16������ �����ִ� ���α׷�(HexaViewer.java)�� �ۼ��϶�.
//[Hint] PrintStream�� printf()�� ����϶�.
public class HexaViewer {
	public static void main(String[] args) {
		try {
			FileInputStream input = new FileInputStream(args[0]);
			PrintStream output = new PrintStream(System.out);
			//%02x 2�ڸ�, ���ڸ��� 0���� ä�� 16����(%d 10����, %o 8����, %x 16����)
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
