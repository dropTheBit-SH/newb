package ch15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

//[15-2] ������ ���������� ������ �������� ���� 16������ �����ִ� ���α׷�(HexaViewer.java)�� �ۼ��϶�.
//[Hint] PrintStream�� printf()�� ����϶�.
public class HexaViewer {
	public static void main(String[] args) {
		//���̳ʸ����� fis+ps
		try(FileInputStream fis = new FileInputStream("e:/workspace/JavaJungsuk_Chapter15/bin/ch15/"+args[0]);
		PrintStream ps = new PrintStream(System.out)){
			int data = 0, i = 1;
			while((data = fis.read()) != -1){
				ps.printf("%02x ", data);
				if(i%16 == 0) ps.println();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
	}
}
