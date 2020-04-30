package ch11;

//[11-6] 다음의 코드는 성적평균의 범위별로 학생 수를 세기 위한 것이다. 
//TreeSet이 학생들의 평균을 기준으로 정렬하도록 compare(Object o1, Object o2)와 
//평균점수의 범위를 주면 해당 범위에 속한 학생의 수를 반환하는 getGroupCount()를 완성하라.
//[Hint] TreeSet의 subSet(Object from, Object to)를 사용하라.

import java.util.*;

class Exercise11_6 {

	//평균점수의 범위를 주면 해당 범위에 속한 학생의 수를 반환하는 getGroupCount()를 완성하라.
	//[Hint] TreeSet의 subSet(Object from, Object to)를 사용하라.
	static int getGroupCount(TreeSet tset, int from, int to) {
		
		TreeSet tmpSet = new TreeSet();
		//1. 평균점수를 가져온다 
			//1-1. tset 객체를 꺼낸다
		Iterator it = tset.iterator();
		while (it.hasNext()){
			//1-2. 꺼낸게 student가 맞는지 확인하고 맞으면 변환한다
			Object tmp = it.next(); 
			if(tmp instanceof Student){
				Student std = (Student) tmp;
			//1-3. student 클래스의 getAverage()를 호출해서 평균을 확인한다
				float stdAvg = std.getAverage(); 
		//2. 범위에 맞는지 확인하고, 값을 반환한다
				tmpSet.add(stdAvg);
			}
		}
		return tmpSet.subSet((float)from, (float)to).size();
	}

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() {
			//TreeSet이 학생들의 평균을 기준으로 정렬하도록 compare(Object o1, Object o2)
			public int compare(Object o1, Object o2) {
				//Student가 맞는지 확인하고 변환해서
				if(o1 instanceof Student && o2 instanceof Student){
					Student s1 = (Student)o1;
					Student s2 = (Student)o2;
					//Student 클래스의 getAverage()를 활용한다
					float t1 = s1.getAverage();
					float t2 = s2.getAverage();
					// 값이 크면 -1, 같거나 작으면 1 반환(동점자 때문에..)
					return t1 < t2 ? -1 : 1;
				}
				return -1;
			}
		});
		set.add(new Student("홍길동", 1, 1, 100, 100, 100));
		set.add(new Student("남궁성", 1, 2, 90, 70, 80));
		set.add(new Student("김자바", 1, 3, 80, 80, 90));
		set.add(new Student("이자바", 1, 4, 70, 90, 70));
		set.add(new Student("안자바", 1, 5, 60, 100, 80));
		Iterator it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
		System.out.println("[60~69] :" + getGroupCount(set, 60, 70));
		System.out.println("[70~79] :" + getGroupCount(set, 70, 80));
		System.out.println("[80~89] :" + getGroupCount(set, 80, 90));
		System.out.println("[90~100] :" + getGroupCount(set, 90, 101));
	}
}