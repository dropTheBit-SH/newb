package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.Scanner;

//[15-1] 커맨드라인으로부터 파일명과 숫자를 입력받아서, 
//입력받은 파일의 내용의 처음부터 입력받은 숫자만큼의 라인을 출력하는 프로그램(FileHead.java)을 작성하라.
//[Hint] BufferedReader의 readLIne()을 사용하라.
public class FileHead {
	public static void main(String[] args) {
		//텍스트파일 fr+br
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
