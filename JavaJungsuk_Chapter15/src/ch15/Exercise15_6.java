package ch15;

//[15-6] 다음은 콘솔 명령어 중에서 디렉토리를 변경하는 cd명령을 구현한 것이다. 
import java.io.File;
import java.util.*;
import java.util.regex.*;

class Exercise15_6 {
	static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
	static File curDir; // 현재 디렉토리
	static {
		try {
			curDir = new File(System.getProperty("user.dir"));
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				String prompt = curDir.getCanonicalPath() + ">>";
				System.out.print(prompt);
				// 화면으로부터 라인단위로 입력받는다.
				String input = s.nextLine();
				input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다.
				argArr = input.split(" +");
				String command = argArr[0].trim();
				if ("".equals(command))
					continue;
				command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.
				if (command.equals("q")) { // q 또는 Q를 입력하면 실행종료한다.
					System.exit(0);
				} else if (command.equals("cd")) {
					cd();
				} else {
					for (int i = 0; i < argArr.length; i++) {
						System.out.println(argArr[i]);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("입력오류입니다.");
			}
		} // while(true)
	} // main

	public static void cd() {
		if (argArr.length == 1) {
			System.out.println(curDir);
			return;
		} else if (argArr.length > 2) {
			System.out.println("USAGE : cd directory");
			return;
		}
		String subDir = argArr[1];
		//1. 입력된 디렉토리(subDir)가 ".."이면,
		if(subDir.equals("..")) {
		//1.1 현재 디렉토리의 조상 디렉토리를 얻어서 현재 디렉토리로 지정한다.
		//(File클래스의 getParentFile()을 사용)
			curDir = curDir.getParentFile();
		//2. 입력된 디렉토리(subDir)가 "."이면, 단순히 현재 디렉토리의 경로를 화면에 출력한다.
		}else if(subDir.equals(".")) {
			System.out.println(curDir);
		//3. 1 또는 2의 경우가 아니면,
		}else {
		//3.1 입력된 디렉토리(subDir)가 현재 디렉토리의 하위디렉토리인지 확인한다.
			File tmpDir = new File(subDir);
			//3.2 확인결과가 true이면, 현재 디렉토리(curDir)을 입력된 디렉토리(subDir)로 변경한다.
			if(tmpDir.getParent().equals(curDir.getPath())) {
				curDir = tmpDir;
			//3.3 확인결과가 false이면, "유효하지 않은 디렉토리입니다."고 화면에 출력한다.
			}else {
				System.out.println("유효하지 않은 디렉토리입니다.");
			}
		}
	}// cd()
}