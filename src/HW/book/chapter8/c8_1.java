package chapter8;
//		출력 스트림 생성, 파일 연결: FileWriter fout = new FileWriter(“경로”);
//		파일 쓰기: (문자 단위) fout.wirte(‘A’); 
//		   			(블록 단위) char[] buf = new char[1024]; fout.write(buf,0,buf.length)
//		스트림 닫기: fout.close
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class c8_1 {
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		String path = "c:\\temp\\phone.txt";
		FileWriter fw = new FileWriter("path");
		System.out.println("전화번호 입력 프로그램입니다.");
		while(true){
			System.out.print("이름 전화번호 >> ");
			String input = scan.nextLine();
			if(input.equals("그만")) break;
			fw.write(input, 0, input.length());
		}
		fw.close();
		System.out.println(path+"에 저장하였습니다.");
		scan.close();
	}
}
