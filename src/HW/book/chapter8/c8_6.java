package chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class c8_6 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		
		System.out.print("첫번째 파일 이름을 입력하세요>> ");
		String file1 = scan.next();
		System.out.print("두번째 파일 이름을 입력하세요>> ");
		String file2 = scan.next();
		
		int c;
		FileReader fr1 = new FileReader(file1);
		FileWriter fw = new FileWriter("appended.txt");
		while((c = fr1.read()) != -1){
			fw.write((char)c);
		}
		FileReader fr2 = new FileReader(file2);
		while((c = fr2.read()) != -1){
			fw.write((char)c);
		}
		
		
		fr1.close();
		fr2.close();
		fw.close();
		System.out.println("프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다.");
		
	}
}
