package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//[15-1] 커맨드라인으로부터 파일명과 숫자를 입력받아서, 
//입력받은 파일의 내용의 처음부터 입력받은 숫자만큼의 라인을 출력하는 프로그램(FileHead.java)을 작성하라.
//[Hint] BufferedReader의 readLIne()을 사용하라.
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

//		//모범답안
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
//				throw new FileNotFoundException(fileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println("USAGE: java FileHead 10 FILENAME");
//		}
	}
}
