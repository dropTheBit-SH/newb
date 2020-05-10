package TypingGame;

//[문제2] 이전 예제를 발전 시켜서, 이번엔 시간까지 추가해서 생성된 단어를 10초안에 입력하지 못하는 횟수가
//3번이 되면 게임이 종료되도록 하였습니다.
//전에는 단어를 String의 형태로 words에 저장했지만, 이번엔 단어(String)와 시간을 멤버로 정의한 Word클래스의
//인스턴스를 words에 저장합니다.
//그리고, WordDropper는 WordGenerator와 같은 쓰레드로, 모든 단어의 시간을 10부터 0까지
//1초에 1씩  감소시키는 일을 합니다.

import java.util.*;

public class TypingGameEx2 {
	Vector words = new Vector();
	String[] data = { "태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카" };
	int interval = 2 * 1000; // 2초

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

			// 화면으로부터 라인단위로 입력받는다.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();

//			 * 1. 반복문을 이용해서 사용자가 입력한 단어가 words에 있는지 확인한다.
			for(int i=0; i<words.size(); i++) {
				Word word = (Word)words.get(i);
				if(word.word.equals(input)) {
//			 * 2. 있으면 words에서 삭제하고 '삑~'소리가 나게 한다.
//			 * (java.awt.Toolkit.getDefaultToolkit().beep()사용)
					words.remove(word);
					java.awt.Toolkit.getDefaultToolkit().beep();
//			 * 3. 점수(score)의 값을 계산해서 증가시킨다.
//			 * (입력한 단어의 글자수 * 남은시간 * 50으로 점수를 계산한다.)
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
//			 * 1. words에 저장된 모든 단어(Word인스턴스)의 y값을 1 감소시킨다.
				for(int i=0; i<words.size(); i++) {
					Word word = (Word)words.get(i);
					word.y--;
//			 * 2. y의 값이 0보다 작거나 같으면, words에서 단어를 제거하고 life를 1 감소시킨다.
					if(word.y <= 0) {
						words.remove(word);
						life--;
					}
//			 * 3. life의 값이 0이 되면 life와 점수를 출력하고 게임을 종료한다.
					if(life == 0) {
						System.out.printf("LIFE:%d SCORE:%d",life, score);
						System.exit(0);
					}
				}
//			 * 4. 1초간 시간을 지연시킨다.(delay()사용)
				delay(1000);
//			 * 5. 반복문을 이용해서 1~4의 작업을 반복한다.
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
