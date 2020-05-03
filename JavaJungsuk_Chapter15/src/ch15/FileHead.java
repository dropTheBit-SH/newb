package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//[15-1] Ŀ�ǵ�������κ��� ���ϸ�� ���ڸ� �Է¹޾Ƽ�, 
//�Է¹��� ������ ������ ó������ �Է¹��� ���ڸ�ŭ�� ������ ����ϴ� ���α׷�(FileHead.java)�� �ۼ��϶�.
//[Hint] BufferedReader�� readLIne()�� ����϶�.
public class FileHead {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			for(int i=1;(line = br.readLine()) != null && i<=Integer.parseInt(args[1]); i++) {
				System.out.println(i + ":" + line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}

//		//������
//		try {
//			//int lineNum = Integer.parseInt(args[0]);
//			//String fileName = args[1];
//			File f = new File(fileName);
//			if (f.exists() && !f.isDirectory()) {
//				BufferedReader br = new BufferedReader(new FileReader(fileName));
//				String line = "";
//				int i = 1;
//				while ((line = br.readLine()) != null && i <= lineNum) {
//					System.out.println(i + ":" + line);
//					i++;
//				}
//			} else {
//				throw new FileNotFoundException(fileName + "��/�� ���丮�̰ų�, �������� �ʴ� �����Դϴ�.");
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println("USAGE: java FileHead 10 FILENAME");
//		}
	}
}
