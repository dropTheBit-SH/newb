package TypingGame;

//[문제3] 이번엔 AWT를 사용해서 만든 타자게임의 GUI(Graphic User Interface)버젼입니다.
//하단의 TextField에 단어를 입력하고 'Enter'키를 누르면, 일치하는 단어가 화면에서 사라집니다.
//단어가 바닥에 떨어질 때까지 입력하지 못하면 life가 1 감소하고 life의 값이 0이 되면 게임은 종료됩니다.

import java.util.*;
import java.awt.*;
import java.awt.event.*;

class TypingGameEx3 extends Frame {
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;

	final int SCREEN_WIDTH;
	final int SCREEN_HEIGHT;

	int speed = 500; // 단어가 떨어지는 속도... 높을 수록 느리다.
	int interval = 2 * 1000; // 새로운 단어가 나오는 간격

	int level = 0;
	int score = 0;
	int life = 3;

	boolean isPlaying = false;

	WordGenerator wg = null; // 단어를 생성하는 쓰레드
	WordDropper wm = null; // 단어를 떨어뜨리는 쓰레드

	FontMetrics fm; // 화면에서의 글자 길이를 구하는데 사용

	String[] data = { "태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카" };

	Vector words = new Vector();

	TextField tf = new TextField();
	Panel pScore = new Panel(new GridLayout(1, 3));
	Label lbLevel = new Label("Level:" + level, Label.CENTER);
	Label lbScore = new Label("Score:" + score, Label.CENTER);
	Label lbLife = new Label("Life:" + life, Label.CENTER);
	MyCanvas screen = new MyCanvas();

	TypingGameEx3() {
		this("Typing game ver1.0");
	}

	TypingGameEx3(String title) {
		super(title);

		pScore.setBackground(Color.YELLOW);
		pScore.add(lbLevel);
		pScore.add(lbScore);
		pScore.add(lbLife);
		add(pScore, "North");
		add(screen, "Center");
		add(tf, "South");

		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
		tf.addActionListener(handler);

		setBounds(500, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);

		SCREEN_WIDTH = screen.getWidth();
		SCREEN_HEIGHT = screen.getHeight();
		fm = getFontMetrics(getFont());
	}

	public void repaint() {
		super.repaint();
		screen.repaint();
	}

	public void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
		}
	}

	public void start() {
		isPlaying = true;

		wg = new WordGenerator();
		wg.start();

		wm = new WordDropper();
		wm.start();
	}

	public static void main(String[] args) {
		TypingGameEx3 win = new TypingGameEx3();
//  win.show();
		win.start();
	}

	class WordDropper extends Thread {
		public void run() {
			outer: while (isPlaying) {
				delay(speed);
				for (int i = 0; i < words.size(); i++) {
					Word tmp = (Word) words.get(i);

					tmp.y += tmp.step;

					if (tmp.y >= SCREEN_HEIGHT) {
						tmp.y = SCREEN_HEIGHT;
						words.remove(tmp);
						life--;
						lbLife.setText("Life:" + life);
						break;
					}

					if (life <= 0) {
						isPlaying = false;
						break outer;
					}
				} // for

				repaint();
			}
		} // end of run()
	}

	class WordGenerator extends Thread {
		public void run() {
			while (isPlaying) {
				int rand = (int) (Math.random() * data.length);

				Word word = new Word(data[rand]);
				words.add(word);
				delay(interval);
			}
		} // end of run()
	}

	class MyCanvas extends Canvas {
		public void clear() {
			Graphics g = getGraphics();
			g.clearRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		}

		public void paint(Graphics g) {
			clear();

			for (int i = 0; i < words.size(); i++) {
				Word tmp = (Word) words.get(i);
				g.drawString(tmp.word, tmp.x, tmp.y);
			}
		}
	}

	class Word {
		String word = "";
		int x = 0;
		int y = 0;
		int step = 5;

		Word(String word) {
			this(word, 10);
		}

		Word(String word, int step) {
			this.word = word;
			this.step = step;

			int strWidth = fm.stringWidth(word);

			x = (int) (Math.random() * SCREEN_WIDTH);

			if (x + strWidth >= SCREEN_WIDTH)
				x = SCREEN_WIDTH - strWidth;
		}

		public String toString() {
			return word;
		}
	} // end of class Word

	class MyEventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

//			 * 1. TextField의 값을 읽어서 저장한다.(getText()사용)
			String input = tf.getText().trim();
//			 * 2. TextField를 비운다.
			tf.setText("");
//			 * 3. 게임중(isPlaying)이 아니면, 빠져나간다.
			if(!isPlaying) return;
//			 * 4. 반복문을 이용해서 사용자가 TextField에 입력한 단어를 words에서 찾는다
			for(int i=0; i<words.size(); i++) {
				Word tmp = (Word)words.get(i);
//			 * 4.1 찾으면, words에서 제거한다.
				if(input.equals(tmp.word)) {
					words.remove(i);
//			 * 4.2 단어의 길이에 따라 score를 증가시킨다.(단어의 문자개수 * 50)
					score += input.length() * 50;
					lbScore.setText("Score:"+score);
//			 * 4.3 '삑~'소리가 나게 한다.(Toolkit.getDefaultToolkit().beep()사용)
					Toolkit.getDefaultToolkit().beep();
				}
			}
//			 * 5. 화면을 다시 그리게 한다.(repaint()사용)
			repaint();
		}

		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	} // class MyEventHandler
}
