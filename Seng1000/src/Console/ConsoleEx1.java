package Console;

//����â ó�� ��ɾ �Է��ϸ�
//��ɾ ����� ����� ȭ�鿡 �����ִ� �ؽ�Ʈ ����� ���ø����̼��Դϴ�.(text-based application)
//
//[����1] ������ �����ϸ� '>>'�� ���� ������Ʈ�� ��Ÿ���� ������� �Է��� ��ٸ���,
//            ����ڰ� �Է��� ������ ȭ�鿡 ����Ѵ�. ���� ����ڰ� 'q' �Ǵ� 'Q'�� �Է��ϸ� ���α׷��� �����Ѵ�.
//            ������ ������ �ϼ��ϼ���.

import java.util.*;

class ConsoleEx1 {
	public static void main(String[] args) {
		while (true) {
			String prompt = ">>";
			System.out.print(prompt);
			//1. ȭ�����κ��� ���δ����� �Է¹޴´�. - java.util.ScannerŬ���� ��� 
			Scanner s = new Scanner(System.in);
			String input = s.nextLine();
			//2. q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�.
			if(input.equalsIgnoreCase("q"))
				System.exit(0);
			System.out.println(input);
		} // while(true)
	} // main
} // class

// [������]
//
// >>hello
// hello
// >>help
// help
// >>ok
// ok
// >>q
