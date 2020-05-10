package Bingo;

//[문제1] 빙고게임소스의 일부입니다. 다음의 메서드를 완성하세요.
//
//void print() - 배열 bArr의 내용을 콘솔화면에 출력한다.(실행결과 참고)
//boolean checkBingo() - 빙고가 되었는지 확인한다.
//void actionPerformed(ActionEvent ae) - 빙고판의 버튼을 클릭했을 때 수행될 코드

import java.awt.*;
import java.awt.event.*;

public class BingoEx1 extends Frame {

	final int SIZE = 5; // 빙고판의 크기
	int bingoCnt = 0; // 완성된 라인의 수

	Button[] btnArr = null;
	boolean[][] bArr = new boolean[SIZE][SIZE]; // 빙고판 체크여부 확인을 위한 배열

	BingoEx1() {
		this("Bingo Game Ver1.0");
	}

	BingoEx1(String title) {
		super(title);

		setLayout(new GridLayout(SIZE, SIZE));

		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);

		btnArr = new Button[SIZE * SIZE];

		// Frame에 버튼을 추가한다.
		for (int i = 0; i < SIZE * SIZE; i++) {
			btnArr[i] = new Button(i + 1 + "");
			add(btnArr[i]);
			btnArr[i].addActionListener(handler);
		}

		setBounds(500, 200, 300, 300);
		setVisible(true);
	}

	void print() { // 배열 bArr을 출력한다.
//		 * 배열 bArr의 내용을 실행결과와 같은 형식으로 출력하세요.
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(bArr[i][j] ? "O" : "X");
			}
			System.out.println();
		}
		System.out.println("------------");
	}

	boolean checkBingo() { // 빙고가 완성되었는지를 확인한다.
		bingoCnt = 0;
		int garoCnt = 0; // 가로줄의 O의 개수
		int seroCnt = 0; // 세로줄의 O의 개수
		int crossCnt1 = 0; // 대각선의 O의 개수
		int crossCnt2 = 0; // 역대각선의 O의 개수

//		 * 1. 이중 반복문을 이용해서 배열 bArr의 값을 체크한다.
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
//		 * 2. 완성된 라인의 수를 세어서 SIZE의 개수보다 크거나 같으면 true를 그렇지 않으면 false를 반환한다.
		return bingoCnt >= SIZE;

	}

	public static void main(String args[]) {
		BingoEx1 win = new BingoEx1("Bingo Game Ver1.0");
		win.show();
	}

	class MyEventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Button btn = (Button) ae.getSource();

//			 * 1. 반복문을 통해, 버튼 배열 btnArr에서 btn(눌러진 버튼)과 같은 것을 찾는다.
			for (int i = 0; i < btnArr.length; i++) {
				if (btn == btnArr[i]) {
//			 * 1.1 찾으면, btnArr에서 btn을 찾은 위치(index)에 대응하는 bArr의 값을 확인한다.
//			 * (btnArr은 일차원 배열이고, bArr은 2차원 배열이므로 이 두 배열간의 관계를 잘고려해야한다.)
//			 * 1.1.1 bArr의 값이 true이면 "이미 누른 버튼입니다."라고 콘솔에 출력한다.
					if (bArr[i / 5][i % 5] == true) {
						System.out.println("이미 누른 버튼입니다.");
//			 * 1.1.2 bArr의 값이 false이면, true로 바꿔서 저장한다.
					} else {
						bArr[i / 5][i % 5] = true;
					}
				}
//			 * 1.2 btnArr에서 btn을 찾아서 작업을 마쳤으므로 반복문을 빠져나간다.
			} // for

//			 * 2. 1에서 찾은 버튼의 배경색을 노란색으로 바꾼다.(setBackground()사용)
			for (int i = 0; i < btnArr.length; i++) {
				if (bArr[i / 5][i % 5] == true)
					btnArr[i].setBackground(Color.YELLOW);
			}

//			 * 3. 배열 bArr을 콘솔에 출력한다.(BingoEx1클래스의 print()사용)
			print();
//			 * 4. checkBingo()를 호출해서 빙고가 완성되었는지 확인하고, 완성되었으면
//			 * 콘솔에 "Bingo~!!!"라고 출력한다.
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