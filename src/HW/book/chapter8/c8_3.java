package chapter8;

import java.io.FileReader;
import java.io.IOException;

public class c8_3 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("c:\\windows\\system.ini");
		int i;
		while((i = fr.read()) != -1){
			System.out.print(Character.toUpperCase((char)i));
		}
		fr.close();
	}
}
