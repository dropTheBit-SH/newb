package Console;

//[����9] ���丮�� �����ϴ� cd����� �����϶�. ��ɾ��� ������ 'cd DIRECTORY'�̸�
//DIRECTORY�� ���� ���丮�� ���� ���丮�̰ų� ���� ���丮�� �ǹ��ϴ� '.' �Ǵ�
//���� ���丮�� �ǹ��ϴ� '..'�� �� �� �ִ�.(������ ����)

import java.io.*;
import java.util.*;
import java.util.regex.*;

class ConsoleEx9 {
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
				} else if (command.equals("cd")) {
					cd();
				} else {
					for (int i = 0; i < argArr.length; i++) {
						System.out.println(argArr[i]);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
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
		/* ���� ���� */

	}

	public static void find2() throws IOException {
		if (argArr.length != 3) {
			System.out.println("USAGE : find2 KEYWORD FILE_NAME");
			return;
		}

		String keyword = argArr[1];
		String pattern = argArr[2];

		pattern = pattern.toUpperCase();
		pattern = pattern.replace(".", "\\.");
		pattern = pattern.replace("*", ".*");
		pattern = pattern.replace("?", ".{1}");

		Pattern p = Pattern.compile(pattern);

		for (File f : curDir.listFiles()) {
			String tmp = f.getName().toUpperCase();
			Matcher m = p.matcher(tmp);

			if (m.matches()) {
				if (f.isDirectory())
					continue;

				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);

				String line = "";

				System.out.println("----------------" + f.getName());
				for (int i = 1; (line = br.readLine()) != null; i++) {
					// keyword�� ������ ������ ����Ѵ�.
					if (line.indexOf(keyword) != -1)
						System.out.println(i + ":" + line);
				}
			}
		} // for

		return;
	}

	public static void cd() {

		if (argArr.length == 1) {
			System.out.println(curDir);
			return;
		} else if (argArr.length > 2) {
			System.out.println("USAGE : cd directory");
			return;
		}

		String subDir = argArr[1];

		// * 1. �Էµ� ���丮(subDir)�� ".."�̸�,
		if (subDir.equals("..")) {
			// * 1.1 ���� ���丮�� ���� ���丮�� �� ���� ���丮�� �����Ѵ�.
			// * (FileŬ������ getParentFile()�� ���)
			curDir = curDir.getParentFile();
			System.out.println(curDir.getPath());
		
		// * 2. �Էµ� ���丮(subDir)�� "."�̸�,
		} else if (subDir.equals(".")) {
			// * �ܼ��� ���� ���丮�� ��θ� ȭ�鿡 ����Ѵ�.
			System.out.println(curDir.getPath());

		// * 3. 1 �Ǵ� 2�� ��찡 �ƴϸ�,
		} else {
			// �Էµ� ���丮(subDir)�� ���� ���丮�� �������丮���� Ȯ���Ѵ�.
			// * 3.1 Ȯ�ΰ���� true�̸�, ���� ���丮(curDir)�� �Էµ� ���丮(subDir)�� �����Ѵ�.
			File sub = new File(subDir);
			if(sub.exists() && sub.getAbsoluteFile().getParent().equals(curDir.getPath())){
				curDir = sub;
			}else{
			// * 3.2 Ȯ�ΰ���� false�̸�, "��ȿ���� ���� ���丮�Դϴ�."�� ȭ�鿡 ����Ѵ�.
				System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			}
		}
	} // cd()
} // class
