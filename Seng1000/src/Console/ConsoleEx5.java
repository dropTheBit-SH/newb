package Console;

//[����5] ���� ���丮�� ���ϰ� ���丮�� ����� �����ִ� ��ɾ� dir�� �����ϼ���.
//dir�� �Է��ϸ� ��� ���ϰ� ���丮��, dir *ex?.* �� ���� ������ �Է��ϸ� ���ϰ� ��ġ�ϴ� ���� �Ǵ� ���丮�� ����� ��������Ѵ�.
//(���Ͽ��� '*'�� '?'�� ���ϵ� ī��� '*'�� ������ ���� ���ڰ� �� �� ������, '?'�� ������ �ѱ��ڸ� �ǹ��Ѵ�.
//  ����â���� dir��ɰ� ���ϵ�ī�带 �׽�Ʈ �غ��� �Ȱ��� ����� ������ ��������.)

import java.io.*;
import java.util.*;
import java.util.regex.*;

class ConsoleEx5 {
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
		if (input == null || "".equals(input))
			return;

		q.offer(input); // queue�� �����Ѵ�.

		// queue�� �ִ�ũ�⸦ ������ ���� ������ ���尪�� �����Ѵ�.
		if (((LinkedList) q).size() > MAX_SIZE)
			q.remove();
	}

	public static void history() {
		int i = 0;

		// LinkedList�� ������ �����ش�.
		LinkedList tmp = (LinkedList) q;
		ListIterator it = tmp.listIterator();

		while (it.hasNext()) {
			System.out.println(++i + "." + it.next());
		}
	}

	public static void dir() {
		String pattern = "";

		switch (argArr.length) {
		case 1: // dir�� �Է��� ��� ���� ���丮�� ��� ���ϰ� ���丮�� �����ش�.
			// * 1. �ݺ����� �̿��ؼ� ������丮�� ��� ������ ����� ����Ѵ�.(FileŬ������ listFiles()���)
			File[] fileList = curDir.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				// * 2. ���ǹ��� ���� ����ؼ� ���丮(����)�� ���, �̸��� �յڿ� '[' �� ']'�� �ٿ��� ����Ѵ�.
				// * (FileŬ������ isDirectory()�� ����ؼ� üũ)
				if (fileList[i].isFile())
					System.out.println(fileList[i].getName());
				else if (fileList[i].isDirectory())
					System.out.printf("[%s]\n", fileList[i].getName());
			}
			break;
		case 2: // dir�� ������ ���� �Է��� ���, ���� ��� dir *.class
			pattern = argArr[1];
			pattern = pattern.toUpperCase();// ���Ͽ��� ��ҹ��ڸ� �������� �ʵ��� �빮�ڷ� �����Ѵ�.
			pattern = pattern.replace("*", ".*");
			System.out.println(pattern);
			Pattern p = Pattern.compile(pattern);
			for(File f: curDir.listFiles()){
				String rst = f.getName().toUpperCase();
				Matcher m = p.matcher(rst);
				if(m.matches()){
					if(f.isDirectory())
						System.out.println("[" + f.getName() + "]");
					else System.out.println(f.getName());
				}
			}

			break;
		// * 1. �Էµ� ����(pattern)�� ���Խ� ǥ��(Regular Expression)�� �˸°� ġȯ�Ѵ�.
		// * StringŬ������ String replace(CharSequence target, CharSequence
		// replacement)�� �������.
		// * ���� ���, pattern = pattern.replace("A","AA")�� pattern�� "A"�� "AA"��
		// ġȯ�Ѵ�.

		// * 2. �ݺ����� �̿��ؼ� ���� ���丮 ��, �Էµ� ���ϰ� ��ġ�ϴ� �͵鸸 ����Ѵ�.
		// * �̶�, ���ǹ��� ���� ����ؼ� ���丮(����)�� ���, �̸��� �յڿ� '[' �� ']'�� �ٿ��� ����Ѵ�.
		// * (FileŬ������ isDirectory()�� ����ؼ� üũ)
		// * ��ҹ��ڱ����� ���� �ʱ� ���ؼ�, ���ϰ� ���������� �����̳� ���丮���� �빮�ڷ� �����ؾ��Ѵ�.
		// * String tmp = f.getName().toUpperCase();
		default:
			System.out.println("USAGE : dir [FILENAME]");
		} // switch
	} // dir()
} // class

// [������] - ���� �۾����� ������ C:\java1000\work\Console�� ���
// C:\java1000\work\Console>>dir
// ConsoleEx.class
// ConsoleEx.java
// ConsoleEx1.class
// ConsoleEx1.java
// ConsoleEx2.class
// ConsoleEx2.java
// ConsoleEx3.class
// ConsoleEx3.java
// ConsoleEx4.class
// ConsoleEx4.java
// ConsoleEx5.class
// ConsoleEx5.java
// [temp]
// C:\java1000\work\Console>>dir *.class
// ConsoleEx.class
// ConsoleEx1.class
// ConsoleEx2.class
// ConsoleEx3.class
// ConsoleEx4.class
// ConsoleEx5.class
// C:\java1000\work\Console>>dir *ex5.*
// ConsoleEx5.class
// ConsoleEx5.java
// C:\java1000\work\Console>>dir *ex5.????
// ConsoleEx5.java
// C:\java1000\work\Console>>q
