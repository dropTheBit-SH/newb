package ch15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Vector;

//[15-4] 커맨드라인으로부터 여러 파일의 이름을 입력받고, 
//이 파일들을 순서대로 합쳐서 새로운 파일을 만들어 내는 프로그램(FileMergeTest.java)을 작성하시오. 
//단, 합칠 파일의 개수에는 제한을 두지 않는다.
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
			System.out.println("완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
