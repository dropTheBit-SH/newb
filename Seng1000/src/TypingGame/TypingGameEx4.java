package TypingGame;

//[����4] ���̷����� �ɸ� �ܾ ��Ÿ������ ����� �߰��Ͽ���. ���̷����� �ɸ� �ܾ�� ������(Color.RED)�� ǥ�õǸ�
//���̷����� �ɸ� �ܾ �Է��ϸ�, ���̷����� ������ ���� �����ð����� �ܾ �������� �ӵ��� ���� �Ǵ� �����ϰ�
//�ܾ ȭ�鿡 ��Ÿ���� �ð�(interval)�� ª�����ų� �������. ȭ���� ��� �ܾ ����� ���� ���̷����� �ִ�.

import java.util.*;
import java.awt.*;
import java.awt.event.*;

class TypingGameEx4 extends Frame {
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

				// �� 10���� �ѹ� �÷� ���̷����� �����Ѵ�.
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
			int virusTime = 10 * 1000; // 10�ʰ� ���̷����� �����Ѵ�.

			switch (rand) {
//			 * 1. rand�� ���� 0�̸�, virusTime���� speed�� ���� �������� ���δ�.
			case 0: 
				speed = speed / 2;
				break;
//			 * 2. rand�� ���� 1�̸�, virusTime���� interval�� ���� �������� ���δ�.
			case 1: 
				interval = interval / 2;
				break;
//			 * 3. rand�� ���� 2�̸�, virusTime���� speed�� ���� �� ��� ���δ�.
			case 2: 
				speed = speed * 2;
				break;
//			 * 4. rand�� ���� 3�̸�, virusTime���� interval�� ���� �� ��� ���δ�.
			case 3: 
				interval = interval * 2;
				break;
//			 * 5. rand�� ���� 4�̸�, ȭ���� ��� �ܾ ���ش�.
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

//					 * 1. ����ڰ� �Է��� �ܾ ���̷�����
//					 * VirusThread�� �����ؼ� �����Ų��.
					
					if(tmp.isVirus) new VirusThread().start();
						
					break;
				}
			} // for

			repaint(); // ��ȭ�� ������ ���� ȣ���ؾ� �ٷ� �ٷ� ����ȴ�.
		}

		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	} // class MyEventHandler
}
