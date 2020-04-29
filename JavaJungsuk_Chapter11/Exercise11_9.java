package chapter11;
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
			if(s1.ban == s2.ban){
				return s1.total > s2.total ? -1 : s1.total < s2.total ? 1 : 0;
			}else{
				return s1.ban < s2.ban ? -1 : s1.ban < s2.ban ? 1 : 0;
			}
		}
		return 1;
	}
}

class Exercise11_9 {
	public static void calculateClassRank(List list) {
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		boolean flag = false;
		// (2) 1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�.
		for(int i=0; i<length; i++){
			if(list.get(i) instanceof Student3){
				Student3 tmp = (Student3) list.get(i);
				// 1.1 ���� �޶�����,(ban�� prevBan�� �ٸ���) ���� ���(prevRank)�� ���� ����(prevTotal)�� �ʱ�ȭ�Ѵ�. 
				// 1.2 ����(total)�� ��������(prevTotal)�� ������ ���� ���(prevRank)�� ���(classRank)�� �Ѵ�. 
				// 1.3 ������ ���� �ٸ���, ���(classRank)�� ���� �˸°� ����ؼ� �����Ѵ�. 
				// ������ �����ڿ��ٸ�, �� ���� ����� �������� ���� ����ؾ� �Ѵ�. (������ ����) 
				// 1.4 ���� �ݰ� ������ ����� ���� ��(prevBan), ���� ����(prevTotal), ���� ���(prevRank)�� �����Ѵ�.
			
			}
		}

	}

	public static void calculateSchoolRank(List list) {
		/* ���� ���� */
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student3("���ڹ�", 2, 1, 70, 90, 70));
		list.add(new Student3("���ڹ�", 2, 2, 60, 100, 80));
		list.add(new Student3("ȫ�浿", 1, 3, 100, 100, 100));
		list.add(new Student3("���ü�", 1, 1, 90, 70, 80));
		list.add(new Student3("���ڹ�", 1, 2, 80, 80, 90));
		calculateClassRank(list);
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}