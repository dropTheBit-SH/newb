package chapter8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//입력 스트림 생성, 파일 연결:	FileReader fin = new FileReader(“경로”)
//파일 읽기: int c; while((c=fin.read())!= -1{ syso((char)c);}
//스트림 닫기: fin.close()

public class c8_2 {
	public static void main(String[] args) throws IOException {
		String path = "c:\\temp\\phone.txt";
		FileReader fr = new FileReader("path");
		System.out.println(path+"를 출력합니다.");

		Scanner scan = new Scanner(new FileReader("path"));
		while(scan.hasNext()){
			System.out.printf(scan.nextLine());
		}
		fr.close();
		scan.close();
	}
	
}
