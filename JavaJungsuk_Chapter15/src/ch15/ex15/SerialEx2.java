package ex15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx2 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream in = new ObjectInputStream(bis);
			
//			UserInfo u1 = (UserInfo)in.readObject();
//			UserInfo u2 = (UserInfo)in.readObject();
			ArrayList list = (ArrayList)in.readObject();
			
//			System.out.println(u1);
//			System.out.println(u2);
			System.out.println(list);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
