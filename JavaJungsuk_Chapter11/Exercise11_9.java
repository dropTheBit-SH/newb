package ch11;
//[11-9] ����11-8�� StudentŬ������ �ݵ��(classRank)�� �����ϱ� ���� �ν��Ͻ������� �߰��Ͽ���. 
//�ݵ���� ����ϰ� �ݰ� �ݵ���� �������� �����Ͽ� ����� ����Ͻÿ�.
//(1)~(2)�� �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.

import java.util.*;

class Student3 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank; // �������
	int classRank; // �ݵ��

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
				+ "," + schoolRank + "," + classRank // �����߰�
		;
	}
} // class Student

//�ݺ� ��������, ���� ������������ �����Ѵ�
class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student3 && o2 instanceof Student3){
			Student3 s1 = (Student3) o1;
			Student3 s2 = (Student3) o2;
			//���� �ٸ���, ���� ���Ѵ� - ��������
			if(s1.ban != s2.ban)
				return s1.ban < s2.ban ? -1 : 1;
			//���� ������, ������ ���Ѵ� - ��������
			return s1.total > s2.total ? -1 : s1.total < s2.total ? 1 : 0;
		}else {
			System.out.println("����ȯ ����!");
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
		// 1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�.
		for(int i=0, j=0; i<length; i++, j++){
			if(list.get(i) instanceof Student3){
				Student3 std = (Student3) list.get(i);
				// 1.1 ���� �޶�����,(ban�� prevBan�� �ٸ���) ���� ���(prevRank)�� ���� ����(prevTotal)�� �ʱ�ȭ�Ѵ�. 
				if(std.ban != prevBan) {
					prevRank = -1;
					prevTotal = -1;
					j = 0;
				}
				// 1.2 ����(total)�� ��������(prevTotal)�� ������ ���� ���(prevRank)�� ���(classRank)�� �Ѵ�. 
				if(std.total == prevTotal) 
					std.classRank = prevRank;
				// 1.3 ������ ���� �ٸ���, ���(classRank)�� ���� �˸°� ����ؼ� �����Ѵ�. 
				// ������ �����ڿ��ٸ�, �� ���� ����� �������� ���� ����ؾ� �Ѵ�. (������ ����) 
				else
					std.classRank = j+1;
				// 1.4 ���� �ݰ� ������ ����� ���� ��(prevBan), ���� ����(prevTotal), ���� ���(prevRank)�� �����Ѵ�.
				prevBan = std.ban;
				prevTotal = std.total;
				prevRank = std.classRank;
			}else {
				System.out.println("����ȯ ����!");
			}
		}
	}

	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // ���� list�� �������� ������������ �����Ѵ�.
		int prevRank = -1; // ���� �������
		int prevTotal = -1; // ���� ����
		int length = list.size();
		//1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�.
		for(int i=0; i<length; i++){
			if(list.get(i) instanceof Student3){
				Student3 std = (Student3) list.get(i);
				//1.1 ����(total)�� ��������(prevTotal)�� ������ ���� ���(prevRank)�� ���(schoolRank)�� �Ѵ�. 
				if(std.total == prevTotal)
					std.schoolRank = prevRank;
				//1.2 ������ ���� �ٸ���, ���(schoolRank)�� ���� �˸°� ����ؼ� �����Ѵ�. 
				//������ �����ڿ��ٸ�, �� ���� ����� �������� ���� ����ؾ� �Ѵ�. (������ ����) 
				else
					std.schoolRank = i+1;
				//1.3 ���� ������ ����� ��������(prevTotal)�� �������(prevRank)�� �����Ѵ�.
				prevRank = std.schoolRank;
				prevTotal = std.total;
			}else {
				System.out.println("����ȯ ����!");
			}
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student3("���ڹ�", 2, 1, 70, 90, 70));
		list.add(new Student3("���ڹ�", 2, 2, 60, 100, 80));
		list.add(new Student3("ȫ�浿", 1, 3, 100, 100, 100));
		list.add(new Student3("���ü�", 1, 1, 90, 70, 80));
		list.add(new Student3("���ڹ�", 1, 2, 80, 80, 90));
		list.add(new Student3("���ڹ�", 3, 1, 70, 90, 70));
		list.add(new Student3("ĥ�ڹ�", 3, 2, 70, 90, 70));
		list.add(new Student3("���ڹ�", 3, 3, 70, 90, 70));
		list.add(new Student3("���ڹ�", 3, 4, 0, 0, 0));
		list.add(new Student3("���ڹ�", 3, 5, 80, 80, 90));
		calculateSchoolRank(list);
		calculateClassRank(list);
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}