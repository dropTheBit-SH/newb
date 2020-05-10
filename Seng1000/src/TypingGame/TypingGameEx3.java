package TypingGame;

//[����3] �̹��� AWT�� ����ؼ� ���� Ÿ�ڰ����� GUI(Graphic User Interface)�����Դϴ�.
//�ϴ��� TextField�� �ܾ �Է��ϰ� 'Enter'Ű�� ������, ��ġ�ϴ� �ܾ ȭ�鿡�� ������ϴ�.
//�ܾ �ٴڿ� ������ ������ �Է����� ���ϸ� life�� 1 �����ϰ� life�� ���� 0�� �Ǹ� ������ ����˴ϴ�.

import java.util.*;
import java.awt.*;
import java.awt.event.*;

class TypingGameEx3 extends Frame {
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;

	final int SCREEN_WIDTH;
	final int SCREEN_HEIGHT;

	int speed = 500; // �ܾ �������� �ӵ�... ���� ���� ������.
	int interval = 2 * 1000; // ���ο� �ܾ ������ ����

	int level = 0;
	int score = 0;
	int life = 3;

	boolean isPlaying = false;

	WordGenerator wg = null; // �ܾ �����ϴ� ������
	WordDropper wm = null; // �ܾ ����߸��� ������

	FontMetrics fm; // ȭ�鿡���� ���� ���̸� ���ϴµ� ���

	String[] data = { "�¿�", "����", "����", "ȿ��", "����", "����", "Ƽ�Ĵ�", "���", "����ī" };

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

//			 * 1. TextField�� ���� �о �����Ѵ�.(getText()���)
			String input = tf.getText().trim();
//			 * 2. TextField�� ����.
			tf.setText("");
//			 * 3. ������(isPlaying)�� �ƴϸ�, ����������.
			if(!isPlaying) return;
//			 * 4. �ݺ����� �̿��ؼ� ����ڰ� TextField�� �Է��� �ܾ words���� ã�´�
			for(int i=0; i<words.size(); i++) {
				Word tmp = (Word)words.get(i);
//			 * 4.1 ã����, words���� �����Ѵ�.
				if(input.equals(tmp.word)) {
					words.remove(i);
//			 * 4.2 �ܾ��� ���̿� ���� score�� ������Ų��.(�ܾ��� ���ڰ��� * 50)
					score += input.length() * 50;
					lbScore.setText("Score:"+score);
//			 * 4.3 '��~'�Ҹ��� ���� �Ѵ�.(Toolkit.getDefaultToolkit().beep()���)
					Toolkit.getDefaultToolkit().beep();
				}
			}
//			 * 5. ȭ���� �ٽ� �׸��� �Ѵ�.(repaint()���)
			repaint();
		}

		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	} // class MyEventHandler
}
