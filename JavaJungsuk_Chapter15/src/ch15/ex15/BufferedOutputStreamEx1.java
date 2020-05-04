package ex15;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx1 {
	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			bos = new BufferedOutputStream(fos, 5);
			for(int i = '1'; i<= '9'; i++)
				bos.write(i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos != null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
  	}
}
