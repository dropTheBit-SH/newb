package ch15;

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

		if (args.length < 2) {
			System.out.println("USAGE: java FileMergeTest MERGE_FILENAME FILENAME1 FILENAME2 ...");
			System.exit(0);
		}
		
		try {
			Vector v = new Vector();
			for (int i = 1; i < args.length; i++) {
				File f = new File(args[i]);
				if (f.exists())
					v.add(new FileInputStream(args[i]));
				else
					System.exit(0);
			}
			SequenceInputStream in = new SequenceInputStream(v.elements());

			FileOutputStream out = new FileOutputStream(args[0]);
			int data = 0;
			while ((data = in.read()) != -1)
				out.write(data);
			System.out.println("�Ϸ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
