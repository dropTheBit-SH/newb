package Bingo;

//[����1] ������Ӽҽ��� �Ϻ��Դϴ�. ������ �޼��带 �ϼ��ϼ���.
//
//void print() - �迭 bArr�� ������ �ܼ�ȭ�鿡 ����Ѵ�.(������ ����)
//boolean checkBingo() - ���� �Ǿ����� Ȯ���Ѵ�.
//void actionPerformed(ActionEvent ae) - �������� ��ư�� Ŭ������ �� ����� �ڵ�

import java.awt.*;
import java.awt.event.*;

public class BingoEx1 extends Frame {

	final int SIZE = 5; // �������� ũ��
	int bingoCnt = 0; // �ϼ��� ������ ��

	Button[] btnArr = null;
	boolean[][] bArr = new boolean[SIZE][SIZE]; // ������ üũ���� Ȯ���� ���� �迭

	BingoEx1() {
		this("Bingo Game Ver1.0");
	}

	BingoEx1(String title) {
		super(title);

		setLayout(new GridLayout(SIZE, SIZE));

		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);

		btnArr = new Button[SIZE * SIZE];

		// Frame�� ��ư�� �߰��Ѵ�.
		for (int i = 0; i < SIZE * SIZE; i++) {
			btnArr[i] = new Button(i + 1 + "");
			add(btnArr[i]);
			btnArr[i].addActionListener(handler);
		}

		setBounds(500, 200, 300, 300);
		setVisible(true);
	}

	void print() { // �迭 bArr�� ����Ѵ�.
//		 * �迭 bArr�� ������ �������� ���� �������� ����ϼ���.
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(bArr[i][j] ? "O" : "X");
			}
			System.out.println();
		}
		System.out.println("------------");
	}

	boolean checkBingo() { // ���� �ϼ��Ǿ������� Ȯ���Ѵ�.
		bingoCnt = 0;
		int garoCnt = 0; // �������� O�� ����
		int seroCnt = 0; // �������� O�� ����
		int crossCnt1 = 0; // �밢���� O�� ����
		int crossCnt2 = 0; // ���밢���� O�� ����

//		 * 1. ���� �ݺ����� �̿��ؼ� �迭 bArr�� ���� üũ�Ѵ�.
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (bArr[i][j]) garoCnt++;
				if (bArr[j][i]) seroCnt++;
				if (i==j && bArr[i][j]) crossCnt1++;
				if (i+j==SIZE-1 && bArr[i][j]) crossCnt2++;
			}
			if (garoCnt == SIZE) bingoCnt++;
			if (seroCnt == SIZE) bingoCnt++;
			garoCnt = 0;
			seroCnt = 0;
		}
		if(crossCnt1 == SIZE) bingoCnt++;
		if(crossCnt2 == SIZE) bingoCnt++;
		
		System.out.println(bingoCnt);
//		 * 2. �ϼ��� ������ ���� ��� SIZE�� �������� ũ�ų� ������ true�� �׷��� ������ false�� ��ȯ�Ѵ�.
		return bingoCnt >= SIZE;

	}

	public static void main(String args[]) {
		BingoEx1 win = new BingoEx1("Bingo Game Ver1.0");
		win.show();
	}

	class MyEventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Button btn = (Button) ae.getSource();

//			 * 1. �ݺ����� ����, ��ư �迭 btnArr���� btn(������ ��ư)�� ���� ���� ã�´�.
			for (int i = 0; i < btnArr.length; i++) {
				if (btn == btnArr[i]) {
//			 * 1.1 ã����, btnArr���� btn�� ã�� ��ġ(index)�� �����ϴ� bArr�� ���� Ȯ���Ѵ�.
//			 * (btnArr�� ������ �迭�̰�, bArr�� 2���� �迭�̹Ƿ� �� �� �迭���� ���踦 �߰���ؾ��Ѵ�.)
//			 * 1.1.1 bArr�� ���� true�̸� "�̹� ���� ��ư�Դϴ�."��� �ֿܼ� ����Ѵ�.
					if (bArr[i / 5][i % 5] == true) {
						System.out.println("�̹� ���� ��ư�Դϴ�.");
//			 * 1.1.2 bArr�� ���� false�̸�, true�� �ٲ㼭 �����Ѵ�.
					} else {
						bArr[i / 5][i % 5] = true;
					}
				}
//			 * 1.2 btnArr���� btn�� ã�Ƽ� �۾��� �������Ƿ� �ݺ����� ����������.
			} // for

//			 * 2. 1���� ã�� ��ư�� ������ ��������� �ٲ۴�.(setBackground()���)
			for (int i = 0; i < btnArr.length; i++) {
				if (bArr[i / 5][i % 5] == true)
					btnArr[i].setBackground(Color.YELLOW);
			}

//			 * 3. �迭 bArr�� �ֿܼ� ����Ѵ�.(BingoEx1Ŭ������ print()���)
			print();
//			 * 4. checkBingo()�� ȣ���ؼ� ���� �ϼ��Ǿ����� Ȯ���ϰ�, �ϼ��Ǿ�����
//			 * �ֿܼ� "Bingo~!!!"��� ����Ѵ�.
			if (checkBingo() == true)
				System.out.println("Bingo~!!!");
		}

		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	}
}