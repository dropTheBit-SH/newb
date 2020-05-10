package TypingGame;

//[����2] ���� ������ ���� ���Ѽ�, �̹��� �ð����� �߰��ؼ� ������ �ܾ 10�ʾȿ� �Է����� ���ϴ� Ƚ����
//3���� �Ǹ� ������ ����ǵ��� �Ͽ����ϴ�.
//������ �ܾ String�� ���·� words�� ����������, �̹��� �ܾ�(String)�� �ð��� ����� ������ WordŬ������
//�ν��Ͻ��� words�� �����մϴ�.
//�׸���, WordDropper�� WordGenerator�� ���� �������, ��� �ܾ��� �ð��� 10���� 0����
//1�ʿ� 1��  ���ҽ�Ű�� ���� �մϴ�.

import java.util.*;

public class TypingGameEx2 {
	Vector words = new Vector();
	String[] data = { "�¿�", "����", "����", "ȿ��", "����", "����", "Ƽ�Ĵ�", "���", "����ī" };
	int interval = 2 * 1000; // 2��

	int life = 3;
	static int score = 0;

	WordGenerator wg = new WordGenerator();
	WordDropper wd = new WordDropper();

	public static void main(String args[]) {
		TypingGameEx2 game = new TypingGameEx2();

		game.wg.start();
		game.wd.start();

		Vector words = game.words;

		while (true) {
			System.out.println("LIFE:" + game.life + " SCORE:" + game.score);
			System.out.println(words);

			String prompt = ">>";
			System.out.print(prompt);

			// ȭ�����κ��� ���δ����� �Է¹޴´�.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();

//			 * 1. �ݺ����� �̿��ؼ� ����ڰ� �Է��� �ܾ words�� �ִ��� Ȯ���Ѵ�.
			for(int i=0; i<words.size(); i++) {
				Word word = (Word)words.get(i);
				if(word.word.equals(input)) {
//			 * 2. ������ words���� �����ϰ� '��~'�Ҹ��� ���� �Ѵ�.
//			 * (java.awt.Toolkit.getDefaultToolkit().beep()���)
					words.remove(word);
					java.awt.Toolkit.getDefaultToolkit().beep();
//			 * 3. ����(score)�� ���� ����ؼ� ������Ų��.
//			 * (�Է��� �ܾ��� ���ڼ� * �����ð� * 50���� ������ ����Ѵ�.)
					score += input.length() * (10-word.y)* 50;
				}
			}
		} // while(true)
	} // main

	public void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}

	class WordGenerator extends Thread {
		public void run() {
			while (true) {
				int rand = (int) (Math.random() * data.length);

				words.add(new Word(data[rand]));
				delay(interval);
			}
		} // run()
	} // class WordGenerator

	class WordDropper extends Thread {
		public void run() {

			while(true) {
//			 * 1. words�� ����� ��� �ܾ�(Word�ν��Ͻ�)�� y���� 1 ���ҽ�Ų��.
				for(int i=0; i<words.size(); i++) {
					Word word = (Word)words.get(i);
					word.y--;
//			 * 2. y�� ���� 0���� �۰ų� ������, words���� �ܾ �����ϰ� life�� 1 ���ҽ�Ų��.
					if(word.y <= 0) {
						words.remove(word);
						life--;
					}
//			 * 3. life�� ���� 0�� �Ǹ� life�� ������ ����ϰ� ������ �����Ѵ�.
					if(life == 0) {
						System.out.printf("LIFE:%d SCORE:%d",life, score);
						System.exit(0);
					}
				}
//			 * 4. 1�ʰ� �ð��� ������Ų��.(delay()���)
				delay(1000);
//			 * 5. �ݺ����� �̿��ؼ� 1~4�� �۾��� �ݺ��Ѵ�.
			}
		} // run()
	} // class WordDropper

	class Word {
		String word = "";
		int y = 10;

		Word(String word) {
			this(word, 10);
		}

		Word(String word, int y) {
			this.word = word;
			this.y = y;
		}

		public String toString() {
			return word+y;
		}
	} // class Word
} // TypingGameEx2
