package chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class c8_5 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		
		System.out.print("첫번째 파일 이름을 입력하세요>> ");
		String file1 = scan.next();
		FileInputStream fis1 = new FileInputStream(file1);
		System.out.print("두번째 파일 이름을 입력하세요>> ");
		String file2 = scan.next();
		FileInputStream fis2 = new FileInputStream(file2);
		
		System.out.println(file1+"와 "+file2+"를 비교합니다.");
		
		byte[] fisArr1 = new byte[1024];
		byte[] fisArr2 = new byte[1024];
		
		int n = 0, c = 0;
		while((c = fis1.read()) != -1){
			fisArr1[n] = (byte)c;
			n++;
		}
		
		n = 0; c = 0;
		while((c = fis2.read()) != -1){
			fisArr2[n] = (byte)c;
			n++;
		}
		
		boolean flag = false;
		for(int i=0; i<fisArr1.length; i++){
			if(fisArr1[i] == fisArr2[i]){
				flag = true;
			}else{
				flag = false;
			}
		}
		
		if(!flag)	System.out.println("파일이 서로 다릅니다."); 
		else System.out.println("파일이 같습니다."); 
		fis1.close();
		fis2.close();
	}
}
