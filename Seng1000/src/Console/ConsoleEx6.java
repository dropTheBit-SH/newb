package Console;

//[문제6] 지정된 파일의 내용을 보여주는 type명령을 구현하라. type명령의 형식은 'type FILE_NAME'이며,
//            FILE_NAME으로 지정된 파일을 찾아서 그 내용을 화면에 보여줘야한다.
//            단, FILE_NAME은 현재 디렉토리에 포함된 파일이어야 하며, 해당 파일이 존재하지 않으면
//             존재하지 않는 파일이라고 화면에 출력한다.

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ConsoleEx6 {
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
				argArr = input.split(" +");

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
		String pattern = "";

		switch (argArr.length) {
		case 1:
			for (File f : curDir.listFiles()) {
				if (f.isDirectory()) {
					System.out.println("[" + f.getName() + "]");
				} else {
					System.out.println(f.getName());
				}
			}
			break;
		case 2:
			pattern = argArr[1];
			pattern = pattern.toUpperCase();
			pattern = pattern.replace(".", "\\.");
			pattern = pattern.replace("*", ".*");
			pattern = pattern.replace("?", ".{1}");

			Pattern p = Pattern.compile(pattern);

			for (File f : curDir.listFiles()) {
				String tmp = f.getName().toUpperCase();
				Matcher m = p.matcher(tmp);

				if (m.matches()) {
					if (f.isDirectory()) {
						System.out.println("[" + f.getName() + "]");
					} else {
						System.out.println(f.getName());
					}
				}
			} // for

			break;
		default:
			System.out.println("USAGE : dir [FILENAME]");
		} // switch
	} // dir()

	public static void type() throws IOException {
		if (argArr.length != 2) {
			System.out.println("Usage : type FILE_NAME");
			return;
		}

		String fileName = argArr[1];

		File tmp = new File(fileName);

//		 * 1. 파일(tmp)가 존재하는지 확인하고,
		if(tmp.exists()){
//		 * 1.1 존재하면, 파일의 내용을 화면에 출력한다.
//		 * (FileReader와 BufferedReader를 사용)
			try(FileReader fr = new FileReader(tmp);
					BufferedReader br = new BufferedReader(fr)){
				String line = "";
				while((line = br.readLine()) != null)
					System.out.println(line);
			}catch (Exception e) {
			}
//		 * 1.2 존재하지 않으면, 존재하지 않는 파일이라고 출력한다.
		}else{
			System.out.println("존재하지 않는 파일");
		}

		return;
	}
} // class
