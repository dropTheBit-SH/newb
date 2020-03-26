package day09.ch04.ex04;

import java.util.Scanner;

import day09.ex03.People;

public class Ch04Ex06 {
	public static final int MAX = 100;
	private People[] pArr = new People[100];
	private int top = 0; // 0부터 100까지 : 삭제하면 감소
	private int sequence = 0; // 객체가 생성될 때 감소 없이 계속 증가 idx의 고유번호
	private String inputStr = "";
	private int inputInt = 0;
	public static final Scanner scan = new Scanner(System.in);

	public Ch04Ex06() { // constructor 생성자
		while (true) {
			run();
		}
	}

	public void reset() {
		inputStr = "";
		inputInt = 0;
	}

	public void run() {
		switch (menu()) {
		case 1:
			input();
			break;
		case 2:
			output();
			break;
		case 3:
			search();
			break;
		case 4:
			modify();
			break;
		case 5:
			delete();
			break;
		case 6:
			finish();
			break;
		}
	}

	public int menu() {
		int no = 0;
		while (true) {
			inputStr = "";
			System.out.println("----------------------------------");
			System.out.println("1.입력  2.출력  3.검색  4.수정  5.삭제  6.종료");
			System.out.print("번호 선택>> ");
			inputStr = scan.next();
			if (inputStr.matches("[1-6]+")) {
				no = Integer.parseInt(inputStr);
				break;
			} else {
				System.out.println("숫자 1~6까지만 입력할 수 있습니다!");
			}
		}
		reset();
		return no;

	}

	public void input() {
		System.out.println("입력기능...");
		if (top >= pArr.length) {
			System.out.println("더 이상 입력은 불가능합니다!");
			return;
		}
		// 1. 객체 생성
		People p = new People();
		// 2. 객체에 데이터 넣기
		p.setIdx(sequence++);
		System.out.print("성명: ");
		p.setName(scan.next());
		System.out.print("전화번호:");
		p.setPhone(scan.next());
		// 3. 객체를 배열의 top번지에 담기 (top이 index)
		pArr[top++] = p;
		System.out.println("                        ...입력완료");
	}

	public void output() {
		output: do {
			System.out.println("출력기능...");
			// 입력된 연락처가 없다면 메뉴로 돌아가기
			if (sequence == 0) {
				System.out.println("아직 입력된 연락처가 없습니다!");
				break output;
			}
			// 출력하기
			for (People p : pArr) {
				if (p == null)
					break;
				System.out.println(p);
			}
			System.out.println("                        ...출력완료");
			break output;
		} while (true);

	}

	public void search() {
		search: do {
			System.out.println("검색기능...");
			// 입력된 연락처가 없다면 메뉴로 돌아가기
			if (sequence == 0) {
				System.out.println("아직 입력된 연락처가 없습니다!");
				break search;
			}
			// 검색하기
			System.out.print("이름 또는 전화번호를 입력해주세요>>");
			inputStr = scan.next();
			int count = 0;
			for (int i = 0; i < sequence; i++) {
				String pArrStr = pArr[i].toString();
				// 배열 안의 문자열과 일치하거나 핸드폰 번호와 일치하면 결과출력
				if ((inputStr.matches(pArrStr) || inputStr.equals(pArr[i].getPhone()))) {
					System.out.println(pArr[i]);
					count++;
				}
			}
			System.out.println(count == 0 ? "찾을 수 없습니다" : "                        ...검색 완료");
			break search;
		} while (true);
	}

	public void modify() {
		modify: do {
			inputStr = "";
			int inputInt = 0;
			System.out.println("수정기능...");
			// 입력된 연락처가 없다면 메뉴로 돌아가기
			if (sequence == 0) {
				System.out.println("아직 입력된 연락처가 없습니다!");
				break modify;
			}
			// 인덱스 확인 요청
			System.out.print("(검색부터 하려면 *를 누르세요)\n");
			System.out.print("수정할 연락처의 인덱스를 입력해주세요>>");
			inputStr = scan.next();
			if (inputStr.equals("*"))
				search();
			// 인덱스 값 유효성 검사: 숫자인지
			if (inputStr.matches("[0-9]+")) {
				inputInt = Integer.parseInt(inputStr);
			} else {
				System.out.println("잘못 입력하여 메뉴로 돌아갑니다!");
				break modify;
			}
			// 인덱스 값 유효성 검사: 값이 있는지
			if (inputInt>sequence-1) {
				System.out.println("잘못 입력하여 메뉴로 돌아갑니다!");
				break modify;
			}
			// 수정하기
			System.out.println(pArr[inputInt]);
			System.out.print("수정할 이름>>");
			pArr[inputInt].setName(scan.next());
			System.out.print("수정할 전화번호>>");
			pArr[inputInt].setPhone(scan.next());
			System.out.println("                        ...수정완료");
			break modify;
		} while (true);
	}

	public void delete() {
		delete: do {
			inputStr = "";
			int inputInt = 0;
			System.out.println("삭제기능...");
			// 입력된 연락처가 없다면 메뉴로 돌아가기
			if (sequence == 0) {
				System.out.println("아직 입력된 연락처가 없습니다!");
				break delete;
			}
			// 인덱스 확인 요청
			System.out.print("(검색부터 하려면 *를 누르세요)\n");
			System.out.print("삭제할 연락처의 인덱스를 입력해주세요>>");
			inputStr = scan.next();
			if (inputStr.equals("*"))
				search();
			// 인덱스 값 유효성 검사: 숫자인지
			if (inputStr.matches("[0-9]+")) {
				inputInt = Integer.parseInt(inputStr);
				System.out.println(pArr[inputInt]);
			} else {
				System.out.println("잘못 입력하여 메뉴로 돌아갑니다!");
				break delete;
			}
			// 인덱스 값 유효성 검사: 값이 있는지
			if (inputInt>sequence-1) {
				System.out.println("잘못 입력하여 메뉴로 돌아갑니다!");
				break delete;
			}
			// 삭제 확인 요청
			while (true) {
				System.out.print("정말 삭제하시겠습니까?(y/n)>>");
				String delCheck = scan.next();
				if (delCheck.equals("y")) {
					pArr[inputInt].setName("0");
					pArr[inputInt].setPhone("0");
					System.out.println("                        ...삭제완료");
					break;
				} else if (delCheck.equals("n")) {
					break;
				} else {
					continue;
				}
			}
			break delete;
		} while (true);

	}

	public void finish() {
		System.out.println("                        ...종료");
		System.exit(0);
	}

	public static void main(String[] args) {
		new Ch04Ex06();
	}
}
