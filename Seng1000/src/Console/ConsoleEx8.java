package Console;

//[����8] ����7���� ������ find�� ������ �����ϵ��� ����� Ȯ���� find2��ɾ �����϶�.
//find�� �ϳ��� ���Ͽ� ���ؼ��� ã�Ⱑ ����������, find2�� 'find2 if *.java'�� ����
//������ �̿��ؼ� �������Ͽ� ���� ã�Ⱑ �����ؾ��Ѵ�.(������ ����)

import java.io.*;
import java.util.*;
import java.util.regex.*;

class ConsoleEx8 {
	static String[] argArr; // �Է��� �Ű������� ������� ���ڿ��迭
	static LinkedList q = new LinkedList(); // ����ڰ� �Է��� ������ ������ ť(Queue)
	static final int MAX_SIZE = 5; // Queue�� �ִ� 5�������� ����ǵ��� �Ѵ�.

	static File curDir;

	static {
		try {
			curDir = new File(System.getProperty("user.dir"));
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in); // �ѹ��� �����ؼ� �����ϸ� �ǹǷ� �ݺ��� ������ �̵�

		while (true) {
			try {
				String prompt = curDir.getCanonicalPath() + ">>";
				System.out.print(prompt);

				// ȭ�����κ��� ���δ����� �Է¹޴´�.
				String input = s.nextLine();

				save(input);

				input = input.trim(); // �Է¹��� ������ ���ʿ��� �յ� ������ �����Ѵ�.
				argArr = input.split(" +");

				String command = argArr[0].trim();

				if ("".equals(command))
					continue;

				command = command.toLowerCase(); // ��ɾ �ҹ��ڷ� �ٲ۴�.

				if (command.equals("q")) { // q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�.
					System.exit(0);
				} else if (command.equals("history")) {
					history();
				} else if (command.equals("dir")) {
					dir();
				} else if (command.equals("type")) {
					type();
				} else if (command.equals("find")) {
					find();
				} else if (command.equals("find2")) {
					find2();
				} else {
					for (int i = 0; i < argArr.length; i++) {
						System.out.println(argArr[i]);
					}
				}
			} catch (Exception e) {
				System.out.println("�Է¿����Դϴ�.");
			}
		} // while(true)
	} // main

	public static void save(String input) {
		/* ���� ���� */

	}

	public static void history() {
		/* ���� ���� */

	}

	public static void dir() {
		/* ���� ���� */

	} // dir()

	public static void type() throws IOException {
		/* ���� ���� */

	}

	public static void find() throws IOException {
		if (argArr.length != 3) {
			System.out.println("USAGE : find KEYWORD FILE_NAME");
			return;
		}

		String keyword = argArr[1];
		String fileName = argArr[2];

		File tmp = new File(fileName);

		if (tmp.exists()) {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String line = "";

			for (int i = 1; (line = br.readLine()) != null; i++) {
				// keyword�� ������ ������ ����Ѵ�.
				if (line.indexOf(keyword) != -1)
					System.out.println(i + ":" + line);
			}
		} else {
			System.out.println(fileName + " �������� �ʴ� �����Դϴ�.");
		}

		return;
	}

	public static void find2() throws IOException {
		if (argArr.length != 3) {
			System.out.println("USAGE : find2 KEYWORD FILE_NAME");
			return;
		}

		String keyword = argArr[1];
		String pattern = argArr[2];

		pattern = pattern.toUpperCase();
		// * 1. �Էµ� ����(pattern)�� ���Խ� ǥ��(Regular Expression)�� �˸°� ġȯ�Ѵ�.
		// * StringŬ������ String replace(CharSequence target, CharSequence
		// * replacement)�� �������.
		// * ���� ���, pattern = pattern.replace("A","AA")�� pattern�� "A"�� "AA"��
		// ġȯ�Ѵ�.

		// pattern�� Ȯ���ڸ� �ش�
		pattern = pattern.replace("*", ".*");
		Pattern p = Pattern.compile(pattern);

		// * 2. �ݺ����� �̿��ؼ� ���� ���丮 ��, �Էµ� ���ϰ� ��ġ�ϴ� �͵鿡 ���ؼ�,
		// : ���� ���丮�� ���� ����� ��������, ���� ���� ���� Ȯ��
		File[] fileList = curDir.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			Matcher m = p.matcher(fileList[i].getName());
			if (m.matches()) {
				// * 2.1 �ݺ����� �̿��ؼ� ���κ��� �о keyword�� ���ԵǾ����� Ȯ���Ѵ�.
				// * (BufferedReader�� readLine()���)
				try (FileReader fr = new FileReader(fileList[i]); BufferedReader br = new BufferedReader(fr)) {
					// * 2.2 keyword�� ���Ե� ������ �߰��ϸ�, ���ι�ȣ�� �Բ� �ش� ������ ȭ�鿡 ����Ѵ�.
					String line = null;
					int cnt = 0;
					while ((line = br.readLine()) != null) {
						cnt++;
						if (line.matches(".*" + keyword + ".*"))
							System.out.printf("%d: %s\n", cnt, line);
					}
				}
			}else{
				System.out.println("�ٸ�");
			}
		}

		return;
	}
} // class
