package chapter8;
//                                         작업중
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class Dao{
	static final int MAX = 25143;
	static String file = "words.txt";
	static Random random = new Random();
	
	public String getWord() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		int ranNum = random.nextInt(MAX);
		return readFile(br, ranNum);
	}
	
	public String readFile(BufferedReader br, int ranNum) throws IOException {
		String word = "";
		while(true) {
			word = br.readLine();
			if(word == null) break;
		}
		return word;
	}
	
	public void hideWord() {
		StringBuffer question;
		String word = "";
		question = new StringBuffer(word);
		int ranNum = random.nextInt(word.length());
		for(int )
	}
}

class Controller{
	public void Controller() {
		System.out.println("지금부터 행맨 개임을 시작합니다.");
		Dao dao = new Dao();
		while(true) {
			
		}
	}
}

public class HangmanOpenChallenge {
	
	public static void main(String[] args) {
		
	}
}
