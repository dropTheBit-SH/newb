package chapter8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class c8_7 {
	public static void main(String[] args) throws IOException {
		
		File src = new File("a.jpg");
		File dest = new File("b.jpg");
		System.out.println(src+"를 "+dest+"로 복사합니다.");
		int c;
		FileInputStream fi = new FileInputStream(src);
		FileOutputStream fo = new FileOutputStream(dest);
		System.out.println("10%마다 *를 출력합니다.");
		
		byte[] buf = new byte [1024* 86];
		while(true){
			int n = fi.read(buf);
			fo.write(buf,0,n);
			System.out.print("*");
			if(n<buf.length) break;
		}
		fi.close();
		fo.close();
		
		
	}
}
