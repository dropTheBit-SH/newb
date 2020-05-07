package Console;

//[문제4] 사용자 입력을 받는 프롬프트에 현재 작업중인 폴더(디렉토리)의 경로를 표시하는 예제의 코드를 완성하세요.

import java.util.*;
import java.io.*;

class ConsoleEx4 {
	static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
	static LinkedList q = new LinkedList(); // 사용자가 입력한 내용을 저장할 큐(Queue)
	static final int MAX_SIZE = 5; // Queue에 최대 5개까지만 저장되도록 한다.

	static File curDir; // 현재 디렉토리
	static {

//1. 시스템속성 "user.dir"값을 읽어서 File객체를 만들고, curDir에 할당하세요.
		try {
			File file = new File(System.getProperty("user.dir"));
			curDir = file;
//2. 1의 코드를 간단히 예외처리하세요.
		} catch (Exception e) {
			System.out.println("예외발생");
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in); // 한번만 생성해서 재사용하면 되므로 반복문 밖으로 이동

		while (true) {
			try {
				String prompt = curDir.getCanonicalPath() + ">>";
				System.out.print(prompt);

				// 화면으로부터 라인단위로 입력받는다.
				String input = s.nextLine();

				save(input);

				input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다.
				argArr = input.split(" +");

				String command = argArr[0].trim();

				if ("".equals(command))
					continue;

				command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.

				if (command.equals("q")) { // q 또는 Q를 입력하면 실행종료한다.
					System.exit(0);
				} else if (command.equals("history")) {
					history();
				} else {
					for (int i = 0; i < argArr.length; i++) {
						System.out.println(argArr[i]);
					}
				}
			} catch (Exception e) {
				System.out.println("입력오류입니다.");
			}
		} // while(true)
	} // main

	public static void save(String input) {
		if (input == null || "".equals(input))
			return;

		q.add(input); // queue에 저장한다.

		// queue의 최대크기를 넣으면 제일 오래된 저장값을 삭제한다.
		if (((LinkedList) q).size() > MAX_SIZE)
			q.remove();
	}

	public static void history() {
		int i = 0;

		// LinkedList의 내용을 보여준다.
		ListIterator it = q.listIterator();

		while (it.hasNext()) {
			System.out.println(++i + "." + it.next());
		}
	}
} // class

// [실행결과] - 현재 작업중인 폴더가 C:\java1000\work\Console일 경우
// C:\java1000\work\Console>>history
// 1.history
// C:\java1000\work\Console>>hello
// hello
// C:\java1000\work\Console>>q
