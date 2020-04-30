package ch11;
//[11-9] 문제11-8의 Student클래스에 반등수(classRank)를 저장하기 위한 인스턴스변수를 추가하였다. 
//반등수를 계산하고 반과 반등수로 오름차순 정렬하여 결과를 출력하시오.
//(1)~(2)에 알맞은 코드를 넣어 완성하시오.

import java.util.*;

class Student3 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank; // 전교등수
	int classRank; // 반등수

	Student3(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public int compareTo(Object o) {
		if (o instanceof Student3) {
			Student3 tmp = (Student3) o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage()
				+ "," + schoolRank + "," + classRank // 새로추가
		;
	}
} // class Student

//반별 내림차순, 총점 오름차순으로 정렬한다
class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student3 && o2 instanceof Student3){
			Student3 s1 = (Student3) o1;
			Student3 s2 = (Student3) o2;
			//반이 다르면, 반을 비교한다 - 내림차순
			if(s1.ban != s2.ban)
				return s1.ban < s2.ban ? -1 : 1;
			//반이 같으면, 총점을 비교한다 - 오름차순
			return s1.total > s2.total ? -1 : s1.total < s2.total ? 1 : 0;
		}else {
			System.out.println("형변환 오류!");
			return 1;
		}
	}
}

class Exercise11_9 {
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

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student3("이자바", 2, 1, 70, 90, 70));
		list.add(new Student3("안자바", 2, 2, 60, 100, 80));
		list.add(new Student3("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student3("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student3("김자바", 1, 2, 80, 80, 90));
		list.add(new Student3("육자바", 3, 1, 70, 90, 70));
		list.add(new Student3("칠자바", 3, 2, 70, 90, 70));
		list.add(new Student3("팔자바", 3, 3, 70, 90, 70));
		list.add(new Student3("구자바", 3, 4, 0, 0, 0));
		list.add(new Student3("십자바", 3, 5, 80, 80, 90));
		calculateSchoolRank(list);
		calculateClassRank(list);
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}