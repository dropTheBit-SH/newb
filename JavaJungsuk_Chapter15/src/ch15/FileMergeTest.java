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

//[15-4] 커맨드라인으로부터 여러 파일의 이름을 입력받고, 
//이 파일들을 순서대로 합쳐서 새로운 파일을 만들어 내는 프로그램(FileMergeTest.java)을 작성하시오. 
//단, 합칠 파일의 개수에는 제한을 두지 않는다.
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
					System.out.println(args[i]+"파일이 존재하지 않습니다");
					System.exit(0);
				}
			}
			SequenceInputStream input = new SequenceInputStream(v.elements());
			FileOutputStream output = new FileOutputStream(args[0]);
			int data = 0;
			while((data = input.read()) != -1) 
				output.write(data);
			System.out.println("완료");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}
