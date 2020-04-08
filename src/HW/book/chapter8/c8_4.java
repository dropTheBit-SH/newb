package chapter8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class c8_4 {
	public static void main(String[] args) throws IOException {
		System.out.println("c:\\windows\\system.ini 파일을 읽어 출력합니다.");
		FileReader fr = new FileReader("c:\\windows\\system.ini");
		Scanner fScan = new Scanner(new FileReader("c:\\windows\\system.ini"));
		int lineNumber = 0;
		while(fScan.hasNext()){
			String line = fScan.nextLine();
			lineNumber++;
			System.out.printf("%4d ", lineNumber);
			System.out.println(line);
		}
		fr.close();
		fScan.close();
	}
}

