package Console;

//[����3] ����ڰ� �Է��� ��ɶ����� ������ �����ϴ� save(String input)�޼���� 
//����ڰ� �Է��� ��ɶ����� �̷��� �����ִ� history()�޼��带 �ϼ��ϼ���.

import java.util.*;

class ConsoleEx3 {
	static String[] argArr; // �Է��� �Ű������� ������� ���ڿ��迭
	static LinkedList q = new LinkedList(); // ����ڰ� �Է��� ������ ������ ť(Queue)
	static final int MAX_SIZE = 5; // q(ť)�� ����� �� �ִ� ���� ����

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // �ѹ��� �����ؼ� �����ϸ� �ǹǷ� �ݺ��� ������ �̵�

		while (true) {
			String prompt = ">>";
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
			} else if (command.equals("history")) { // equalsIgnoreCase��� equals�� ���.
				history();
			} else {
				for (int i = 0; i < argArr.length; i++) {
					System.out.println(argArr[i]);
				}
			}
		} // while(true)
	} // main

	//����ڰ� �Է��� ��ɶ����� ������ ����
	public static void save(String input) {
		if (input == null || "".equals(input))
			return;
//		1. queue�� �����Ѵ�. 
		q.add(input);
//		2. queue�� �ִ�ũ��(MAX_SIZE)�� ������ ���� ������ ���尪�� �����Ѵ�.
		//�ִ� ũ�⸦ ������... max size�� �Ǹ�...?
		//���� ������ ���尪...ù��° ��.......!!
		if(q.size() == MAX_SIZE+1){
			q.remove(q.getFirst());
		}
	}

	// ����ڰ� �Է��� �ֱ� ����� �����ִ� �޼���
	public static void history() {
		//1. LinkedList�� ����� ����(�ֱ� MAX_SIZE���� ��ɾ�)�� �����ش�.
		//��ü�� �����ָ� �ȴ�
		for(int i=0; i<q.size(); i++){
			System.out.printf("%d.%s\n",i+1,q.get(i));
		}
	}
} // class

// [������]
//
// >>hello
// hello
// >>hello2
// hello2
// >>hello3
// hello3
// >>hello4
// hello4
// >>history
// 1.hello
// 2.hello2
// 3.hello3
// 4.hello4
// 5.history
// >>history
// 1.hello2
// 2.hello3
// 3.hello4
// 4.history
// 5.history
// >>q
