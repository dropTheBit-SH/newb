package Bingo;

//[����2] ���� ������Ӽҽ��� �����ؼ� �������� ��ư�� ���ڴ�� ������ ���ڿ��� ���ǵ��� �����ϼ���.
//void shuffle() - �������� ��ư�� ���� ���ڿ� �迭 values�� ������ �ڼ��´�.
//[����BingoEx2.java]

import java.awt.*;
import java.awt.event.*;

public class BingoEx2 extends Frame {

	final int SIZE = 5; // �������� ũ��
	int bingoCnt = 0; // �ϼ��� ������ ��

	Button[] btnArr = null;
	boolean[][] bArr = new boolean[SIZE][SIZE]; // ������ üũ���� Ȯ���� ���� �迭

	// ������ ��ư�� ����� ���ڿ�, �������� ũ�⿡ ���� �̵��� �Ϻθ� ���� �� �ִ�.
	String[] values = { "�۽�", "��η�", "��â��", "��õ��ǥ", "���", "���ü�", "������", "�аԺ���", "�׶��ָ�", "�ٹ�", "��Ŭ����", "�鰳", "�𺧷�", "����",
			"���", "��������", "������", "����û��", "��õ��", "���", "���Ƿ�", "������", "��", "����", "����", "���ȣ", "�����", "������", "���̽�", "����",
			"���̳���", "����Ŭ��", "���ִ�", "�������", "������", "������", "����", "����", "ī��", "Ĳ��", "�¿�", "��Ƽ��", "�丣�Ҹ�", "��ǳ", "�ͺ�����",
			"��ũ�Ҵ�", "�ϴ���", "�Ϸ�", "�Ѱ���", "�淹����", "ȭ����", "���" };

	BingoEx2() {
		this("Bingo Game Ver1.0");
	}

	BingoEx2(String title) {
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
		// 1. �ݺ����� ����ؼ� ���ڿ� �迭 values�� �� ����� ��ġ�� �ڹٲ۴�.
		for(int i=0; i<values.length; i++) {
			int cnt = (int)(Math.random() * values.length);
			String tmp = values[i];
			values[i] = values[cnt];
			values[cnt] = tmp;
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
		int garoCnt = 0; // �������� O�� ����

		int seroCnt = 0; // �������� O�� ����
		int crossCnt1 = 0; // �밢���� O�� ����
		int crossCnt2 = 0; // ���밢���� O�� ����

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

			if (garoCnt == SIZE)
				bingoCnt++;
			if (seroCnt == SIZE)
				bingoCnt++;
//                   if(bingoCnt>=SIZE) return true;
			garoCnt = 0;
			seroCnt = 0;
		}

		if (crossCnt1 == SIZE)
			bingoCnt++;
		if (crossCnt2 == SIZE)
			bingoCnt++;

		System.out.println(bingoCnt);
		return bingoCnt >= SIZE;
	}

	public static void main(String args[]) {
		BingoEx2 win = new BingoEx2("Bingo Game Ver1.0");
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
