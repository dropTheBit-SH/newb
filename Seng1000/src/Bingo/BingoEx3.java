package Bingo;

//[����3] ���� ������Ӽҽ��� checkBingo()�� �����ؼ� �ϼ��� ������ ��ư ���� ������� �ٲ�� �ϼ���.

import java.awt.*;
import java.awt.event.*;

class BingoEx3 extends Frame {

	final int SIZE = 5; // �������� ũ��
	int bingoCnt = 0; // �ϼ��� ������ ��

	Button[] btnArr = null;
	boolean[][] bArr = new boolean[SIZE][SIZE]; // ������ üũ���� Ȯ���� ���� �迭

	// ������ ��ư�� ����� ���ڿ�, �������� ũ�⿡ ���� �̵��� �Ϻθ� ���� �� �ִ�.
	String[] values = { "�۽�", "��η�", "��â��", "��õ��ǥ", "���", "���ü�", "������", "�аԺ���", "�׶��ָ�", "�ٹ�", "��Ŭ����", "�鰳", "�𺧷�", "����",
			"���", "��������", "������", "����û��", "��õ��", "���", "���Ƿ�", "������", "��", "����", "����", "���ȣ", "�����", "������", "���̽�", "����",
			"���̳���", "����Ŭ��", "���ִ�", "�������", "������", "������", "����", "����", "ī��", "Ĳ��", "�¿�", "��Ƽ��", "�丣�Ҹ�", "��ǳ", "�ͺ�����",
			"��ũ�Ҵ�", "�ϴ���", "�Ϸ�", "�Ѱ���", "�淹����", "ȭ����", "���" };

	BingoEx3() {
		this("Bingo Game Ver1.0");
	}

	BingoEx3(String title) {
		super(title);

		setLayout(new GridLayout(SIZE, SIZE));

		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);

		btnArr = new Button[SIZE * SIZE];

		shuffle();

		// Frame�� ��ư�� �߰��Ѵ�.
		for (int i = 0; i < SIZE * SIZE; i++) {
			btnArr[i] = new Button(values[i]); // ���ڿ��迭 values�� ���� ��ư�� Label�� �Ѵ�.
			add(btnArr[i]);
			btnArr[i].addActionListener(handler);
		}

		setBounds(500, 200, 300, 300);
		setVisible(true);
	}

	void shuffle() {
		for (int i = 0; i < values.length * 2; i++) {
			int r1 = (int) (Math.random() * values.length);
			int r2 = (int) (Math.random() * values.length);

			String tmp = values[r1];
			values[r1] = values[r2];
			values[r2] = tmp;
		}
	}

	void print() { // �迭 bArr�� ����Ѵ�.
		for (int i = 0; i < bArr.length; i++) {
			for (int j = 0; j < bArr.length; j++) {
				System.out.print(bArr[i][j] ? "O" : "X");
			}
			System.out.println();
		}
		System.out.println("----------------");
//             System.out.println(bingoCnt);
	}

	boolean checkBingo() { // ���� �ϼ��Ǿ������� Ȯ���Ѵ�.
		bingoCnt = 0;
		int garoCnt = 0;
		int seroCnt = 0;
		int crossCnt1 = 0;
		int crossCnt2 = 0;

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i + j == SIZE - 1 && bArr[i][j])
					crossCnt2++;
				if (i == j && bArr[i][j])
					crossCnt1++;
				if (bArr[i][j])
					garoCnt++;
				if (bArr[j][i])
					seroCnt++;
			}

			if (garoCnt == SIZE) {
				bingoCnt++;
				for(int j = 0; j < SIZE; j++) btnArr[(i*5)+j].setBackground(Color.GREEN);
			}
			if (seroCnt == SIZE) {
				bingoCnt++;
				for(int j = 0; j < SIZE; j++) btnArr[i+(j*5)].setBackground(Color.GREEN);
			}

			garoCnt = 0;
			seroCnt = 0;
		}

		if (crossCnt1 == SIZE) {
			bingoCnt++;
			for(int j = 0; j < SIZE; j++) btnArr[(j*5)+j].setBackground(Color.GREEN);
		}
		if (crossCnt2 == SIZE) {
			bingoCnt++;
			for(int j = 0; j < SIZE; j++) btnArr[(j+1)*4].setBackground(Color.GREEN);
		}

		System.out.println(bingoCnt);
		return bingoCnt >= SIZE;
	}

	public static void main(String args[]) {
		BingoEx3 win = new BingoEx3("Bingo Game Ver1.0");
		win.show();
	}

	class MyEventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Button btn = (Button) ae.getSource();

			System.out.println(btn.getLabel()); // ������ ��ư�� Label�� �ֿܼ� ����Ѵ�.

			for (int i = 0; i < btnArr.length; i++) {
				if (btnArr[i] == btn) {
					bArr[i / SIZE][i % SIZE] = true;
					break;
				}
			}

			btn.setBackground(Color.YELLOW);
			print();
			if (checkBingo()) {
				System.out.println("Bingo~!!!");
			}
		}

		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	}
}
