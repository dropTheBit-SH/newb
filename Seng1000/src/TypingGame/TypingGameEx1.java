package TypingGame;

//[����1] ���� ������ ������ WordGenerator�� �ֱ������� �ܾ �߰��ϸ�, ����ڴ� ȭ���Է��� ���ؼ�
//          �ܾ���� ������ ������ �����Դϴ�. ������ ������ �ϼ��ϼ���.

import java.util.*;

class TypingGameEx1 {
	Vector words = new Vector();
	String[] data = { "�¿�", "����", "����", "ȿ��", "����", "����", "Ƽ�Ĵ�", "���", "����ī" };
	int interval = 2 * 1000; // 2��

	WordGenerator wg = new WordGenerator();

	public static void main(String args[]) {
		TypingGameEx1 game = new TypingGameEx1();

		game.wg.start();

		Vector words = game.words;

		while (true) {
			System.out.println(words);

			String prompt = ">>";
			System.out.print(prompt);

			// ȭ�����κ��� ���δ����� �Է¹޴´�.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			
			int idx = 0;
			 // 1. ����ڰ� �Է��� ���� words���� ã�� �����Ѵ�.
			if((idx = words.indexOf(input)) != -1) 
				words.remove(idx);
		}
	} // main

	public void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}

	class WordGenerator extends Thread {
		public void run() {

//			 * WordGenerator�� �����ð�(interval) �������� data�迭�� �� ��Ҹ� ���
//			 * words(Vector�ν��Ͻ�)�� �����ϴ� ���� �����Ѵ�.
			
			while(true) {
//			 * 1. ���ڿ� �迭 data�� ������ ��Ҹ� ��� words(Vector�ν��Ͻ�)�� �����Ѵ�.
				words.add(data[(int)(Math.random() * data.length)]);
//			 * 2. �ν��Ͻ� ���� interval�� ����ŭ �ð������� �д�.
				try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			 * 3. �ݺ����� �̿��ؼ� 1,2�� �۾��� �ݺ������� �̷������ �Ѵ�.
			
		} // end of run()
	} // class WordGenerator
} // TypingGameEx1

















