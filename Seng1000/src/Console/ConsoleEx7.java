package Console;

//[문제7] 지정된 키워드를 지정된 파일에서 찾아서 화면에 보여주는 find명령어를 구현하라.
//(해당 KEYWORD가 포함된 라인과 라인번호를 화면에 출력, 실행결과 참고)
//명령어의 형식은 'find KEYWORD FILE_NAME'이며, 형식에 맞지 않을때는 사용법을 보여준다
//
//KEYWORD - 지정된 파일에서 찾기 원하는 문자열
//FILE_NAME - KEYWORD가 포함된 내용을 찾을 파일(console*.*과 같은 패턴지원하지 않음)

import java.io.*;
import java.util.*;
import java.util.regex.*;

class ConsoleEx7 {
	static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
	static LinkedList q = new LinkedList(); // 사용자가 입력한 내용을 저장할 큐(Queue)
	static final int MAX_SIZE = 5; // Queue에 최대 5개까지만 저장되도록 한다.

	static File curDir;

	static {
		try {
			curDir = new File(System.getProperty("user.dir"));
		} catch (Exception e) {
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
				argArr = input.split(" +"); // 처음엔 " "로 했다가 문제점을 설명하고 개선방법으로 제시

				String command = argArr[0].trim();

				if ("".equals(command))
					continue;

				command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.

				if (command.equals("q")) { // q 또는 Q를 입력하면 실행종료한다.
					System.exit(0);
				} else if (command.equals("history")) {
					history();
				} else if (command.equals("dir")) {
					dir();
				} else if (command.equals("type")) {
					type();
				} else if (command.equals("find")) {
					find();
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
		/* 내용 생략 */
	}

	public static void history() {
		/* 내용 생략 */
	}

	public static void dir() {

		/* 내용 생략 */
	} // dir()

	public static void type() throws IOException {
		if (argArr.length != 2) {
			System.out.println("Usage : type FILE_NAME");
			return;
		}

		String fileName = argArr[1];

		File tmp = new File(curDir, fileName);

		if (tmp.exists()) {
			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			for (int i = 1; (line = br.readLine()) != null; i++) {
				System.out.println(line);
			}
		} else {
			System.out.println(fileName + " 존재하지 않는 파일입니다.");
		}

		return;
	}

	public static void find() throws IOException {
		if (argArr.length != 3) {
			System.out.println("USAGE : find KEYWORD FILE_NAME");
			return;
		}

		String keyword = argArr[1];
		String fileName = argArr[2];

		File tmp = new File(fileName);

//		 * 1. 파일(tmp)이 존재하면,
		if(tmp.exists()){
//		 * 1.1 반복문을 이용해서 라인별로 읽어서 keyword가 포함되었는지 확인한다.
//		 * (BufferedReader의 readLine()사용)
			try(FileReader fr = new FileReader(tmp);
				BufferedReader br = new BufferedReader(fr)){
				String line = null;
				int cnt = 0;
				while((line = br.readLine()) != null){
					cnt++;
					if(line.matches(".*"+keyword+".*")){
						System.out.printf("%d: %s\n", cnt, line);
					}
				}
//		 * 1.2 keyword가 포함된 라인을 발견하면, 라인번호와 함께 해당 라인을 화면에 출력한다.
				
			}catch (Exception e) {
			}
//		 * 2. 존재하지 않으면, 존재하지 않는 파일이라고 화면에 출력한다.
		}else{
			System.out.println("존재하지 않는 파일");
		}

		return;
	}
} // class
