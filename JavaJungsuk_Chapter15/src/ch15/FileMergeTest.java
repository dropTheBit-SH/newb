package ch15;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Vector;

//[15-4] Ŀ�ǵ�������κ��� ���� ������ �̸��� �Է¹ް�, 
//�� ���ϵ��� ������� ���ļ� ���ο� ������ ����� ���� ���α׷�(FileMergeTest.java)�� �ۼ��Ͻÿ�. 
//��, ��ĥ ������ �������� ������ ���� �ʴ´�.
public class FileMergeTest {
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("USAGE: java FileMergeTest MERGE_FILENAME FILENAME1 FILENAME2 ...");
			System.exit(0);
		}
		try {
			Vector v = new Vector();
			for(int i=1; i<args.length; i++) {
				File f = new File(args[i]);
				if(f.exists()) 
					v.add(new FileInputStream(args[i]));
				else {
					System.out.println(args[i]+"������ �������� �ʽ��ϴ�");
					System.exit(0);
				}
			}
			SequenceInputStream input = new SequenceInputStream(v.elements());
			FileOutputStream output = new FileOutputStream(args[0]);
			int data = 0;
			while((data = input.read()) != -1) 
				output.write(data);
			System.out.println("�Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}
