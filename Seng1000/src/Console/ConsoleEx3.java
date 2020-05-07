package Console;

//[문제3] 사용자가 입력한 명령라인의 내용을 저장하는 save(String input)메서드와 
//사용자가 입력한 명령라인의 이력을 보여주는 history()메서드를 완성하세요.

import java.util.*;

class ConsoleEx3 {
	static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
	static LinkedList q = new LinkedList(); // 사용자가 입력한 내용을 저장할 큐(Queue)
	static final int MAX_SIZE = 5; // q(큐)에 저장될 수 있는 값의 개수

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // 한번만 생성해서 재사용하면 되므로 반복문 밖으로 이동

		while (true) {
			String prompt = ">>";
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
			} else if (command.equals("history")) { // equalsIgnoreCase대신 equals를 사용.
				history();
			} else {
				for (int i = 0; i < argArr.length; i++) {
					System.out.println(argArr[i]);
				}
			}
		} // while(true)
	} // main

	//사용자가 입력한 명령라인의 내용을 저장
	public static void save(String input) {
		if (input == null || "".equals(input))
			return;
//		1. queue에 저장한다. 
		q.add(input);
//		2. queue의 최대크기(MAX_SIZE)를 넣으면 제일 오래된 저장값을 삭제한다.
		//최대 크기를 넣으면... max size가 되면...?
		//제일 오래된 저장값...첫번째 값.......!!
		if(q.size() == MAX_SIZE+1){
			q.remove(q.getFirst());
		}
	}

	// 사용자가 입력한 최근 명령을 보여주는 메서드
	public static void history() {
		//1. LinkedList에 저장된 내용(최근 MAX_SIZE개의 명령어)을 보여준다.
		//전체를 보여주면 된다
		for(int i=0; i<q.size(); i++){
			System.out.printf("%d.%s\n",i+1,q.get(i));
		}
	}
} // class

// [실행결과]
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
