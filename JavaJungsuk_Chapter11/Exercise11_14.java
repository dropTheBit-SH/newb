package ch11;

//[11-14] 다음은 성적처리 프로그램의 일부이다. 
//Scanner클래스를 이용해서 화면으로부터 데이터를 입력하고 보여주는 기능을 완성하시오.
/*
테스트용 데이터
일자바,1,1,10,50,20
이자바,1,2,100,50,30
삼자바,1,3,100,50,90
사자바,1,4,80,50,20
오자바,1,5,10,80,40
육자바,3,2,100,50,20
칠자바,3,1,100,100,100
팔자바,2,1,10,50,20
구자바,2,2,10,80,20
십자바,2,3,10,50,90

 */
import java.io.*;
import java.util.*;

class Exercise11_14 {
	static ArrayList record = new ArrayList(); // 성적데이터를 저장할 공간
	static Scanner s = new Scanner(System.in);

	public static void main(String args[]) {
		while (true) {
			switch (displayMenu()) {
			case 1:
				inputRecord();
				break;
			case 2:
				displayRecord();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		} // while(true)
	}

//(1) menu를 보여주는 메서드
	static int displayMenu() {
		System.out.println("**************************************************");
		System.out.println("* 성적 관리 프로그램 *");
		System.out.println("**************************************************");
		System.out.println();
		System.out.println(" 1. 학생성적 입력하기 ");
		System.out.println();
		System.out.println(" 2. 학생성적 보기");
		System.out.println();
		System.out.println(" 3. 프로그램 종료 ");
		System.out.println();
		int menu = 0;
		// 1. 화면으로부터 메뉴를 입력받는다. 메뉴의 값은 1~3사이의 값이어야 한다. 
		while (true) {
			try {
				System.out.print("원하는 메뉴를 선택하세요.(1~3) : ");
				menu = Integer.parseInt(s.nextLine().trim());
				// 2. 1~3사이의 값을 입력받지 않으면, 메뉴의 선택이 잘못되었음을 알려주고 다시 입력받는다.
				if(!(menu >= 1 && menu <= 3))
					throw new Exception();
				// (유효한 값을 입력받을 때까지 반복해서 입력받는다.)
				else break;
			}catch (Exception e) {
				System.out.printf(" 메뉴 선택이 잘못되었습니다 \n\n");
			}
		}
		return menu;
	} // public static int displayMenu(){
	
//(2) 데이터를 입력받는 메서드
	static void inputRecord() {
		System.out.println("1. 학생성적 입력하기");
		System.out.println("이름,반,번호,국어성적,영어성적,수학성적'의 순서로 공백없이 입력하세요.");
		System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");
		while (true) {
			System.out.print(">>");
			try {
				String input = s.nextLine().trim();
				//입력받은 값이 q 또는 Q이면 메서드를 종료
				if(input.equalsIgnoreCase("Q"))
					return;
				//Scanner를 이용해서 화면으로부터 데이터를 입력받는다.(','를 구분자로) 
				//입력받은 값으로 Student인스턴스를 생성하고 record에 추가한다.
				Scanner sc = new Scanner(input).useDelimiter(",");
				Student3 std = new Student3(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
				record.add(std);
			// 입력받은 데이터에서 예외가 발생하면, "입력오류입니다."를 보여주고 다시 입력받는다. 
			}catch (Exception e) {
				System.out.printf(" 입력오류입니다.\n\n");
			}
			//q 또는 Q가 입력될 때까지 2~3의 작업을 반복한다.
			
		} // end of while
	} // public static void inputRecord() {
	
// 데이터 목록을 보여주는 메서드
	static void displayRecord() {
		int koreanTotal = 0;
		int englishTotal = 0;
		int mathTotal = 0;
		int total = 0;
		int length = record.size();
		if (length > 0) {
			calculateSchoolRank(record);
			calculateClassRank(record);
			System.out.println();
			System.out.println("이름 반 번호 국어 영어 수학 총점 평균 전교등수 반등수");
			System.out.println("====================================================");
			for (int i = 0; i < length; i++) {
				Student3 student = (Student3) record.get(i);
				System.out.println(student);
				koreanTotal += student.kor;
				mathTotal += student.math;
				englishTotal += student.eng;
				total += student.total;
			}
			System.out.println("====================================================");
			System.out.println("총점: " + koreanTotal + " " + englishTotal + " " + mathTotal + " " + total);
			System.out.println();
		} else {
			System.out.println("====================================================");
			System.out.println(" 데이터가 없습니다.");
			System.out.println("====================================================");
		}
		
	} // static void displayRecord() {
	public static void calculateClassRank(List list) {
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		// 1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
		for(int i=0, j=0; i<length; i++, j++){
			if(list.get(i) instanceof Student3){
				Student3 std = (Student3) list.get(i);
				// 1.1 반이 달라지면,(ban과 prevBan이 다르면) 이전 등수(prevRank)와 이전 총점(prevTotal)을 초기화한다. 
				if(std.ban != prevBan) {
					prevRank = -1;
					prevTotal = -1;
					j = 0;
				}
				// 1.2 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(classRank)로 한다. 
				if(std.total == prevTotal) 
					std.classRank = prevRank;
				// 1.3 총점이 서로 다르면, 등수(classRank)의 값을 알맞게 계산해서 저장한다. 
				// 이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야 한다. (실행결과 참고) 
				else
					std.classRank = j+1;
				// 1.4 현재 반과 총점과 등수를 이전 반(prevBan), 이전 총점(prevTotal), 이전 등수(prevRank)에 저장한다.
				prevBan = std.ban;
				prevTotal = std.total;
				prevRank = std.classRank;
			}else {
				System.out.println("형변환 오류!");
			}
		}
	}

	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.
		int prevRank = -1; // 이전 전교등수
		int prevTotal = -1; // 이전 총점
		int length = list.size();
		//1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다.
		for(int i=0; i<length; i++){
			if(list.get(i) instanceof Student3){
				Student3 std = (Student3) list.get(i);
				//1.1 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(schoolRank)로 한다. 
				if(std.total == prevTotal)
					std.schoolRank = prevRank;
				//1.2 총점이 서로 다르면, 등수(schoolRank)의 값을 알맞게 계산해서 저장한다. 
				//이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야 한다. (실행결과 참고) 
				else
					std.schoolRank = i+1;
				//1.3 현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
				prevRank = std.schoolRank;
				prevTotal = std.total;
			}else {
				System.out.println("형변환 오류!");
			}
		}
	}
}

