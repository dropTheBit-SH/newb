package TypingGame;

//[문제4] 바이러스에 걸린 단어가 나타나도록 기능을 추가하였다. 바이러스가 걸린 단어는 붉은색(Color.RED)로 표시되며
//바이러스에 걸린 단어를 입력하면, 바이러스의 종류에 따라 일정시간동안 단어가 떨어지는 속도가 증가 또는 감소하고
//단어가 화면에 나타나는 시간(interval)이 짧아지거나 길어진다. 화면의 모든 단어를 지우는 착한 바이러스도 있다.

import java.util.*;
import java.awt.*;
import java.awt.event.*;

class TypingGameEx4 extends Frame {
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

	TypingGameEx4() {
		this("Typing game ver1.0");
	}

	TypingGameEx4(String title) {
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
		TypingGameEx4 win = new TypingGameEx4();
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

				// 약 10번에 한번 꼴로 바이러스를 생성한다.
				boolean isVirus = ((int) (Math.random() * 10) + 1) / 10 != 0;

				Word word = new Word(data[rand], isVirus);
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
				g.setColor(tmp.color);
				g.drawString(tmp.word, tmp.x, tmp.y);
			}
		}
	}

	class VirusThread extends Thread {
		public void run() {
			int rand = (int) (Math.random() * 5);

			int oldValue = 0;
			int virusTime = 10 * 1000; // 10초간 바이러스가 동작한다.

			switch (rand) {
//			 * 1. rand의 값이 0이면, virusTime동안 speed의 값을 절반으로 줄인다.
			case 0: 
				speed = speed / 2;
				break;
//			 * 2. rand의 값이 1이면, virusTime동안 interval의 값을 절반으로 줄인다.
			case 1: 
				interval = interval / 2;
				break;
//			 * 3. rand의 값이 2이면, virusTime동안 speed의 값을 두 배로 늘인다.
			case 2: 
				speed = speed * 2;
				break;
//			 * 4. rand의 값이 3이면, virusTime동안 interval의 값을 두 배로 늘인다.
			case 3: 
				interval = interval * 2;
				break;
//			 * 5. rand의 값이 4이면, 화면의 모든 단어를 없앤다.
			case 4: 
				words.clear();
				break;
			} // swtich
			delay(virusTime);
			
		} // end of run()
	}

	class Word {
		String word = "";
		int x = 0;
		int y = 0;
		int step = 5;

		Color color = Color.BLACK;
		boolean isVirus = false;

		Word(String word) {
			this(word, 10, false);
		}

		Word(String word, boolean isVirus) {
			this(word, 10, isVirus);
		}

		Word(String word, int step, boolean isVirus) {
			this.word = word;
			this.step = step;
			this.isVirus = isVirus;

			if (isVirus)
				color = Color.RED;

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
			String input = tf.getText().trim();
			tf.setText("");

			System.out.println(input);

			if (!isPlaying)
				return;

			for (int i = 0; i < words.size(); i++) {
				Word tmp = (Word) words.get(i);

				if (input.equals(tmp.word)) {
					words.remove(i);
					score += input.length() * 50;
					lbScore.setText("Score:" + score);
					Toolkit.getDefaultToolkit().beep();

//					 * 1. 사용자가 입력한 단어가 바이러스면
//					 * VirusThread를 생성해서 실행시킨다.
					
					if(tmp.isVirus) new VirusThread().start();
						
					break;
				}
			} // for

			repaint(); // 변화가 있을때 마다 호출해야 바로 바로 적용된다.
		}

		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	} // class MyEventHandler
}
