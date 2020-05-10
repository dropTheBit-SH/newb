package Bingo;

//[문제3] 이전 빙고게임소스의 checkBingo()를 변경해서 완성된 라인의 버튼 색을 녹색으로 바뀌게 하세요.

import java.awt.*;
import java.awt.event.*;

class BingoEx3 extends Frame {

	final int SIZE = 5; // 빙고판의 크기
	int bingoCnt = 0; // 완성된 라인의 수

	Button[] btnArr = null;
	boolean[][] bArr = new boolean[SIZE][SIZE]; // 빙고판 체크여부 확인을 위한 배열

	// 빙고판 버튼에 사용할 문자열, 빙고판의 크기에 따라 이들의 일부만 사용될 수 있다.
	String[] values = { "글쎄", "기로로", "김창우", "김천대표", "까꿍", "남궁성", "낭군이", "넓게보기", "네라주리", "다밀", "더클레오", "들개", "디벨로", "레몬",
			"루션", "루이지노", "무색이", "문학청년", "사천사", "상상", "세피룸", "스쿨쥐", "쌩", "쏭양", "씨드", "양수호", "에노야", "에비츄", "에이스", "엔즈",
			"오이날다", "오케클릭", "용주니", "우기파파", "잠탱이", "제러스", "조땜", "지냔", "카라", "캉스", "태연", "파티쉐", "페르소마", "폭풍", "핏빛노을",
			"핑크팬더", "하늘이", "하루", "한경훈", "헐레벌떡", "화염병", "흑빛" };

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

		// Frame에 버튼을 추가한다.
		for (int i = 0; i < SIZE * SIZE; i++) {
			btnArr[i] = new Button(values[i]); // 문자열배열 values의 값을 버튼의 Label로 한다.
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

	void print() { // 배열 bArr을 출력한다.
		for (int i = 0; i < bArr.length; i++) {
			for (int j = 0; j < bArr.length; j++) {
				System.out.print(bArr[i][j] ? "O" : "X");
			}
			System.out.println();
		}
		System.out.println("----------------");
//             System.out.println(bingoCnt);
	}

	boolean checkBingo() { // 빙고가 완성되었는지를 확인한다.
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

			System.out.println(btn.getLabel()); // 눌러진 버튼의 Label을 콘솔에 출력한다.

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
