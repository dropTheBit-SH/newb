package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.Scanner;

//[15-1] Ŀ�ǵ�������κ��� ���ϸ�� ���ڸ� �Է¹޾Ƽ�, 
//�Է¹��� ������ ������ ó������ �Է¹��� ���ڸ�ŭ�� ������ ����ϴ� ���α׷�(FileHead.java)�� �ۼ��϶�.
//[Hint] BufferedReader�� readLIne()�� ����϶�.
public class FileHead {
	public static void main(String[] args) {
		//�ؽ�Ʈ���� fr+br
		try(FileReader fr = new FileReader("e:/workspace/JavaJungsuk_Chapter15/bin/ch15/"+args[0]);
			BufferedReader br = new BufferedReader(fr)) {
			String line = "";
			for(int i=1; (line = br.readLine()) != null && i<=Integer.parseInt(args[1]); i++){
				System.out.println(i +":"+ line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try {
//			FileReader fr = new FileReader("e:/workspace/JavaJungsuk_Chapter15/bin/ch15/"+args[0]);
//			BufferedReader br = new BufferedReader(fr);
//			String line = "";
//			for(int i=1;(line = br.readLine()) != null && i<=Integer.parseInt(args[1]); i++) {
//				System.out.println(i + ":" + line);
//			}
//			br.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("FileNotFoundException");
//		} catch (IOException e) {
//			System.out.println("IOException");
//		}
	}
}
